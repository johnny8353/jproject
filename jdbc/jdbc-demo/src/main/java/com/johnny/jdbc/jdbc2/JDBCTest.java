package com.johnny.jdbc.jdbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void testResultSetMetaData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String sql = "SELECT flow_id flowId, type, id_card idCard, "
					+ "exam_card examCard, student_name studentName, "
					+ "location, grade " + "FROM examstudent WHERE flow_id = ?";
			
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 5);
			
			resultSet = preparedStatement.executeQuery();

			Map<String, Object> values = 
					new HashMap<String, Object>();
			
			//1. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				//2. 打印每一列的列名
				for(int i = 0; i < rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					
					values.put(columnLabel, columnValue);
				}
			}
			
//			System.out.println(values); 

			Class clazz = Student.class;
			
			Object object = clazz.newInstance();
			for(Map.Entry<String, Object> entry: values.entrySet()){
				String fieldName = entry.getKey();
				Object fieldValue = entry.getValue();
				
//				System.out.println(fieldName + ": " + fieldValue);
				
				ReflectionUtils.setFieldValue(object, fieldName, fieldValue);
			}
			
			System.out.println(object); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	@Test
	public void testGet() {
		String sql = "SELECT id, name, email, birth "
				+ "FROM customers WHERE id = ?";
//		System.out.println(sql);

		Customer customer = get(Customer.class, sql, 1);
		System.out.println(customer);

		sql = "SELECT flow_id flowId, type, id_card idCard, "
				+ "exam_card examCard, student_name studentName, "
				+ "location, grade " + "FROM examstudent WHERE flow_id = ?";
//		System.out.println(sql);

		Student stu = get(Student.class, sql, 2);
		System.out.println(stu);
	}

	/**
	 * 通用的查询方法：可以根据传入的 SQL、Class 对象返回 SQL 对应的记录的对象
	 * @param clazz: 描述对象的类型
	 * @param sql: SQL 语句。可能带占位符
	 * @param args: 填充占位符的可变参数。
	 * @return
	 */
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1. 得到 ResultSet 对象
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			//2. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			//3. 创建一个 Map<String, Object> 对象, 键: SQL 查询的列的别名, 
			//值: 列的值
			Map<String, Object> values = new HashMap<>();
			
			//4. 处理结果集. 利用 ResultSetMetaData 填充 3 对应的 Map 对象
			if(resultSet.next()){
				for(int i = 0; i < rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(i + 1);
					
					values.put(columnLabel, columnValue);
				}
			}
			
			//5. 若 Map 不为空集, 利用反射创建 clazz 对应的对象
			if(values.size() > 0){
				entity = clazz.newInstance();
				
				//5. 遍历 Map 对象, 利用反射为 Class 对象的对应的属性赋值. 
				for(Map.Entry<String, Object> entry: values.entrySet()){
					String fieldName = entry.getKey();
					Object value = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, value);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return entity;
	}

	public Customer getCustomer(String sql, Object... args) {
		Customer customer = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// stu = new Student();
				// stu.setFlowId(resultSet.getInt(1));
				// stu.setType(resultSet.getInt(2));
				// stu.setIdCard(resultSet.getString(3));

				customer = new Customer();
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setBirth(resultSet.getDate(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return customer;
	}

	public Student getStudent(String sql, Object... args) {
		Student stu = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				stu = new Student();
				stu.setFlowId(resultSet.getInt(1));
				stu.setType(resultSet.getInt(2));
				stu.setIdCard(resultSet.getString(3));
				// ...
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return stu;
	}

	/**
	 * 使用 PreparedStatement 将有效的解决 SQL 注入问题.
	 */
	@Test
	public void testSQLInjection2() {
		String username = "a' OR PASSWORD = ";
		String password = " OR '1'='1";

		String sql = "SELECT * FROM users WHERE username = ? "
				+ "AND password = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("登录成功!");
			} else {
				System.out.println("用户名和密码不匹配或用户名不存在. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	/**
	 * SQL 注入.
	 */
	@Test
	public void testSQLInjection() {
		String username = "a' OR PASSWORD = ";
		String password = " OR '1'='1";

		String sql = "SELECT * FROM users WHERE username = '" + username
				+ "' AND " + "password = '" + password + "'";

		System.out.println(sql);

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				System.out.println("登录成功!");
			} else {
				System.out.println("用户名和密码不匹配或用户名不存在. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}
	}

	@Test
	public void testPreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "INSERT INTO customers (name, email, birth) "
					+ "VALUES(?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "johnny");
			preparedStatement.setString(2, "simpleit@163.com");
			preparedStatement.setDate(3,
					new Date(new java.util.Date().getTime()));

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

	@Test
	public void testGetStudent() {
		// 1. 得到查询的类型
		int searchType = getSearchTypeFromConsole();

		// 2. 具体查询学生信息
		Student student = searchStudent(searchType);

		// 3. 打印学生信息
		printStudent(student);
	}

	/**
	 * 打印学生信息: 若学生存在则打印其具体信息. 若不存在: 打印查无此人.
	 * 
	 * @param student
	 */
	private void printStudent(Student student) {
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("查无此人!");
		}
	}

	/**
	 * 具体查询学生信息的. 返回一个 Student 对象. 若不存在, 则返回 null
	 * 
	 * @param searchType
	 *            : 1 或 2.
	 * @return
	 */
	private Student searchStudent(int searchType) {

		String sql = "SELECT flowid, type, idcard, examcard,"
				+ "studentname, location, grade " + "FROM examstudent "
				+ "WHERE ";

		Scanner scanner = new Scanner(System.in);

		// 1. 根据输入的 searchType, 提示用户输入信息:
		// 1.1 若 searchType 为 1, 提示: 请输入身份证号. 若为 2 提示: 请输入准考证号
		// 2. 根据 searchType 确定 SQL
		if (searchType == 1) {
			System.out.print("请输入准考证号:");
			String examCard = scanner.next();
			sql = sql + "examcard = '" + examCard + "'";
		} else {
			System.out.print("请输入身份证号:");
			String examCard = scanner.next();
			sql = sql + "idcard = '" + examCard + "'";
		}

		// 3. 执行查询
		Student student = getStudent(sql);

		// 4. 若存在查询结果, 把查询结果封装为一个 Student 对象

		return student;
	}

	/**
	 * 根据传入的 SQL 返回 Student 对象
	 * 
	 * @param sql
	 * @return
	 */
	private Student getStudent(String sql) {

		Student stu = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				stu = new Student(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}

		return stu;
	}

	/**
	 * 从控制台读入一个整数, 确定要查询的类型
	 * 
	 * @return: 1. 用身份证查询. 2. 用准考证号查询 其他的无效. 并提示请用户重新输入.
	 */
	private int getSearchTypeFromConsole() {

		System.out.print("请输入查询类型: 1. 用身份证查询. 2. 用准考证号查询 ");

		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("输入有误请重新输入!");
			throw new RuntimeException();
		}

		return type;
	}

	@Test
	public void testAddNewStudent() {
		Student student = getStudentFromConsole();
		addNewStudent2(student);
	}

	/**
	 * 从控制台输入学生的信息
	 */
	private Student getStudentFromConsole() {

		Scanner scanner = new Scanner(System.in);

		Student student = new Student();

		System.out.print("FlowId:");
		student.setFlowId(scanner.nextInt());

		System.out.print("Type: ");
		student.setType(scanner.nextInt());

		System.out.print("IdCard:");
		student.setIdCard(scanner.next());

		System.out.print("ExamCard:");
		student.setExamCard(scanner.next());

		System.out.print("StudentName:");
		student.setStudentName(scanner.next());

		System.out.print("Location:");
		student.setLocation(scanner.next());

		System.out.print("Grade:");
		student.setGrade(scanner.nextInt());

		return student;
	}

	public void addNewStudent2(Student student) {
		String sql = "INSERT INTO examstudent(flowid, type, idcard, "
				+ "examcard, studentname, location, grade) "
				+ "VALUES(?,?,?,?,?,?,?)";

		JDBCTools.update(sql, student.getFlowId(), student.getType(),
				student.getIdCard(), student.getExamCard(),
				student.getStudentName(), student.getLocation(),
				student.getGrade());
	}

	
	public void addNewStudent(Student student) {
		// 1. 准备一条 SQL 语句:
		String sql = "INSERT INTO examstudent VALUES(" + student.getFlowId()
				+ "," + student.getType() + ",'" + student.getIdCard() + "','"
				+ student.getExamCard() + "','" + student.getStudentName()
				+ "','" + student.getLocation() + "'," + student.getGrade()
				+ ")";

		System.out.println(sql);

		// 2. 调用 JDBCTools 类的 update(sql) 方法执行插入操作.
		JDBCTools.update(sql);
	}
	
	@Test
	public void testGetConnection() throws Exception{
		System.out.println(JDBCTools.getConnection());
	}

}
