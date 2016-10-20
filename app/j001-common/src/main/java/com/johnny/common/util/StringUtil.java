package com.johnny.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述：关于字符串的一些实用操作
 * 
 * @author Administrator
 * @Date Jul 18, 2008
 * @Time 2:19:47 PM
 * @version 1.0
 */
public class StringUtil {

	/**
	 * 功能描述：分割字符串
	 * 
	 * @param str
	 *            String 原始字符串
	 * @param splitsign
	 *            String 分隔符
	 * @return String[] 分割后的字符串数组
	 */
	@SuppressWarnings("unchecked")
	public static String[] split(String str, String splitsign) {
		int index;
		if (str == null || splitsign == null) {
			return null;
		}
		ArrayList al = new ArrayList();
		while ((index = str.indexOf(splitsign)) != -1) {
			al.add(str.substring(0, index));
			str = str.substring(index + splitsign.length());
		}
		al.add(str);
		return (String[]) al.toArray(new String[0]);
	}

	/**
	 * 功能描述：替换字符串
	 * 
	 * @param from
	 *            String 原始字符串
	 * @param to
	 *            String 目标字符串
	 * @param source
	 *            String 母字符串
	 * @return String 替换后的字符串
	 */
	public static String replace(String from, String to, String source) {
		if (source == null || from == null || to == null)
			return null;
		StringBuffer str = new StringBuffer("");
		int index = -1;
		while ((index = source.indexOf(from)) != -1) {
			str.append(source.substring(0, index) + to);
			source = source.substring(index + from.length());
			index = source.indexOf(from);
		}
		str.append(source);
		return str.toString();
	}

	/**
	 * 替换字符串，能能够在HTML页面上直接显示(替换双引号和小于号)
	 * 
	 * @param str
	 *            String 原始字符串
	 * @return String 替换后的字符串
	 */
	public static String htmlencode(String str) {
		if (str == null) {
			return null;
		}
		return replace("\"", "&quot;", replace("<", "&lt;", str));
	}

	/**
	 * 替换字符串，将被编码的转换成原始码（替换成双引号和小于号）
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String htmldecode(String str) {
		if (str == null) {
			return null;
		}

		return replace("&quot;", "\"", replace("&lt;", "<", str));
	}

	private static final String _BR = "<br/>";

	/**
	 * 功能描述：在页面上直接显示文本内容，替换小于号，空格，回车，TAB
	 * 
	 * @param str
	 *            String 原始字符串
	 * @return String 替换后的字符串
	 */
	public static String htmlshow(String str) {
		if (str == null) {
			return null;
		}

		str = replace("<", "&lt;", str);
		str = replace(" ", "&nbsp;", str);
		str = replace("\r\n", _BR, str);
		str = replace("\n", _BR, str);
		str = replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;", str);
		return str;
	}

	/**
	 * 功能描述：返回指定字节长度的字符串
	 * 
	 * @param str
	 *            String 字符串
	 * @param length
	 *            int 指定长度
	 * @return String 返回的字符串
	 */
	public static String toLength(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length <= 0) {
			return "";
		}
		try {
			if (str.getBytes("GBK").length <= length) {
				return str;
			}
		} catch (Exception e) {
		}
		StringBuffer buff = new StringBuffer();

