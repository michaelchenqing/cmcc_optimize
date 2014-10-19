/**  
 * DateUtil.java
 * com.cmcc.optimize.dataapi.util
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午5:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 日期格式化工具类
 *
 * @author gaoqs
 * @date 2014年6月30日 下午2:33:44
 */
public class DateUtil {

	Logger log = LoggerFactory.getLogger(DateUtil.class);

	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";

	/** 年月日 yyyy-MM-dd */
	public static final String dtSimple = "yyyy-MM-dd";

	/** 年月日(中文) yyyy年MM月dd日 */
	public static final String dtSimpleChinese = "yyyy年MM月dd日";

	public static final String week = "EEEE";

	/** 年月日(无下划线) yyyyMMdd */
	public static final String dtShort = "yyyyMMdd";

	/** 年月日时分(无下划线) yyyyMMddHHmm */
	public static final String dtMiddle = "yyyyMMddHHmm";

	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	public static final String dtLong = "yyyyMMddHHmmss";

	/** 时分秒 HH:mm:ss */
	public static final String hmsFormat = "HH:mm:ss";

	/** 时分 HH:mm */
	public static final String hmFormat = "HHmm";

	/** 年-月-日 小时:分钟 yyyy-MM-dd HH:mm */
	public static final String simpleFormat = "yyyy-MM-dd HH:mm";

	/** 年月日(中文) yyyy年MM月dd日 HH:mm */
	public static final String dtSimpleChineseWithTime = "yyyy年MM月dd日 HH:mm";

