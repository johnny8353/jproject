package com.test.util;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

import com.fasterxml.jackson.databind.*;

public class GoogleMapUtil {

	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Properties props = new Properties();
			props.put("remarksReporting", "true");
			props.put("user", "bigdata");
			props.put("password", "bigdata");
			
			//(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = 10.88.144.47)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = bigprod)))
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.88.144.47:1521:bigprod", props);
			// connection =
			// DriverManager.getConnection(dbconfig.getConnectionURL(),dbconfig.getUserId(),dbconfig.getPassword());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return connection;
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// ignore
				;
			}
		}
	}

	private void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// ignore
				;
			}
		}
	}

	/**
	 * 获取数据库中的国家和城市列表
	 * 
	 * @return
	 */
	public List<CountryCity> getCountryCity() {

		List<CountryCity> list = new ArrayList<CountryCity>();

		Connection connection = null;
		try {
			connection = getConnection();

			PreparedStatement pstmt = connection
					.prepareStatement("select distinct t.country, t.city from position t where t.logdate>='2015-07-01'");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				CountryCity obj = new CountryCity();
				obj.setCountry(rs.getString(1));
				obj.setCity(rs.getString(2));

				list.add(obj);
			}

			closeResultSet(rs);
			pstmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return list;
	}

	/**
	 * 保存数据库中的国家和城市坐标
	 * 
	 * @return
	 */
	public void saveMap(List<CountryCity> list) {

		Connection connection = null;

		CountryCity val;
		try {
			connection = getConnection();

			PreparedStatement pstmt = connection
					.prepareStatement("insert into  GOOGLEWORLDMAP (COUNTRY,CITY,GLAT,GLNG) values(?,?,?,?)");

			for (int i = 0; i < list.size(); i++) {
				val = list.get(i);

				if (val.getCountry() != null)
					pstmt.setString(1, val.getCountry());
				else
					pstmt.setString(1, "");

				if (val.getCity() != null)
					pstmt.setString(2, val.getCity());
				else
					pstmt.setString(2, "");

				if (val.getGlat() != null)
					pstmt.setString(3, val.getGlat());
				else
					pstmt.setString(3, "");

				if (val.getGlng() != null)
					pstmt.setString(4, val.getGlng());
				else
					pstmt.setString(4, "");

				pstmt.execute();
			}

			pstmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return;
	}

	/**
	 * 获取GOOGLE坐标数据
	 * 
	 * @param countrycity
	 */
	public void getGoogleMap(CountryCity countrycity) {
		// String url =
		// "http://ditu.google.cn/maps/api/geocode/json?address=纽约&sensor=false&language=zh&components=country:美国";
		String url = "http://ditu.google.cn/maps/api/geocode/json?sensor=false&language=zh";

		// 代理的设置
		HttpHost proxy = new HttpHost("10.3.76.8", 80);

		// 实例化验证
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		// 设定验证内容
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
				"10027909", "ft07");
		// 创建验证
		credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST,
				AuthScope.ANY_PORT), creds);

		// 创建一个HttpClient对象
		CloseableHttpClient httpclient = HttpClients.custom().setProxy(proxy)
				.setDefaultCredentialsProvider(credsProvider).build();

		String jsonstr = null;
		try {
			String country = countrycity.getCountry();
			String city = countrycity.getCity();
			if (city == null)
				city = country;

			HttpUriRequest getdata = RequestBuilder.get().setUri(new URI(url))
					.addParameter("components", "country:" + country)
					.addParameter("address", city)
					// .addParameter("sort", sort)
					.build();
			CloseableHttpResponse response = null;
			
			try {
				response = httpclient.execute(getdata);
				HttpEntity entity = response.getEntity();

				StatusLine statusLine = response.getStatusLine();

				// System.out.println(statusLine);
				// if(statusLine != null && statusLine.getStatusCode()==200 ){
				// 获取成功
				jsonstr = EntityUtils.toString(entity);

				// System.out.println(jsonstr);

				// 解吸JSON获取第一个坐标
				if (jsonstr != null) {
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = null;
					try {
						root = mapper.readTree(jsonstr);

						String lat = root.get("results").get(0).get("geometry")
								.get("location").get("lat").asText();
						String lng = root.get("results").get(0).get("geometry")
								.get("location").get("lng").asText();

						countrycity.setGlat(lat);
						countrycity.setGlng(lng);
						// String lat =
						// root.get("results.geometry.location.lat").asText();
						// String lng =
						// root.get("results.geometry.location.lng").asText();
						// System.out.println(lat+","+lng);
						System.out.println(countrycity.getCountry() + "-"+ countrycity.getCity() + ":"
								+ countrycity.getGlat() + "," + countrycity.getGlng());
					} catch (Exception jex) {
						jex.printStackTrace();
					}
				}
				// }

			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(jsonstr);
			} finally {
				response.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public void getGoogleMaps(List<CountryCity> list) {

		try {
			for (int i = 0; i < list.size(); i++) {
				CountryCity countrycity = list.get(i);
				
				System.out.println("开始获取坐标:" + countrycity.getCountry() + "-"+ countrycity.getCity());
				
				getGoogleMap(countrycity);				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoogleMapUtil util = new GoogleMapUtil();
		List<CountryCity> list = util.getCountryCity();
		if(list.size()>0){
			util.getGoogleMaps(list);
			util.saveMap(list);
		}
		
		
		// util.saveMap(list);
		// System.out.println(list.size());
		
		/*
		CountryCity countrycity = util.new CountryCity();
		countrycity.setCountry("中国");
		util.getGoogleMap(countrycity);
		System.out.println(countrycity.getCountry() + ":"
				+ countrycity.getGlat() + "," + countrycity.getGlng());
		*/
	}

	public class CountryCity {
		String country = null;
		String city = null;
		String glat = null;
		String glng = null;

		public CountryCity() {

		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getGlat() {
			return glat;
		}

		public void setGlat(String glat) {
			this.glat = glat;
		}

		public String getGlng() {
			return glng;
		}

		public void setGlng(String glng) {
			this.glng = glng;
		}

	}

}