		int index = 0;
		char c;
		length -= 3;
		while (length > 0) {
			c = str.charAt(index);
			if (c < 128) {
				length--;
			} else {
				length--;
				length--;
			}
			buff.append(c);
			index++;
		}
		buff.append("...");
		return buff.toString();
	}

	/**
	 * 功能描述：判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是不是合法字符 c 要判断的字符
	 */
	public static boolean isLetter(String str) {
		if (str == null || str.length() < 0) {
			return false;
		}
		Pattern pattern = Pattern.compile("[\\w\\.-_]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 从指定的字符串中提取Email content 指定的字符串
	 * 
	 * @param content
	 * @return
	 */
	public static String parse(String content) {
		String email = null;
		if (content == null || content.length() < 1) {
			return email;
		}
		// 找出含有@
		int beginPos;
		int i;
		String token = "@";
		String preHalf = "";
		String sufHalf = "";

		beginPos = content.indexOf(token);
		if (beginPos > -1) {
			// 前项扫描
			String s = null;
			i = beginPos;
			while (i > 0) {
				s = content.substring(i - 1, i);
				if (isLetter(s))
					preHalf = s + preHalf;
				else
					break;
				i--;
			}
			// 后项扫描
			i = beginPos + 1;
			while (i < content.length()) {
				s = content.substring(i, i + 1);
				if (isLetter(s))
					sufHalf = sufHalf + s;
				else
					break;
				i++;
			}
			// 判断合法性
			email = preHalf + "@" + sufHalf;
			if (isEmail(email)) {
				return email;
			}
		}
		return null;
	}

	/**
	 * 功能描述：判断输入的字符串是否符合Email样式.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.length() < 1 || email.length() > 256) {
			return false;
		}
		Pattern pattern = Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(email).matches();
	}

	/**
	 * 功能描述：判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 功能描述：是否为空白,包括null和""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 功能描述：判断是否为质数
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7)
				return true;
		}
		int c = 7;
		if (x % 2 == 0)
			return false;
		if (x % 3 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

	/**
	 * 功能描述：人民币转成大写
	 * 
	 * @param str
	 *            数字字符串
	 * @return String 人民币转换成大写后的字符串
	 */
	public static String hangeToBig(String str) {
		double value;
		try {
			value = Double.parseDouble(str.trim());
		} catch (Exception e) {
			return null;
		}
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		long midVal = (long) (value * 100); // 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串

		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0; // 连续0次数清零
			if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0']; // 转化该数字表示
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
			}
		}

		if (prefix.length() > 0)
			prefix += '圆'; // 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}

	/**
	 * 功能描述：去掉字符串中重复的子字符串
	 * 
	 * @param str
	 *            原字符串，如果有子字符串则用空格隔开以表示子字符串
	 * @return String 返回去掉重复子字符串后的字符串
	 */
	@SuppressWarnings("unused")
	private static String removeSameString(String str) {
		Set<String> mLinkedSet = new LinkedHashSet<String>();// set集合的特征：其子集不可以重复
		String[] strArray = str.split(" ");// 根据空格(正则表达式)分割字符串
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < strArray.length; i++) {
			if (!mLinkedSet.contains(strArray[i])) {
				mLinkedSet.add(strArray[i]);
				sb.append(strArray[i] + " ");
			}
		}
		System.out.println(mLinkedSet);
		return sb.toString();
	}

	/**
	 * 功能描述：过滤特殊字符
	 * 
	 * @param src
	 * @return
	 */
	public static String encoding(String src) {
		if (src == null)
			return "";
		StringBuilder result = new StringBuilder();
		if (src != null) {
			src = src.trim();
			for (int pos = 0; pos < src.length(); pos++) {
				switch (src.charAt(pos)) {
				case '\"':
					result.append("&quot;");
					break;
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case '\'':
					result.append("&apos;");
					break;
				case '&':
					result.append("&amp;");
					break;
				case '%':
					result.append("&pc;");
					break;
				case '_':
					result.append("&ul;");
					break;
				case '#':
					result.append("&shap;");
					break;
				case '?':
					result.append("&ques;");
					break;
				default:
					result.append(src.charAt(pos));
					break;
				}
			}
		}
		return result.toString();
	}

	/**
	 * 功能描述：判断是不是合法的手机号码
	 * 
	 * @param handset
	 * @return boolean
	 */
	public static boolean isHandset(String handset) {
		try {
			String regex = "^1[\\d]{10}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(handset);
			return matcher.matches();

		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * 功能描述：反过滤特殊字符
	 * 
	 * @param src
	 * @return
	 */
	public static String decoding(String src) {
		if (src == null)
			return "";
		String result = src;
		result = result.replace("&quot;", "\"").replace("&apos;", "\'");
		result = result.replace("&lt;", "<").replace("&gt;", ">");
		result = result.replace("&amp;", "&");
		result = result.replace("&pc;", "%").replace("&ul", "_");
		result = result.replace("&shap;", "#").replace("&ques", "?");
		return result;
	}

	/**
	 * 把一个字符串变换为加密字符串
	 */
	public static String PwdEncode(String str) {
		if (str == null)
			return null;
		byte[] barray = str.getBytes();
		if (barray == null)
			return null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			barray = md.digest(barray);
		} catch (Exception e) {
			barray = str.getBytes();
		}

		StringBuffer desStr = new StringBuffer("");
		int y = barray.length / 3;
		int z = barray.length % 3;
		int i;
		for (i = 0; i < y; i++)
			encode64(barray, i * 3, 3, desStr);
		if (z > 0)
			encode64(barray, i * 3, z, desStr);
		return desStr.toString();
	}

	private static void encode64(byte[] bb, int index, int len, StringBuffer sb) {
		byte cc = 0;
		byte mm = 0x03;
		int i, j;
		for (i = 0, j = 2; i < len; i++, j += 2) {
			cc |= ((bb[i + index] & 0x0ff) >> j);
			append64(sb, cc);
			cc = (byte) (bb[i + index] & mm);
			cc <<= 4 - i * 2;
			mm <<= 2;
			mm |= 0x03;
		}
		append64(sb, cc);
		for (; i < 3; i++)
			append64(sb, (byte) 64);
	}

	private static void append64(StringBuffer sb, byte bb) {
		if (bb < 26)
			sb.append((char) (bb + 'A'));
		else if (bb < 52)
			sb.append((char) (bb - 26 + 'a'));
		else if (bb < 62)
			sb.append((char) (bb - 52 + '0'));
		else if (bb == 62)
			sb.append('+');
		else if (bb == 63)
			sb.append('!');
		else
			sb.append('=');
	}

	/**
	 * 把给定的字符串转化为定宽字符串，若源串长则裁掉，若不足则在尾端补足
	 */
	public static String fixedWidthString(String str, int width, char fill) {
		if (str == null)
			str = "";
		StringBuffer sb = new StringBuffer(str);
		int len = sb.length();

		if (len >= width) {
			sb.setLength(width);
			return sb.toString();
		}

		for (int i = len; i < width; i++)
			sb.append(fill);
		return sb.toString();
	}

	/**
	 * 把给定的中文全角字符串转化为定宽字符串，若源串长则裁掉，若不足则在尾端补足。 保证转化后的字符串只包含中文全角字符。
	 */
	public static String fixedWidthStringDBCS(String str, int width, char fill) {
		if (str == null)
			str = "";
		if (fill < 256)
			fill = '　';
		StringBuffer sb = new StringBuffer();

		int i = 0;
		for (; i < str.length() && i < width; i++) {
			int c = str.charAt(i);
			if (c >= 'a' && c <= 'z') { // ａｚＡＺ　０１９
				c = c + 'ａ' - 'a';
			} else if (c >= 'A' && c <= 'Z') {
				c = c + 'Ａ' - 'A';
			} else if (c >= '0' && c <= '9') {
				c = c + '０' - '0';
			} else if (c < 256) {
				c = fill;
			}

			sb.append((char) c);
		}

		for (; i < width; i++) {
			sb.append(fill);
		}

		return sb.toString();
	}

	/**
	 * 从给定的字符串中解析出一个整数，如果解析失败，返回指定的默认值
	 */
	public static int parseInt(String str, int def) {
		int r = def;
		try {
			r = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从给定的字符串中解析出一个 long 数值，如果解析失败，返回指定的默认值
	 */
	public static long parseLong(String str, long def) {
		long r = def;
		try {
			r = Long.parseLong(str);
		} catch (NumberFormatException e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从给定的字符串中解析出一个 float 数值，如果解析失败，返回指定的默认值
	 */
	public static float parseFloat(String str, float def) {
		float r = def;
		try {
			r = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从给定的字符串中解析出一个 double 数值，如果解析失败，返回指定的默认值
	 */
	public static double parseDouble(String str, double def) {
		double r = def;
		try {
			r = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			r = def;
		}
		return r;
	}

	/**
	 * 把给定的字符串理解为二进制数，从中解析出一个长整数，如果解析失败，返回指定的默认值
	 */
	public static long parseBinary(String str, long def) {
		long r = def;
		try {
			r = Long.parseLong(str, 2);
		} catch (NumberFormatException e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从给定的字符串中解析出一个 Time，如果解析失败，返回指定的默认值<br>
	 * 字符串的格式为 hh:mm:si（如 15:3:30）
	 */
	public static Time parseTime(String str, Time def) {
		Time r = def;
		try {
			int hour, minute, second;
			String token;
			int idx1 = 0;
			int idx2 = str.indexOf(':');
			hour = Integer.parseInt(str.substring(idx1, idx2));
			idx1 = idx2 + 1;
			idx2 = str.indexOf(':', idx1);
			minute = Integer.parseInt(str.substring(idx1, idx2));
			second = Integer.parseInt(str.substring(idx2 + 1));
			r = new Time(hour, minute, second);
		} catch (Exception e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从给定的字符串中解析出一个 Timestamp，如果解析失败，返回指定的默认值<br>
	 * 字符串的格式为 yyyy-MM-dd HH:mm:ss（如 2001-07-19 15:52:08）
	 */
	public static Timestamp parseTimestamp(String str, Timestamp def) {
		return parseTimestampWithFormat("yyyy-MM-dd HH:mm:ss", str, def);
	}

	/**
	 * 按指定格式从给定的字符串中解析出一个 Timestamp，如果解析失败，返回指定的默认值<br>
	 */
	public static Timestamp parseTimestampWithFormat(String format, String str,
			Timestamp def) {
		Timestamp r = def;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			java.util.Date d = formatter.parse(str);
			if (d != null) {
				r = new Timestamp(d.getTime());
			}
		} catch (Exception e) {
			r = def;
		}
		return r;
	}

	/**
	 * 从当前系统时间获得一个格式化的字符串。
	 * <p>
	 * 常用的格式有：<br>
	 * <li>"yyyyMMdd"
	 * <li>"yyyyMMdd_HHmmss"
	 * <li>"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @see StringUtil#getDateWithFormat(java.util.Date, String)
	 * @see "java.text.SimpleDateFormat"
	 */
	public static String getDateWithFormat(String format) {
		java.util.Date d = new java.util.Date();
		return getDateWithFormat(d, format);
	}

	/**
	 * 从 Date 获得一个格式化的字符串。
	 * 
	 * @see StringUtil#getDateWithFormat(String)
	 */
	public static String getDateWithFormat(java.util.Date d, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(d);
	}

	/** 判断一个字符串是否为合法时间 ,allowLarge：true为可以大于当前日期,allowNull:true:为可以为空 */
	public static String isValidDate(String str, String title,
			boolean allowLarge, boolean allowNull) {

		if (str == null) {
			if (allowNull) {
				return null;
			} else {
				return title + "不可以为空!";
			}
		}
		// date check
		String dateNow = getDateWithFormat("yyyy-MM-dd");
		String dateStr = getDateWithStr(str);

		if (!allowLarge && dateNow.compareTo(dateStr) < 0) {
			return title + "大于当前日期!";
		}

		return null;
	}

	/**
	 * 将一个字符串格式化为yyyy-MM-dd，不成功为null
	 */
	public static String getDateWithStr(String str) {
		String sDate = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = formatter.parse(str);
			sDate = formatter.format(d);
		} catch (Exception e) {
			return null;
		}

		return sDate;
	}

	/**
	 * 将一个格式为yyyy-MM-dd的字符串转化为yyyy-MM-dd 00:00:00或者yyyy-MM-dd 23:59:59格式的字符串
	 * 
	 * @param formatDate
	 *            源字符串（格式为yyyy-MM-dd）
	 * @param isBeginDate
	 *            转化标志；<br />
	 *            true - 转化为yyyy-MM-dd 00:00:00格式的字符串<br />
	 *            false - 转化为yyyy-MM-dd 23:59:59格式的字符串
	 * 
	 * @return String 格式为yyyy-MM-dd HH:mm:ss的字符串，如果转化过程失败，返回""
	 */
	public static String getEdgeDateByFormatStr(String formatDate,
			boolean isBeginDate) {
		String sDate = "";
		try {
			sDate = getDateWithStr(formatDate);
			if (sDate != null) {
				if (isBeginDate) {// 转化成开始时间
					sDate = sDate + " 00:00:00";
				} else {// 转化成结束时间
					sDate = sDate + " 23:59:59";
				}
			} else {
				sDate = "";
			}
		} catch (Exception e) {
			sDate = "";
		}

		return sDate;
	}

	/** 判断一个字符串是否只由空格、字母、数字、下划线组成 */
	public static boolean isSimpleName(String str) {
		if (str == null)
			return true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isLetterOrDigit(c))
				continue;
			if (c == ' ')
				continue;
			if (c == '_')
				continue;
			return false;
		}
		return true;
	}

	/** 计算字符串的字节长度 */
	public static int byteLength(String str) {
		if (str == null)
			return 0;
		int r = 0;
		try {
			byte[] b = str.getBytes("gb2312");
			r = b.length;
		} catch (UnsupportedEncodingException e) {
		}
		return r;
	}

	/**
	 * 对给定的 URL，剪除掉所有 QueryString
	 */
	public static String trimQueryString(String url) {
		int i = url.indexOf('?');
		if (i < 0)
			return url;
		return url.substring(0, i);
	}

	/**
	 * 把给定的字符串切成字节长度在限定范围以内的若干字符串
	 */
	public static String[] cutString(String str, int byteLen) {
		Vector v = new Vector();
		StringBuffer sb = new StringBuffer();
		int len = 0;
		char c = 0;
		int i = 0;
		while (i < str.length()) {
			c = str.charAt(i);
			if (c < 128)
				len++;
			else
				len += 2;

			if (len > byteLen) {
				v.add(sb.toString());
				len = 0;
				sb.setLength(0);
				continue;
			}

			sb.append(c);
			i++;
		}

		if (sb.length() > 0)
			v.add(sb.toString());

		String[] r = new String[v.size()];
		for (i = 0; i < v.size(); i++)
			r[i] = (String) v.get(i);
		return r;
	}

	/**
	 * Trim the str null to ""
	 */
	public static String trimBlank(String str) {
		String temp = "";
		try {
			if (str != null)
				temp = str.trim();
		} catch (Exception e) {
		} finally {
			return temp;
		}
	}

	/**
	 * Trim the str null not changed
	 */
	public static String trimNull(String str) {
		String temp = null;
		try {
			if (str != null)
				temp = str.trim();
		} catch (Exception e) {
		} finally {
			return temp;
		}
	}

	/**
	 * 将Calendar转换为格式为yyyy-mm-dd hh24-mi-ss的字符串
	 */
	public static String getStrFormCalendar(Calendar fromTime, String split) {

		if (split == null)
			split = "";

		String str = "" + fromTime.get(Calendar.YEAR);
		str += split + (fromTime.get(Calendar.MONTH) + 1);
		str += split + fromTime.get(Calendar.DAY_OF_MONTH);
		str += " " + fromTime.get(Calendar.HOUR_OF_DAY);
		str += split + fromTime.get(Calendar.MINUTE);
		str += split + fromTime.get(Calendar.SECOND);
		return str;
	}

	/**
	 * 十进制数字校验,返回str,null表示失败,patch为要补齐的字符,patch为*时不补位
	 */
	public static String decadeCheck(String str, long len, String patch) {
		long lStr = 0;
		String okStr = "0123456789";

		lStr = str.length();

		if (lStr != len && patch == null) {
			return null;
		}// 长度要一致
		if (patch != null && byteLength(patch) > 1) {
			return null;
		}

		// patch==null,必须长度符合，patch!=null,不够长度的，前面可以补位
		if (patch == null) {
			if (lStr != len) {
				return null;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) == -1) {
				return null;
			}
		}
		// 补位
		if (patch != null && !patch.equals("*")) {
			if (patch != null && lStr != len) {
				for (int j = 1; j <= (len - lStr); j++) {
					str = patch + str;
				}
			}
		}

		return str;

	}// end fun

	/**
	 * 长度校验: title:提示信息,len:最大长度,noNull:不能为空, noBlank：中间不能有空格 成功：null
	 */
	public static String lenCheck(String str, String title, long len,
			boolean noNull, boolean noBlank) {

		// no null
		if (str == null || str.length() == 0) {
			if (noNull) {
				return title + "不合法,不能为空!";
			} else {
				return null;
			}
		}

		// no blank
		if (noBlank) {
			boolean bRe = noBlankIn(str);
			if (bRe == false) {
				return title + "不合法,不能包含空格!";
			}
		}
		// lens judge
		byte[] ss = str.getBytes();
		long lLen = ss.length;

		if (lLen > len) {
			return title + "不合法,长度超过了" + len + "个字节!";
		}

		return null;

	}// end fun

	/**
	 * 下拉框校验: title:提示信息,noNull:不能不选 成功：null
	 */
	public static String selectCheck(String str, String title, boolean noNull) {
		/*
		 * //no null if(noNull && (str==null || str.length()==0 ||
		 * str.equals(Constants.TITLEID))){ return "请选择"+title+"!"; }
		 */
		return null;

	}// end fun

	/**
	 * 字串中不能有空格
	 */
	public static boolean noBlankIn(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				return false;
			}
		}
		return true;

	}// end fun

	/**
	 * 字符串为指定长度限制:title:提示信息, len:长度 noBlank：中间不能有空格
	 */
	public static String lenMust(String str, String title, long len,
			boolean noBlank) {

		// no blank
		if (noBlank) {
			boolean bRe = noBlankIn(str);
			if (bRe == false) {
				return title + "不合法,不能包含空格!";
			}
		}
		// lens judge
		byte[] ss = str.getBytes();
		long lLen = ss.length;

		if (lLen != len) {
			return title + "不合法,必须为" + len + "个字节!";
		}

		return null;

	}// end fun

	/**
	 * 十六进制数字校验,返回str,null表示失败,patch为要补齐的字符
	 */
	public static String HexCheck(String str, long len, String patch) {
		long lStr = 0;
		String okStr = "0123456789ABCDEFabcdef";

		lStr = str.length();

		if (lStr != len && patch == null) {
			return null;
		}// 长度要一致
		if (patch != null && patch.length() > 1) {
			return null;
		}

		// patch==null,必须长度符合，patch!=null,不够长度的，前面可以补位
		if (patch == null) {
			if (lStr != len) {
				return null;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) == -1) {
				return null;
			}
		}
		if (patch != null && lStr != len) {
			for (int j = 1; j <= (len - lStr); j++) {
				str = patch + str;
			}
		}

		return str;

	}// end fun

	/**
	 * 非法字符的检测
	 */
	public static String legalLetter(String str, String title, boolean noBlank) {

		boolean bHave = false;
		long lStr = 0;
		String rStr = null;

		String okStr = "~`!@#$%^&*()_-+=|\\{[}]:;<,>.?\"/'";

		lStr = str.length();

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) != -1) {
				bHave = true;
				break;
			}
		}
		// no blank
		if (noBlank) {
			boolean bRe = noBlankIn(str);
			if (bRe == false) {
				rStr = title + "不合法,不能包含空格!";
				return rStr;
			}
		}

		// 非法字符
		if (bHave) {
			rStr = title + "不合法,包含如下的禁止字符：" + okStr;
		}

		return rStr;

	}// end fun

	/**
	 * 输入必须是字母和数字,noNull:不能为空
	 */
	public static String numberLetter(String str, String title, boolean noNull) {

		boolean bWrong = false;
		String rStr = null;

		str = trimBlank(str);

		String okStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) == -1) {
				bWrong = true;
				break;
			}
		}
		// null
		if (noNull && str.length() == 0) {
			rStr = title + "不合法,不能为空!";
			return rStr;
		}

		// 字母和数字
		if (bWrong) {
			rStr = title + "不合法,必须是字母和数字!";
			return rStr;
		}

		return null;

	}// end fun

	/**
	 * 手机号码判断,noNull:不能为空,noBlank:是否有空格
	 */
	public static String mobileCheck(String str, String title, long len,
			boolean noNull, boolean noBlank) {

		boolean bWrong = false;
		String rStr = null;
		String temp = "";

		// len+blank
		temp = lenCheck(str, title, len, noNull, noBlank);
		if (temp != null) {
			return temp;
		}

		String okStr = "0123456789";

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) == -1) {
				bWrong = true;
				break;
			}
		}

		// 手机号码
		if (bWrong) {
			rStr = title + "不合法,必须是数字!";
		}

		return rStr;

	}// end fun

	/**
	 * 固定电话号码判断,noNull:不能为空,noBlank:是否有空格
	 */
	public static String phoneCheck(String str, String title, long len,
			boolean noNull, boolean noBlank) {

		boolean bWrong = false;
		String temp = "";

		// len+blank
		temp = lenCheck(str, title, len, noNull, noBlank);
		if (temp != null) {
			return temp;
		}

		String okStr = "0123456789#, *-()";

		for (int i = 0; i < str.length(); i++) {
			if (okStr.indexOf(str.charAt(i)) == -1) {
				bWrong = true;
				break;
			}
		}

		// 固定电话号码
		if (bWrong) {
			return title
					+ "不合法,正确的电话号码如下：(010) 68731199,68731199 123,68731199*123!";
		}

		return null;

	}// end fun

	/**
	 * Long数字判断:len:最大的长度,noNull:是否可以为空 min: 最小值（Long.MIN_VALUE 表示不限制）
	 * max：最大值（Long.MAX_VALUE 表示不限制）
	 */
	public static String isLong(String str, String title, long len,
			boolean noNull, long min, long max) {
		long r = 0;

		// lencheck
		String temp = StringUtil.lenCheck(str, title, len, noNull, true);
		if (temp != null) {
			return temp;
		}

		// parse long
		try {
			r = Long.parseLong(str);
		} catch (NumberFormatException e) {
			return title + "不合法,应该为数字!";
		}

		// min,max
		if (r < min && min != java.lang.Long.MIN_VALUE) {
			return title + "不合法,最小值应该为" + min + "!";
		}
		if (r > max && max != java.lang.Long.MAX_VALUE) {
			return title + "不合法,最大值应该为" + max + "!";
		}

		return null;

	}// end fun

	/**
	 * Float数字判断:len:最大的长度,noNull:是否可以为空 min: 最小值 max：最大值
	 */
	public static String isFloat(String str, String title, long len,
			boolean noNull, float min, float max) {
		float r = 0.0f;

		// lencheck
		String temp = StringUtil.lenCheck(str, title, len, noNull, true);
		if (temp != null) {
			return temp;
		}

		// parse float
		try {
			r = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return title + "不合法,应该为数字!";
		}

		// min,max
		if (r < min) {
			return title + "不合法,最小值应该为" + min + "!";
		}
		if (r > max) {
			return title + "不合法,最大值应该为" + max + "!";
		}

		return null;
	}// end fun

	/**
	 * Double 数字判断:len:最大的长度,noNull:是否可以为空 min: 最小值 max：最大值
	 */
	public static String isDouble(String str, String title, long len,
			boolean noNull, double min, double max) {
		double r = 0.0d;

		// lencheck
		String temp = StringUtil.lenCheck(str, title, len, noNull, true);
		if (temp != null) {
			return temp;
		}

		// parse double
		try {
			r = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return title + "不合法,应该为数字!";
		}

		// min,max
		if (r < min) {
			return title + "不合法,最小值应该为" + min + "!";
		}
		if (r > max) {
			return title + "不合法,最大值应该为" + max + "!";
		}

		return null;
	}// end fun

	/**
	 * 用HTML Encode 字符代替原字符
	 */
	public static String Encoded2HTML(String szText) {
		if (szText == null)
			return "";
		String tmp = "";
		int nLength = szText.length();
		for (int i = 0; i < nLength; i++) {
			char ch = szText.charAt(i);
			switch (ch) {
			case 13: // '\r'
				if (i + 1 < nLength) {
					ch = szText.charAt(i + 1);
					if (ch == '\n')
						break;
				}
				// fall through

			case 10: // '\n'
				tmp = tmp + "<br>";
				break;

			case 60: // '<'
				tmp = tmp + "&lt;";
				break;

			case 62: // '>'
				tmp = tmp + "&gt;";
				break;

			case '\'': // '''
				tmp = tmp + "\'";

			case 34: // '"'
				tmp = tmp + "&quot;";
				break;

			default:
				tmp = tmp + ch;
				break;
			}
		}

		return tmp;
	}

	/**
	 * 字符替换
	 */
	public static String charReplace(String szText, char src, char des) {
		if (szText == null)
			return "";
		String tmp = "";
		for (int i = 0; i < szText.length(); i++)
			if (szText.charAt(i) == src)
				tmp = tmp + des;
			else
				tmp = tmp + szText.charAt(i);

		return tmp;
	}

	/**
	 * 字符串替换
	 */
	public static String charReplace(String szText, char src, String des) {
		if (szText == null)
			return "";
		String tmp = "";
		for (int i = 0; i < szText.length(); i++)
			if (szText.charAt(i) == src)
				tmp = tmp + des;
			else
				tmp = tmp + szText.charAt(i);

		return tmp;
	}

	/**
	 * 内容摘要：对字符串分割 流程： 1、判断字符串是不是为空串 2、按“，”提取子字符串并放入ArrayList 3、返回
	 * 
	 * @param str
	 *            用","分隔的字符串
	 * @return ArrayList 返回列表
	 * @throws EccInfoException
	 */
	public static ArrayList splitToList(String str, String cut) {

		// 用于返回事业部列表
		ArrayList list = new ArrayList();
		// 存储每次撮的事业部子串
		String tmpStr = "";

		// 提取字串的开始、结束位置
		int start = 0;
		int end = 0;

		// 如果事业部字符串为空，就返回一个0长度的列表
		if (str.length() == 0) {
			return list;
		}

		// 有果有“，”分隔的字符串就提取
		while (true) {

			end = str.indexOf(cut, start);
			// 如果查找到字符串的末尾就将上一次的开始位置到字符串末尾的子串作为一个子串
			if (end == -1) {
				tmpStr = str.substring(start, str.length());
				list.add(tmpStr);
				break;
			}

			tmpStr = str.substring(start, end);
			list.add(tmpStr);
			start = end + 1;

		}

		return list;
	}

	public static String getDateNow(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String myDateStr = sdf.format(new Date());
		return myDateStr;
	}

	// 格式化数字.保留两位小数
	public static String formatMoney(double money) throws Exception {
		DecimalFormat formatter = new DecimalFormat();
		//
		formatter.applyPattern("0.00");
		return formatter.format(money);
	}

	// 截取前九位员工信息
	public static String subStringEmployee(String content) throws Exception {
		String subString = "";
		String temp = "@";
		int cnt = 0;
		int offset = 0;
		if (!"".equals(content) && null != content) {
			while ((offset = content.indexOf(temp, offset)) != -1) {
				offset = offset + temp.length();
				// System.out.println("offset->"+offset);
				cnt++;
				if (cnt == 10) {
					subString = content.substring(0, offset - 1).trim()
							+ "......";
					break;
				}
			}
			if (cnt < 10) {
				subString = content.trim();
			}
		}
		return subString;
	}

	/**
	 * 判断指定的字符串是否是空(null或""或"null"或"NULL"都是空)
	 * 
	 * @param str
	 * @return 空：true;非空:false
	 */
	public static boolean checkStrIsEmpty(String str) {
		boolean bln = false;
		if (str == null || "".equals(str) || "NULL".equalsIgnoreCase(str)) {
			bln = true;
		}
		return bln;
	}
	/**
	 * 判断指定的字符串是否是空(null或""或"null"或"NULL"都是空)
	 * 
	 * @param str
	 * @return 空：true;非空:false
	 */
	public static String retBlankIfNull(String str) {
		if (str == null || "".equals(str) || "NULL".equalsIgnoreCase(str)) {
			return "";
		}
		return str;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String source = "abcdefgabcdefgabcdefgabcdefgabcdefgabcdefg";
		// String from = "efg";
		// String to = "房贺威";
		// System.out.println("在字符串source中，用to替换from，替换结果为："
		// + replace(from, to, source));
		// System.out.println("返回指定字节长度的字符串："
		// + toLength("abcdefgabcdefgabcdefgabcdefgabcdefgabcdefg", 9));
		// System.out.println("判断是否为整数：" + isInteger("+0"));
		// System.out.println("判断是否为浮点数，包括double和float：" + isDouble("+0.36"));
		// System.out.println("判断输入的字符串是否符合Email样式：" +
		// isEmail("fhwbj@163.com"));
		// System.out.println("判断输入的字符串是否为纯汉字：" + isChinese("你好！"));
		// System.out.println("判断输入的数据是否是质数：" + isPrime(12));
		// System.out.println("人民币转换成大写：" + hangeToBig("10019658"));
		System.out.println("去掉字符串中重复的子字符串：" + removeSameString("100 100 9658"));
		// System.out.println("过滤特殊字符：" + encoding("100\"s<>fdsd100 9658"));
		// System.out.println("判断是不是合法的手机号码：" + isHandset("15981807340"));

		// System.out.println("从字符串中取值Email：" + parse("159818 fwhbj@163.com
		// 07340"));
	}
}