	/**
	 * 获取格式
	 * 
	 * @param format
	 * @return
	 */
	public static  DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static  String simpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(simple).format(date);
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static  String dtSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimple).format(date);
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dtFormat(Date date, String style) {
		if (date == null) {
			return "";
		}
		return getFormat(style).format(date);
	}

	/**
	 * yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static  String dtShortSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtShort).format(date);
	}

	/**
	 * <pre>
	 * yyyyMMddHHmm
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static  String dtMiddleSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtMiddle).format(date);
	}

	/**
	 * <pre>
	 * yyyyMMddHHmmss
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static  String dtLongSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtLong).format(date);
	}

	/**
	 * @param strDate
	 *            yyyyMMdd
	 * @return yyyy-MM-dd
	 */
	public static  String dtFromShortToSimpleStr(String strDate) {
		if (null != strDate) {
			Date date;
			try {
				date = shortstring2Date(strDate);
			} catch (ParseException e) {
				date = null;
			}
			if (null != date) {
				return dtSimpleFormat(date);
			}
		}
		return "";
	}

	/**
	 * yyyy-mm-dd 日期格式转换为日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateFormat(String strDate, String format) {
		if (strDate == null) {
			return null;
		}

		try {
			return new SimpleDateFormat(format).parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取输入日期的相差日期
	 * 
	 * @param dt
	 * @param idiff
	 * 
	 * @return
	 */
	public static String getDiffDate(Date dt, int idiff) {
		Calendar c = Calendar.getInstance();

		c.setTime(dt);
		c.add(Calendar.DATE, idiff);
		return dtSimpleFormat(c.getTime());
	}

	/**
	 * 获取输入日期的相差日期
	 * 
	 * @param dt
	 * @param idiff
	 * 
	 * @return
	 */
	public static  String getDiffDateDtShort(Date dt, int idiff) {
		Calendar c = Calendar.getInstance();

		c.setTime(dt);
		c.add(Calendar.DATE, idiff);
		return dtShortSimpleFormat(c.getTime());
	}

	/**
	 * 获取输入日期月份的相差日期
	 * 
	 * @param dt
	 * @param idiff
	 * @return
	 */
	public static String getDiffMon(Date dt, int idiff) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.MONTH, idiff);
		return dtSimpleFormat(c.getTime());
	}

	/**
	 * yyyy年MM月dd日
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static String dtSimpleChineseFormat(Date date) {
		if (date == null) {
			return "";
		}

		return getFormat(dtSimpleChinese).format(date);
	}

	/**
	 * yyyy-MM-dd到 yyyy年MM月dd日 转换
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static String dtSimpleChineseFormatStr(String date)
			throws ParseException {
		if (date == null) {
			return "";
		}

		return getFormat(dtSimpleChinese).format(string2Date(date));
	}

	/**
	 * yyyy-MM-dd 日期字符转换为时间
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static Date string2Date(String stringDate)
			throws ParseException {
		if (stringDate == null) {
			return null;
		}

		return getFormat(dtSimple).parse(stringDate);
	}

	/**
	 * 返回日期时间（Add by Sunzy）
	 * 
	 * @param stringDate
	 *            "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  Date string2DateTime(String stringDate)
			throws ParseException {
		if (stringDate == null) {
			return null;
		}

		return getFormat(simple).parse(stringDate);
	}

	/**
	 * <pre>
	 * 时间转化为日期
	 * </pre>
	 * 
	 * @param stringDate
	 * @return
	 * @throws ParseException
	 */
	public static  String getHmString(Date date) throws ParseException {
		if (date == null) {
			return null;
		}
		return getFormat(hmFormat).format(date);
	}

	/**
	 * 年月日(中文) yyyy年MM月dd日 HH:mm
	 * 
	 * @param date
	 * @return
	 */
	public static  String dtSimpleChineseFormatWithTime(Date date) {
		if (date == null) {
			return "";
		}

		return getFormat(dtSimpleChineseWithTime).format(date);
	}

	/**
	 * 返回日期时间（Add by Sunzy）
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  Date string2DateTimeByAutoZero(String stringDate)
			throws ParseException {
		if (stringDate == null) {
			return null;
		}
		if (stringDate.length() == 11)
			stringDate = stringDate + "00:00:00";
		else if (stringDate.length() == 13)
			stringDate = stringDate + ":00:00";
		else if (stringDate.length() == 16)
			stringDate = stringDate + ":00";
		else if (stringDate.length() == 10)
			stringDate = stringDate + " 00:00:00";

		return getFormat(simple).parse(stringDate);
	}

	/**
	 * 返回日期时间（Add by wangjl）(时分秒：23:59:59)
	 * 
	 * @param stringDate
	 *            String 型
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  Date string2DateTimeBy23(String stringDate)
			throws ParseException {
		if (stringDate == null) {
			return null;
		}
		if (stringDate.length() == 11)
			stringDate = stringDate + "23:59:59";
		else if (stringDate.length() == 13)
			stringDate = stringDate + ":59:59";
		else if (stringDate.length() == 16)
			stringDate = stringDate + ":59";
		else if (stringDate.length() == 10)
			stringDate = stringDate + " 23:59:59";

		return getFormat(simple).parse(stringDate);
	}

	/**
	 * 计算日期差值
	 * 
	 * @param String
	 * @param String
	 * @return int（天数）
	 */
	public static  int calculateDecreaseDate(String beforDate,
			String afterDate) throws ParseException {
		Date date1 = getFormat(dtSimple).parse(beforDate);
		Date date2 = getFormat(dtSimple).parse(afterDate);
		long decrease = getDateBetween(date1, date2) / 1000 / 3600 / 24;
		int dateDiff = (int) decrease;
		return dateDiff;
	}

	/**
	 * 计算时间差
	 * 
	 * @param dBefor
	 *            首日
	 * @param dAfter
	 *            尾日
	 * @return 时间差(毫秒)
	 */
	public static  long getDateBetween(Date dBefor, Date dAfter) {
		long lBefor = 0;
		long lAfter = 0;
		long lRtn = 0;

		/** 取得距离 1970年1月1日 00:00:00 GMT 的毫秒数 */
		lBefor = dBefor.getTime();
		lAfter = dAfter.getTime();

		lRtn = lAfter - lBefor;

		return lRtn;
	}

	/**
	 * 当前时间与参数时间差
	 * 
	 * @param dBefor
	 *            首日
	 * @return 时间差(分)
	 */
	public static  int getDateBetweenNow(Date dateBefore) {
		if (dateBefore == null) {
			return 0;
		}
		return (int) (getDateBetween(dateBefore, new Date()) / 1000 / 60);
	}

	/**
	 * 返回日期时间（Add by Gonglei）
	 * 
	 * @param stringDate
	 *            (yyyyMMdd)
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  Date shortstring2Date(String stringDate)
			throws ParseException {
		if (stringDate == null) {
			return null;
		}

		return getFormat(dtShort).parse(stringDate);
	}

	/**
	 * 返回短日期格式（yyyyMMdd格式）
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  String shortDate(Date Date) {
		if (Date == null) {
			return null;
		}

		return getFormat(dtShort).format(Date);
	}

	/**
	 * 返回长日期格式（yyyyMMddHHmmss格式）
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  String longDate(Date Date) {
		if (Date == null) {
			return null;
		}

		return getFormat(dtLong).format(Date);
	}

	/**
	 * yyyy-MM-dd 日期字符转换为长整形
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  Long string2DateLong(String stringDate)
			throws ParseException {
		Date d = string2Date(stringDate);

		if (d == null) {
			return null;
		}

		return new Long(d.getTime());
	}

	/**
	 * 日期转换为字符串 HH:mm:ss
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static  String hmsFormat(Date date) {
		if (date == null) {
			return "";
		}

		return getFormat(hmsFormat).format(date);
	}

	/**
	 * 时间转换字符串 2005-06-30 15:50
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static  String simpleDate(Date date) {
		if (date == null) {
			return "";
		}

		return getFormat(simpleFormat).format(date);
	}

	/**
	 * 字符串 2005-06-30 15:50 转换成时间
	 * 
	 * @param date
	 *            String
	 * @return
	 * @throws ParseException
	 */
	public static  Date simpleFormatDate(String dateString)
			throws ParseException {
		if (dateString == null) {
			return null;
		}
		return getFormat(simpleFormat).parse(dateString);
	}

	/**
	 * 获取当前日期的日期差 now= 2005-07-19 diff = 1 -> 2005-07-20 diff = -1 -> 2005-07-18
	 * 
	 * @param diff
	 * 
	 * @return
	 */
	public static  String getDiffDate(int diff) {
		Calendar c = Calendar.getInstance();

		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		return dtSimpleFormat(c.getTime());
	}

	public static  Date getDiffDateTime(int diff) {
		Calendar c = Calendar.getInstance();

		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		return c.getTime();
	}

	/**
	 * 获取当前日期的日期时间差
	 * 
	 * @param diff
	 * @param hours
	 * 
	 * @return
	 */
	public static  String getDiffDateTime(int diff, int hours) {
		Calendar c = Calendar.getInstance();

		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		c.add(Calendar.HOUR, hours);
		return dtSimpleFormat(c.getTime());
	}

	/**
	 * 计算当前时间几小时之后的时间
	 * 
	 * @param date
	 * @param hours
	 * 
	 * @return
	 */
	public static Date addHours(Date date, long hours) {
		return addMinutes(date, hours * 60);
	}

	/**
	 * 计算当前时间几分钟之后的时间
	 * 
	 * @param date
	 * @param minutes
	 * 
	 * @return
	 */
	public static Date addMinutes(Date date, long minutes) {
		return addSeconds(date, minutes * 60);
	}

	/**
	 * @param date1
	 * @param secs
	 * 
	 * @return
	 */

	public static Date addSeconds(Date date1, long secs) {
		return new Date(date1.getTime() + (secs * 1000));
	}

	/**
	 * 把日期类型的日期换成数字类型 YYYYMMDD类型
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static  Long dateToNumber(Date date) {
		if (date == null) {
			return null;
		}

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		String month;
		String day;

		if ((c.get(Calendar.MONTH) + 1) >= 10) {
			month = "" + (c.get(Calendar.MONTH) + 1);
		} else {
			month = "0" + (c.get(Calendar.MONTH) + 1);
		}

		if (c.get(Calendar.DATE) >= 10) {
			day = "" + c.get(Calendar.DATE);
		} else {
			day = "0" + c.get(Calendar.DATE);
		}

		String number = c.get(Calendar.YEAR) + "" + month + day;

		return new Long(number);
	}

	/**
	 * 获取下月
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static String getNextMon(String StringDate) throws ParseException {
		Date tempDate = DateUtil.shortstring2Date(StringDate);
		Calendar cad = Calendar.getInstance();

		cad.setTime(tempDate);
		cad.add(Calendar.MONTH, 1);
		return DateUtil.shortDate(cad.getTime());
	}

	/**
	 * add by daizhixia 20050808 获取下一天
	 * 
	 * @param StringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static String getNextDay(String StringDate) throws ParseException {
		Date tempDate = DateUtil.string2Date(StringDate);
		Calendar cad = Calendar.getInstance();

		cad.setTime(tempDate);
		cad.add(Calendar.DATE, 1);
		return DateUtil.dtSimpleFormat(cad.getTime());
	}

	public static String getWebNextDayString() {
		Calendar cad = Calendar.getInstance();
		cad.setTime(new Date());
		cad.add(Calendar.DATE, 1);
		return DateUtil.dtSimpleFormat(cad.getTime());
	}

	/**
	 * add by chencg 获取下一天 返回 dtSimple 格式字符
	 * 
	 * @param date
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static String getNextDay(Date date) throws ParseException {
		Calendar cad = Calendar.getInstance();
		cad.setTime(date);
		cad.add(Calendar.DATE, 1);
		return DateUtil.dtSimpleFormat(cad.getTime());
	}

	/**
	 * add by chencg 获取下一天 返回 dtshort 格式字符
	 * 
	 * @param StringDate
	 *            "20061106"
	 * 
	 * @return String "2006-11-07"
	 * 
	 * @throws ParseException
	 */
	public static Date getNextDayDtShort(String StringDate)
			throws ParseException {
		Date tempDate = DateUtil.shortstring2Date(StringDate);
		Calendar cad = Calendar.getInstance();

		cad.setTime(tempDate);
		cad.add(Calendar.DATE, 1);
		return cad.getTime();
	}

	/**
	 * add by daizhixia 20050808 取得相差的天数
	 * 
	 * @param startDate
	 *            格式为 2008-08-01
	 * @param endDate
	 *            格式为 2008-08-01
	 * 
	 * @return
	 */
	public static long countDays(String startDate, String endDate) {
		Date tempDate1 = null;
		Date tempDate2 = null;
		long days = 0;

		try {
			tempDate1 = DateUtil.string2Date(startDate);

			tempDate2 = DateUtil.string2Date(endDate);
			days = (tempDate2.getTime() - tempDate1.getTime())
					/ (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return days;
	}

	/**
	 * 返回日期相差天数，向下取整数
	 * 
	 * @param dateStart
	 *            一般前者小于后者dateEnd
	 * @param dateEnd
	 * 
	 * @return
	 */
	public static int countDays(Date dateStart, Date dateEnd) {
		if ((dateStart == null) || (dateEnd == null)) {
			return -1;
		}

		return (int) ((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 校验start与end相差的天数，是否满足end-start lessEqual than days
	 * 
	 * @param start
	 * @param end
	 * @param days
	 * 
	 * @return
	 */
	public static boolean checkDays(Date start, Date end, int days) {
		int g = countDays(start, end);

		return g <= days;
	}

	public static Date now() {
		return new Date();
	}

	/**
	 * alahan add 20050825 获取传入时间相差的日期
	 * 
	 * @param dt
	 *            传入日期，可以为空
	 * @param diff
	 *            需要获取相隔diff天的日期 如果为正则取以后的日期，否则时间往前推
	 * 
	 * @return
	 */
	public static String getDiffStringDate(Date dt, int diff) {
		Calendar ca = Calendar.getInstance();

		if (dt == null) {
			ca.setTime(new Date());
		} else {
			ca.setTime(dt);
		}

		ca.add(Calendar.DATE, diff);
		return dtSimpleFormat(ca.getTime());
	}

	/**
	 * 校验输入的时间格式是否合法，但不需要校验时间一定要是8位的
	 * 
	 * @param statTime
	 * 
	 * @return alahan add 20050901
	 */
	public static boolean checkTime(String statTime) {
		if (statTime.length() > 8) {
			return false;
		}

		String[] timeArray = statTime.split(":");

		if (timeArray.length != 3) {
			return false;
		}

		for (int i = 0; i < timeArray.length; i++) {
			String tmpStr = timeArray[i];

			try {
				Integer tmpInt = new Integer(tmpStr);

				if (i == 0) {
					if ((tmpInt.intValue() > 23) || (tmpInt.intValue() < 0)) {
						return false;
					} else {
						continue;
					}
				}

				if ((tmpInt.intValue() > 59) || (tmpInt.intValue() < 0)) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 返回日期时间（Add by Gonglei）
	 * 
	 * @param stringDate
	 *            (yyyyMMdd)
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static  String stringToStringDate(String stringDate) {
		if (stringDate == null) {
			return null;
		}

		if (stringDate.length() != 8) {
			return null;
		}

		return stringDate.substring(0, 4) + stringDate.substring(4, 6)
				+ stringDate.substring(6, 8);
	}

	/**
	 * 将字符串按format格式转换为date类型
	 * 
	 * @param str
	 * @param format
	 * 
	 * @return
	 */
	public static Date string2Date(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 加减天数
	 * 
	 * @param date
	 * @return Date
	 * @author shencb 2006-12 add
	 */
	public static  Date increaseDate(Date aDate, int days) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(aDate);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 是否闰年
	 * 
	 * @param year
	 * @return
	 */
	public static  boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

	}

	/**
	 * 判断是否是默认工作日，一般默认工作日是星期一都星期五， 所以，这个函数本质是判断是否是星期一到星期五
	 * 
	 * @param date
	 * @return
	 */
	public static  boolean isDefaultWorkingDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		return !(week == 7 || week == 1);
	}

	/**
	 * 获取星期名，如“星期一”、“星期二”
	 * 
	 * @param date
	 * @return
	 */
	public static  String getWeekDay(Date date) {
		return getFormat(week).format(date);
	}

	public static Date parseDateNoTime(String sDate, String format)
			throws ParseException {
		if (StringUtils.isBlank(format)) {
			throw new ParseException("Null format. ", 0);
		}

		DateFormat dateFormat = new SimpleDateFormat(format);

		if ((sDate == null) || (sDate.length() < format.length())) {
			throw new ParseException("length too little", 0);
		}

		return dateFormat.parse(sDate);
	}

	/**
	 * 获取当前时间的字符串格式，以半个小时为单位<br>
	 * 当前时间2007-02-02 22:23 则返回 2007-02-02 22:00 当前时间2007-02-02 22:33 则返回
	 * 2007-02-02 22:30
	 * 
	 * @return
	 */
	public static  String getNowDateForPageSelectAhead() {

		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.MINUTE) < 30) {
			cal.set(Calendar.MINUTE, 0);
		} else {
			cal.set(Calendar.MINUTE, 30);
		}
		return simpleDate(cal.getTime());
	}

	/**
	 * 获取当前时间的字符串格式，以半个小时为单位<br>
	 * 当前时间2007-02-02 22:23 则返回 2007-02-02 22:30 当前时间2007-02-02 22:33 则返回
	 * 2007-02-02 23:00
	 * 
	 * @return
	 */
	public static  String getNowDateForPageSelectBehind() {
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.MINUTE) < 30) {
			cal.set(Calendar.MINUTE, 30);
		} else {
			cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
			cal.set(Calendar.MINUTE, 0);
		}
		return simpleDate(cal.getTime());
	}

	/**
	 * 把日期2007/06/14转换为20070614
	 * 
	 * @method formatDateString
	 * @param date
	 * @return
	 */
	public static String formatDateString(String date) {
		String result = "";
		if (date == null || "".equals(date)) {
			return "";
		}
		if (date.length() == 10) {
			result = date.substring(0, 4) + date.substring(5, 7)
					+ date.substring(8, 10);
		}
		return result;
	}

	public static String getNewFormatDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(simple);
		return getDateString(date, dateFormat);
	}

	public static String getDateString(Date date, DateFormat dateFormat) {
		if (date == null || dateFormat == null) {
			return null;
		}

		return dateFormat.format(date);
	}

	/**
	 * 当endtime参数可用时，忽略timeunit参数
	 * 
	 * @param starttime   开始时间	2014-07-02 00:23:21
	 * @param endtime     结束时间	2014-07-02 00:23:21
	 * @param timeunit    时间周期	day/week/month 
	 * @return            查询范围：{开始时间,结束时间}
	 *  <p>For example: 
	 * 	<p>getCycle("2014-07-02 00:23:21", "2014-08-05 21:22:11", "")   return {'2014-07-02 00:00:00','2014-08-05 21:22:11'}
	 * 	<p>getCycle("2014-07-02 25:23:21", "", "hour")  				 return {'2014-07-02 25:00:00','2014-07-03 02:00:00'}
	 * 	<p>getCycle("2014-07-02 00:23:21", "", "day")  					 return {'2014-07-02 00:00:00','2014-07-03 00:00:00'}
	 *  s<p>getCycle("2014-07-02 00:23:21", "", "week")   				return {'2014-06-30 00:00:00','2014-07-07 00:00:00'}
	 * 	<p>getCycle("2014-07-02 00:23:21", "", "month")					return {'2014-07-01 00:00:00','2014-08-01 00:00:00'}
	 */
	public static String[] getCycle(String starttime, String endtime, String timeunit) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(simple);
		String[] dates=new String[2];
		int mon, day;
		Date st;
		try {
			st = sdf.parse(starttime);
		} catch (ParseException e) {
			return null;
		}
		if (!StringUtils.isBlank(endtime)) {
			try {
				sdf.parse(endtime);
			} catch (ParseException e) {
				return null;
			}
			return new String[] { starttime, endtime };
		} else if (!StringUtils.isBlank(starttime) && !StringUtils.isBlank(timeunit)) {
			cal.setTime(st);
			if("hour".equalsIgnoreCase(timeunit)){
				dates[0]=starttime.substring(0, 14)+"00:00";
				cal.add(Calendar.HOUR_OF_DAY, 1);
				mon = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				int hour=cal.get(Calendar.HOUR_OF_DAY);
				dates[1]=cal.get(Calendar.YEAR) + "-" + (mon < 10 ? ("0" + mon) : mon + "") + "-" + (day < 10 ? ("0" + day) : day + "") +" "+(hour < 10 ? ("0" + hour) : hour + "")+ ":00:00";
			}else if ("day".equalsIgnoreCase(timeunit)) {
				cal.add(Calendar.DAY_OF_MONTH, 1);
				mon = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				dates[0]=starttime.substring(0, 10) + " 00:00:00";
				dates[1]=cal.get(Calendar.YEAR) + "-" + (mon < 10 ? ("0" + mon) : mon + "") + "-" + (day < 10 ? ("0" + day) : day + "") + " 00:00:00";
			} else if ("week".equalsIgnoreCase(timeunit)) {
				cal.setFirstDayOfWeek(Calendar.MONDAY);
				cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
				mon = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				dates[0]=cal.get(Calendar.YEAR) + "-" + (mon < 10 ? ("0" + mon) : mon + "") + "-" + (day < 10 ? ("0" + day) : day + "") + " 00:00:00";
				cal.add(Calendar.DAY_OF_MONTH, 7);
				mon = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				dates[1]=cal.get(Calendar.YEAR) + "-" + (mon < 10 ? ("0" + mon) : mon + "") + "-" + (day < 10 ? ("0" + day) : day + "") + " 00:00:00";
			} else if ("month".equalsIgnoreCase(timeunit)) {
				cal.add(Calendar.MONTH, 1);
				mon = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				dates[0]=starttime.substring(0, 7) + "-01 00:00:00";
				dates[1]=cal.get(Calendar.YEAR) + "-" + (mon < 10 ? ("0" + mon) : mon + "") + "-01 00:00:00";
			}else{
				return null;
			}
		}
		return dates;
	}

	/**
	 * 时间及时间粒度验证方法
	 * 
	 * @param starttime 开始时间	格式：yyyy-MM-dd HH:mm:ss
	 * @param endtime	结束时间	格式：yyyy-MM-dd HH:mm:ss
	 * @param timeunit  时间粒度	值：hour/day/week/month
	 * @return   		返回验证错误信息，null表示验证通过
	 */
	public static String validDate(String starttime, String endtime, String timeunit) {
		if(StringUtils.isBlank(starttime)){
			return "param 'starttime' is null !";
		}
		System.out.println(StringUtils.isBlank(timeunit));
		if(StringUtils.isBlank(endtime)&&StringUtils.isBlank(timeunit)){
			return "param 'endtime' and 'timeunit' is null !";
		}else if(StringUtils.isBlank(endtime)&&!StringUtils.isBlank(timeunit)){
			if(!("hour".equalsIgnoreCase(timeunit)||"day".equalsIgnoreCase(timeunit)||"week".equalsIgnoreCase(timeunit)||"month".equalsIgnoreCase(timeunit))){
				return "param timeunit is error !";
			}
		}
		if(starttime.length()!=19){
			return "param 'endtime' length is error !";
		}
		String err1=validDateTime(starttime);
		if(!StringUtils.isBlank(err1)){
			return "param starttime "+err1;
		}
		if(!StringUtils.isBlank(endtime)){
			String err2=validDateTime(endtime);			
			if(!StringUtils.isBlank(err2)){
				return "param endtime"+err2;
			}
		}
		return null;
	}
	/**
	 * 时间验证
	 * 
	 * @param dateTime 开始时间	格式：yyyy-MM-dd HH:mm:ss
	 * @return 返回验证错误信息，null表示验证通过
	 */
	public static String validDateTime(String dateTime){
		int s1= Integer.parseInt(dateTime.substring(0, 4));
		int s2= Integer.parseInt(dateTime.substring(5,7));
		int s3= Integer.parseInt(dateTime.substring(8,10));
		int s4= Integer.parseInt(dateTime.substring(11,13));
		if(s1<0){
			return " year is error !";
		}
		if(s2<1||s2>12){
			return " month is error !";
		}
		if(s3<0||s3>31){
			return " day is error !";
		}
		if(s4<0|| s4>60){
			return " hour is error !";
		}
		return null;
	} 
}