package com.zzm.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;


public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    private static String defaultDatePattern = null;
    private static String timePattern = "HH:mm";
    public static final String TS_FORMAT = DateUtil.getDatePattern() + " HH:mm:ss.S";

    /**
     * yyyy-MM
     */
    public static final String MONTH_DATE_FORMAT = "yyyy-MM";


    /**
     * 日期格式yyyy-MM-dd字符串常量
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_FORMAT_DEFAULT = "yyyyMMdd";

    /**
     * 日期格式HH:mm:ss字符串常量
     */
    private static final String HOUR_FORMAT = "HH:mm:ss";

    /**
     * 日期格式yyyy-MM-dd HH:mm:ss字符串常量
     */
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String PAY_FORMAT = "yyyyMMddHHmmss";

    /**
     * 某天结束时分秒字符串常量 23:59:59
     */
    public static final String DAY_END_STRING_HHMMSS = " 23:59:59";

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static SimpleDateFormatThreadSafe sdf_date_format = new SimpleDateFormatThreadSafe(DATE_FORMAT);

    private static SimpleDateFormatThreadSafe sdf_date_format_default = new SimpleDateFormatThreadSafe(DATE_FORMAT_DEFAULT);

    private static SimpleDateFormatThreadSafe sdf_hour_format = new SimpleDateFormatThreadSafe(HOUR_FORMAT);

    private static SimpleDateFormatThreadSafe sdf_datetime_format = new SimpleDateFormatThreadSafe(DATETIME_FORMAT);

    private static SimpleDateFormatThreadSafe pay_datetime_format = new SimpleDateFormatThreadSafe(PAY_FORMAT);

    private static SimpleDateFormatThreadSafe simpleDateFormat = new SimpleDateFormatThreadSafe("EEE MMM dd HH:mm:ss zzz yyyy",
            Locale.ENGLISH);
    private static SimpleDateFormatThreadSafe NormalDateFormat = new SimpleDateFormatThreadSafe("yyyy-MM-dd HH:mm:ss");

    public static final String[] hours = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};

    // ~ Methods
    // ================================================================

    public DateUtil() {
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取传入时间过去第几天的日期
     *
     * @param date
     * @param past
     * @return
     */
    public static Date getPastDates(Date date, int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        return calendar.getTime();
    }

    /**
     * 获取传入时间过去第几天的日期
     *
     * @param date
     * @param past
     * @return
     */
    public static String getPastDate(Date date, int past) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取24小时 数组 小于10时,前面加0
     *
     * @return
     */
    public static String[] getAllDayHourArrWithZero() {
        String res[] = new String[24];
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                res[i] = "0" + String.valueOf(i) + ":00";
            } else {
                res[i] = String.valueOf(i) + ":00";
            }

        }

        return res;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return
     */
    public static String payDate(Date date) {
        if (date == null) {
            return "";
        }
        return pay_datetime_format.format(date);
    }

    public static Date solrDateToString(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return
     */
    public static String dateToStringDefault(Date date) {
        if (date == null) {
            return "";
        }
        return sdf_datetime_format.format(date);
    }

    public static String dateToStringYMD(Date date) {
        if (date == null) {
            return "";
        }
        return sdf_date_format.format(date);
    }

    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getDateTime() {
        try {
            Date date = new Date();
            return sdf_datetime_format.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getDate() {
        try {
            Date date = new Date();
            return sdf_date_format.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getDateDefault() {
        try {
            Date date = new Date();
            return sdf_date_format_default.format(date);
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getTime() {
        String temp = " ";
        try {
            Date date = new Date();
            temp += sdf_hour_format.format(date);
            return temp;
        } catch (Exception e) {
            logger.debug("DateUtil.getTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时结束日期的默认值
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getEndDate() {
        try {
            return getDate();
        } catch (Exception e) {
            logger.debug("DateUtil.getEndDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 比较两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static int getMargin(String date1, String date2) {
        int margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_date_format.parse(date1, pos);
            Date dt2 = sdf_date_format.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (int) (l / (24 * 60 * 60 * 1000));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static double getDoubleMargin(String date1, String date2) {
        double margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_datetime_format.parse(date1, pos);
            Date dt2 = sdf_datetime_format.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (l / (24 * 60 * 60 * 1000.00));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的月数
     *
     * @param date1
     * @param date2
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static int getMonthMargin(String date1, String date2) {
        int margin;
        try {
            margin = (Integer.parseInt(date2.substring(0, 4)) - Integer.parseInt(date1.substring(0, 4))) * 12;
            margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0", "-"))
                    - Integer.parseInt(date1.substring(4, 7).replaceAll("-0", "-")));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 返回日期加X天后的日期
     *
     * @param date
     * @param i
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String addDay(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.DATE, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addDay():" + e.toString());
            return getDate();
        }
    }

    public static Date addDays(Date srcDate, int addDays) {
        return getNextDayCurrDay(srcDate, addDays);
    }

    public static Date addMinutes(Date srcDate, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(srcDate);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date getNextDayCurrDay(Date currDate, int i) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(currDate);
        gc.add(GregorianCalendar.DATE, i);
        return gc.getTime();
    }

    /**
     * 返回日期加X月后的日期
     *
     * @param date
     * @param i
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String addMonth(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.MONTH, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addMonth():" + e.toString());
            return getDate();
        }
    }

    public static Date addMonths(Date date, int i) {
        try {
            String format = sdf_date_format.format(date);
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(format.substring(0, 4)),
                    Integer.parseInt(format.substring(5, 7)) - 1, Integer.parseInt(format.substring(8, 10)));
            gCal.add(GregorianCalendar.MONTH, i);
            return gCal.getTime();
        } catch (Exception e) {
            logger.debug("DateUtil.addMonth():" + e.toString());
            return date;
        }
    }

    /**
     * 返回日期加X年后的日期
     *
     * @param date
     * @param i
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String addYear(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.YEAR, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addYear():" + e.toString());
            return "";
        }
    }

    public static Date addYears(Date date, int i) {
        try {
            String format = sdf_date_format.format(date);
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(format.substring(0, 4)),
                    Integer.parseInt(format.substring(5, 7)) - 1, Integer.parseInt(format.substring(8, 10)));
            gCal.add(GregorianCalendar.YEAR, i);
            return gCal.getTime();
        } catch (Exception e) {
            logger.debug("DateUtil.addYear():" + e.toString());
            return date;
        }
    }

    /**
     * 返回某年某月中的最大天
     *
     * @param year
     * @param month
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static int getMaxDay(int year, int month) {
        int day = 0;
        try {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                day = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else if ((0 == (year % 4)) && (0 != (year % 100)) || (0 == (year % 400))) {
                day = 29;
            } else {
                day = 28;
            }
            return day;
        } catch (Exception e) {
            logger.debug("DateUtil.getMonthDay():" + e.toString());
            return 1;
        }
    }

    public static String[] getDayLine(int length) {
        String[] line = new String[length - 1];
        for (int k = 0; k < length - 1; k++) {
            line[k] = k + 1 + "天后";
        }
        return line;
    }

    public static String[] getWeeksLine(int length) {
        String[] line = new String[length - 1];
        for (int k = 0; k < length - 1; k++) {
            line[k] = k + 1 + "周后";
        }
        return line;
    }

    public static String[] getMonthLine(int length) {
        String[] line = new String[length - 1];
        for (int k = 0; k < length - 1; k++) {
            line[k] = k + 1 + "月后";
        }
        return line;
    }

    public static Long getMonthOfDate(Date date1, Date date2) {
        long days = (date1.getTime() - date2.getTime())/(60*60*24*1000);
        long months = days/32 + 1;
        return months;
    }

    public static boolean isDate(String str) {
        try {
            cn.hutool.core.date.DateUtil.parse(str,dateFormat);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 格式化日期
     *
     * @param orgDate
     * @param Type
     * @param Span
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    @SuppressWarnings("static-access")
    public String rollDate(String orgDate, int Type, int Span) {
        try {
            String temp = "";
            int iyear, imonth, iday;
            int iPos = 0;
            char seperater = '-';
            if (orgDate == null || orgDate.length() < 6) {
                return "";
            }

            iPos = orgDate.indexOf(seperater);
            if (iPos > 0) {
                iyear = Integer.parseInt(orgDate.substring(0, iPos));
                temp = orgDate.substring(iPos + 1);
            } else {
                iyear = Integer.parseInt(orgDate.substring(0, 4));
                temp = orgDate.substring(4);
            }

            iPos = temp.indexOf(seperater);
            if (iPos > 0) {
                imonth = Integer.parseInt(temp.substring(0, iPos));
                temp = temp.substring(iPos + 1);
            } else {
                imonth = Integer.parseInt(temp.substring(0, 2));
                temp = temp.substring(2);
            }

            imonth--;
            if (imonth < 0 || imonth > 11) {
                imonth = 0;
            }

            iday = Integer.parseInt(temp);
            if (iday < 1 || iday > 31)
                iday = 1;

            Calendar orgcale = Calendar.getInstance();
            orgcale.set(iyear, imonth, iday);
            temp = this.rollDate(orgcale, Type, Span);
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    public static String rollDate(Calendar cal, int Type, int Span) {
        try {
            String temp = "";
            Calendar rolcale;
            rolcale = cal;
            rolcale.add(Type, Span);
            temp = sdf_date_format.format(rolcale.getTime());
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 返回默认的日期格式
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static synchronized String getDatePattern() {
        defaultDatePattern = "yyyy-MM-dd HH:mm:ss";
        return defaultDatePattern;
    }

    /**
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd
     *
     * @param aDate
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 取得给定日期的时间字符串，格式为当前默认时间格式
     *
     * @param theTime
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * 取得当前时间的Calendar日历对象
     *
     * @return
     * @throws ParseException
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }

    /**
     * 将日期类转换成指定格式的字符串形式
     *
     * @param aMask
     * @param aDate
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            logger.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 将指定的日期转换成默认格式的字符串形式
     *
     * @param aDate
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * 将日期字符串按指定格式转换成日期类型
     *
     * @param aMask   指定的日期格式，如:yyyy-MM-dd
     * @param strDate 待转换的日期字符串
     * @return
     * @throws ParseException
     * @date Mar 11, 2012
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (logger.isDebugEnabled()) {
            logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.error("====> {} exception type : {} content : {} ", logger.getName(), pe, pe.getStackTrace());
            throw pe;
        }
        return (date);
    }

    /**
     * 将日期字符串按默认格式转换成日期类型
     *
     * @param strDate
     * @return
     * @throws ParseException
     * @date Mar 11, 2012
     */
    public static Date convertStringToDate(String strDate) throws ParseException {
        Date aDate = null;

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("converting date with pattern: " + getDatePattern());
            }
            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            logger.error("Could not convert '" + strDate + "' to a date, throwing exception");
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
        return aDate;
    }

    /**
     * 返回一个JAVA简单类型的日期字符串
     *
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat();
        String NDateTime = formatter.format(new Date());
        return NDateTime;
    }

    /**
     * 将指定字符串格式的日期与当前时间比较
     *
     * @param strDate 需要比较时间
     * @return <p>
     * int code
     * <ul>
     * <li>-1 当前时间 < 比较时间</li>
     * <li>0 当前时间 = 比较时间</li>
     * <li>>=1当前时间 > 比较时间</li>
     * </ul>
     * </p>
     * @author DYLAN
     * @date Feb 17, 2012
     */
    public static int compareToCurTime(String strDate) {
        if (StringUtils.isBlank(strDate)) {
            return -1;
        }
        Date curTime = new Date();
        String strCurTime = null;
        try {
            strCurTime = sdf_datetime_format.format(curTime);
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug("[Could not format '" + strDate + "' to a date, throwing exception:"
                        + e.getLocalizedMessage() + "]");
            }
        }
        if (StringUtils.isNotBlank(strCurTime)) {
            return strCurTime.compareTo(strDate);
        }
        return -1;
    }

    /**
     * 返回指定年份中指定月份的天数
     *
     * @param year
     * @param month
     * @return 指定月的总天数
     */
    public static String getMonthLastDay(int year, int month) {
        int[][] day = {{0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return day[1][month] + "";
        } else {
            return day[0][month] + "";
        }
    }

    /**
     * 判断是平年还是闰年
     *
     * @param year
     * @return
     * @author dylan_xu
     * @date Mar 11, 2012
     */
    public static boolean isLeapyear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 注意：以下常量只能增加，不能修改 ////////////////////////////////////////////////
    // public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    // 客户端生成的日期格式
    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String CLIENT_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /**
     * yyyyMMdd
     */
    public static final String FILE_DATE_FORMAT = "yyyyMMdd";
    /**
     * HH:mm:ss
     */
    public static final String TIME_FORMAT = "HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String STRING_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String STRING_DATE_FORMAT2 = "yyyy-MM-dd HH:mm";
    /**
     * yyyy年MM月dd日 HH:mm:ss
     */
    public static final String CHINESE_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    public static final String CHINESE_DATE_FORMAT2 = "yyyy年MM月dd日";

    /**
     * yyMMddHHmmss
     */
    public static final String SEQUENCE_DATA_TIME = "yyMMddHHmmss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String RESP_DATE_FORMAT = "yyyyMMddHHmmss";// wenzhonghu,用于消息响应请求中的时间格式

    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";

    // 注意：以上常量只能增加，不能修改////////////////////////////////////////////////

    public static Timestamp getSysTime() {
        Timestamp sys_time = new Timestamp(Calendar.getInstance().getTimeInMillis());
        return sys_time;
    }

    /**
     * 获取当前时间，格式2010-08-03 14:10:04
     *
     * @return
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(STRING_DATE_FORMAT);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * Convert string to Date
     *
     * @return a java.util.Date object converted.
     */
    public static Date stringToDate(String pstrValue, String pstrDateFormat) {
        if ((pstrValue == null) || (pstrValue.equals(""))) {
            return null;
        }
        Date dttDate = null;
        try {
            SimpleDateFormat oFormatter = new SimpleDateFormat(pstrDateFormat);
            dttDate = oFormatter.parse(pstrValue);
            oFormatter = null;
        } catch (Exception e) {
            return null;
        }

        return dttDate;
    }

    // 字符串转时间 针对 yyyy-MM-dd 转为 yyyy-MM-dd HH:mm:ss格式的方法
    public static Date stringToDateNew(String pstrValue, String pstrDateFormat) {
        if ((pstrValue == null) || (pstrValue.equals(""))) {
            return null;
        }
        Date dttDate = null;
        Date nowDate = new Date();
        try {
            SimpleDateFormat oFormatter = new SimpleDateFormat(pstrDateFormat);
            pstrValue = pstrValue + oFormatter.format(nowDate).substring(10);
            dttDate = oFormatter.parse(pstrValue);
            oFormatter = null;
        } catch (Exception e) {
            return null;
        }

        return dttDate;
    }

    public static String dateToString(Date pdttValue) {
        return dateToString(pdttValue, null);
    }

    /**
     * Date convert to String.
     *
     * @return String representation of the given Date and DateFormat.
     */
    public static String dateToString(Date pdttValue, String pstrDateFormat) {
        String pstrDate = null; // return value
        if (pdttValue == null) {
            // if (pdttValue == null || "".equals(pdttValue)) {
            return null;
        }
        String formatStyle = null;
        if ((pstrDateFormat == null) || (pstrDateFormat.equals(""))) {
            formatStyle = DATE_FORMAT;
        } else {
            formatStyle = pstrDateFormat;
        }
        SimpleDateFormat oFormatter = new SimpleDateFormat(formatStyle);
        pstrDate = oFormatter.format(pdttValue);
        return pstrDate;
    }

    /***
     * 生成现在的时间格式字体串
     *
     * @param pstrDateFormat
     * @return
     */
    public static String getCurDateToString(String pstrDateFormat) {
        String pstrDate = null; // return value
        Date curDate = new Date();
        String formatStyle = null;
        if ((pstrDateFormat == null) || (pstrDateFormat.equals(""))) {
            formatStyle = "yyyy-MM-dd";
        } else {
            formatStyle = pstrDateFormat;
        }
        SimpleDateFormat oFormatter = new SimpleDateFormat(formatStyle);
        pstrDate = oFormatter.format(curDate);
        return pstrDate;

    }

    /**
     * DateTime convert to String.
     *
     * @return String representation of the given DateTime and DateFormat.
     */
    public static String dateTimeToString(Timestamp dt, String df) {
        String pstrDate = null; // return value
        if (dt == null) {
            return "";
        }
        String formatStyle = null;
        if ((df == null) || (df.equals(""))) {
            formatStyle = "yyyy-MM-dd HH:mm:ss";
        } else {
            formatStyle = df;
        }
        SimpleDateFormat oFormatter = null;
        try {
            oFormatter = new SimpleDateFormat(formatStyle);
            pstrDate = oFormatter.format(formatStyle);
        } catch (Exception e) {
            oFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pstrDate = oFormatter.format(dt);
        }
        return pstrDate;
    }

    /**
     * String convert to SQLDate.
     *
     * @return a java.sql.Date representatio of the given date string and format
     * string.
     */
    public static java.sql.Date stringToSQLDate(String pstrValue, String pstrDateFormat) throws ParseException {
        if ((pstrValue == null) || (pstrValue.equals(""))) {
            return null;
        }
        Date dttTempDate = stringToDate(pstrValue, pstrDateFormat);
        return new java.sql.Date(dttTempDate.getTime());
    }

    /**
     * String convert to SQLTime.
     *
     * @return a java.sql.Time representation of the given date string and
     * format string.
     */
    public static java.sql.Time stringToSQLTime(String pstrValue, String pstrDateFormat) throws ParseException {
        if ((pstrValue == null) || (pstrValue.equals(""))) {
            return null;
        }
        Date dttTempDate = stringToDate(pstrValue, pstrDateFormat);
        return new java.sql.Time(dttTempDate.getTime());
    }

    /**
     * String convert to SQLTimestamp.
     *
     * @return a java.sql.Timestamp representation of the given date string and
     * format string.
     */
    public static Timestamp stringToSQLTimestamp(String pstrValue, String pstrDateFormat) throws ParseException {
        if ((pstrValue == null) || (pstrValue.equals(""))) {
            return null;
        }
        Date dttTempDate = stringToDate(pstrValue, pstrDateFormat);
        return new Timestamp(dttTempDate.getTime());
    }

    /**
     * Get current date in form of java.sql.Date.
     *
     * @return java.sql.Date object of current date.
     */
    public static java.sql.Date getCurSQLDate() {
        return new java.sql.Date(new Date().getTime());
    }

    /**
     * Get current date in form of java.sql.Timestamp.
     *
     * @return java.sql.Timestamp object of current date.
     */
    public static Timestamp getCurSQLDateTime() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Get current date in form of java.sql.Date and then convert it into
     * String. The return date string follow that of the input param DateFormat.
     *
     * @return String representation of current date.
     */
    public static String getCurSQLDateInString(String pstrDateFormat) {
        String pstrDateTime = null;
        if ((pstrDateFormat != null) && (!pstrDateFormat.equals(""))) {
            Date curDateTime = new Date();
            java.sql.Date curSqlDateTime = new java.sql.Date(curDateTime.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat(pstrDateFormat);
            pstrDateTime = sdf.format(curSqlDateTime);
        }
        return pstrDateTime;
    }

    /**
     * Get current date in form of java.sql.Timestamp and then convert it into
     * String. The return date string follow that of the input param DateFormat.
     *
     * @return String representation of current date.
     */
    public static String getCurSQLDateTimeInString(String pstrDateFormat) {
        String pstrDateTime = null;
        if ((pstrDateFormat != null) && (!pstrDateFormat.equals(""))) {
            Date curDateTime = new Date();
            Timestamp curSqlDateTime = new Timestamp(curDateTime.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat(pstrDateFormat);
            pstrDateTime = sdf.format(curSqlDateTime);
        }
        return pstrDateTime;
    }

    /**
     * check the date by pattern
     *
     * @param sDateValue
     * @param sDateFormat
     * @return boolean, if check the date ok,then return true
     * @throws ParseException
     */
    public static boolean checkDateByMask(String sDateValue, String sDateFormat) throws ParseException {
        boolean isTrue = false;
        if (sDateValue == null || sDateFormat == null || sDateValue.equals(""))
            return false;
        if (sDateValue.length() != sDateFormat.length())
            return false;
        Date date = stringToDate(sDateValue, sDateFormat);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (sDateFormat.indexOf("yyyy") > -1) {
            isTrue = (cal
                    .get(Calendar.YEAR) == Integer
                    .parseInt(
                            sDateValue
                                    .substring(sDateFormat.indexOf("yyyy"),
                                            sDateFormat.indexOf("yyyy")
                                                    + 4))
                    && cal.get(Calendar.MONTH) == (Integer.parseInt(
                    sDateValue.substring(sDateFormat.indexOf("MM"), sDateFormat.indexOf("MM") + 2)) - 1)
                    && cal.get(Calendar.DATE) == Integer
                    .parseInt(sDateValue.substring(sDateFormat.indexOf("dd"), sDateFormat.indexOf("dd") + 2)));
        } else {
            isTrue = (cal
                    .get(Calendar.YEAR) == Integer
                    .parseInt(
                            sDateValue
                                    .substring(sDateFormat.indexOf("yy"),
                                            sDateFormat.indexOf("yy")
                                                    + 2))
                    && cal.get(Calendar.MONTH) == (Integer.parseInt(
                    sDateValue.substring(sDateFormat.indexOf("MM"), sDateFormat.indexOf("MM") + 2)) - 1)
                    && cal.get(Calendar.DATE) == Integer
                    .parseInt(sDateValue.substring(sDateFormat.indexOf("dd"), sDateFormat.indexOf("dd") + 2)));
        }
        return isTrue;
    }

    /**
     * get current date by local pattern
     *
     * @param ifdatetime
     * @return String
     */
    public static String getNowWithLocal(boolean ifdatetime) {
        Date dd = new Date();
        if (ifdatetime) {
            return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(dd);
        } else {
            return DateFormat.getDateInstance(DateFormat.LONG).format(dd);
        }
    }

    // 取得当前系统时间with yyyy-mm-dd 格式
    public static String getNow(boolean ifdatetime) {
        Date dd = new Date();
        SimpleDateFormat df = null;
        String rtn = "";
        if (ifdatetime) {
            df = new SimpleDateFormat(STRING_DATE_FORMAT);
        } else {
            df = new SimpleDateFormat(DATE_FORMAT);
        }
        rtn = df.format(dd);
        return rtn;
    }

    public static String getNowFormatLog() {
        String LOG_DATE_FORMAT = "yyyyMMdd HH:mm:ss";
        Date dd = new Date();
        SimpleDateFormat df = null;
        String rtn = "";
        df = new SimpleDateFormat(LOG_DATE_FORMAT);
        rtn = df.format(dd);
        return rtn;
    }

    /**
     * 用于从datetime中取得date
     *
     * @param strDate String 从数据库中取得的日期型数据
     * @return String 以yyyy-mm-dd返回日期
     */
    public static String subDate(String strDate) {
        if (strDate.length() > 10) {
            int pos = strDate.indexOf(" ");
            if (pos > 0) {
                return strDate.substring(0, pos);
            } else {
                return strDate;
            }
        } else {
            return strDate;
        }
    }

    // 用于从datetime中取得time
    public static String subTime(String strDate) {
        if (strDate.length() >= 8) {
            int pos = strDate.indexOf(" ");
            int pos1 = strDate.indexOf(".");
            if (pos1 <= 0)
                pos1 = strDate.length();
            if (pos > 0) {
                return strDate.substring(pos + 1, pos1);
            } else {
                if (strDate.indexOf("-") > 0)
                    return "";
                else
                    return strDate;
            }
        } else {
            return strDate;
        }
    }

    // 用于从datetime中取得datetime
    public static String subDateTime(String strDate) {
        if (strDate.length() > 10) {
            int pos = strDate.indexOf(".");
            if (pos > 0) {
                return strDate.substring(0, pos);
            } else {
                return strDate;
            }
        } else {
            return strDate;
        }
    }

    /**
     * 给定两个日期，返回日期的天数差
     *
     * @param startDate
     * @param endDate
     * @return int
     */
    public static int getDayNumber(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        if (startCal.after(endCal)) {
            return 0;
        }
        int num = 0;
        while (startCal.before(endCal)) {
            startCal.add(Calendar.DATE, 1);
            num++;
        }
        return num;
    }

    public static String getDuration(Timestamp createTime, Timestamp finishTime) {
        String rtn = "0小时";
        if (createTime == null) {
            return rtn;
        }
        long ctime = createTime.getTime();
        long ftime = System.currentTimeMillis();
        if (finishTime != null) {
            ftime = finishTime.getTime();
        }
        int dur = (int) (((ftime - ctime) / 1000) / 60);// min
        double dur_day = (double) dur / (60 * 24);
        if (dur_day > 1) {
            // rtn="1天以上";
            DecimalFormat format = new DecimalFormat("###.##");
            rtn = format.format(dur_day) + "天";
        } else {
            double dur_hour = (double) dur / 60;
            DecimalFormat format = new DecimalFormat("###.##");
            rtn = format.format(dur_hour) + "小时";
        }

        return rtn;

    }

    public static String getDurationMinute(Timestamp createTime, Timestamp finishTime) {
        String rtn = "0min";
        if (createTime == null) {
            return rtn;
        }
        long ctime = createTime.getTime();
        BigDecimal ct = new BigDecimal(Long.toString(ctime));
        long ftime = System.currentTimeMillis();
        if (finishTime != null) {
            ftime = finishTime.getTime();
        }
        BigDecimal ft = new BigDecimal(Long.toString(ftime));
        BigDecimal a = ft.subtract(ct);
        BigDecimal o = new BigDecimal("0");
        if (a.compareTo(o) != 0) {
            BigDecimal thonsand = new BigDecimal("1000");
            BigDecimal b = a.divide(thonsand, 2);
            BigDecimal sixty = new BigDecimal("60");
            double du = b.divide(sixty, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            DecimalFormat format = new DecimalFormat("###.##");
            rtn = format.format(du) + "min";
        }
        return rtn;
    }

    public static String getDurationHour(Timestamp time1, Timestamp time2, String direction) {
        String f = direction;
        if (f == null) {
            f = "+";
        }
        long ctime1 = System.currentTimeMillis();
        long ctime2 = System.currentTimeMillis();
        if (time1 != null) {
            ctime1 = time1.getTime();
        }
        if (time2 != null) {
            ctime2 = time2.getTime();
        }
        int dur = 0;
        if ("+".equals(f)) {// time2-time1
            dur = (int) (((ctime2 - ctime1) / 1000) / 60);// min
        } else {
            dur = (int) (((ctime1 - ctime2) / 1000) / 60);// min
        }

        double dur_hour = (double) dur / 60;
        DecimalFormat format = new DecimalFormat("###.##");
        return format.format(dur_hour) + "hr";

    }

    /**
     * 给定结束时间和天数,返回开始时间
     *
     * @param endDates
     * @param days
     * @return String
     */
    public static String getStartDate(int days, String endDates) {
        Calendar endCal = Calendar.getInstance();
        Date endDate = stringToDate(endDates, STRING_DATE_FORMAT);
        endCal.setTime(endDate);
        endCal.add(Calendar.DATE, -days);
        SimpleDateFormat sdf = new SimpleDateFormat(STRING_DATE_FORMAT);
        return sdf.format(endCal.getTime());

    }

    /**
     * 获取当日开始时间
     *
     * @return
     */
    public static Date getDayStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取本周五的日期
     *
     * @param date
     * @return
     */
    public static String getFriday(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day + 4);
        String imptimeBegin = sdf.format(cal.getTime());
        return imptimeBegin;
    }

    /**
     * 获取上上周六的日期
     *
     * @param date
     * @return
     */
    public static Date getSaturday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day - 9);
        return cal.getTime();
    }

    public static Timestamp getDayStartTimestamp(Date date) {
        Date start = getDayStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取下一日开始时间
     *
     * @param date
     * @return
     */
    public static Date getNextDayStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 几天后的时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getNextDaysByStartDate(Date date, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的周的开始第一天
     *
     * @param date
     * @return
     */
    public static Date getWeekkStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); // 获取周开始基准
        // int current = calendar.get(Calendar.DAY_OF_WEEK)-1; // 获取当天周内天数
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // 当天-基准，获取周开始日期

        return calendar.getTime();
    }

    /**
     * 返回区间内所有月
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String[] getDateArrayByBetweenDateMonth(Date beginDate, Date endDate) {
        List<String> list = new ArrayList<String>();
        int num = getMonthNumber(beginDate, endDate);
        String res[] = new String[num];
        Calendar calendar = Calendar.getInstance();//定义日期实例
        calendar.setTime(beginDate);//设置日期起始时间
        while (calendar.getTime().before(endDate)) {//判断是否到结束日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String month = sdf.format(calendar.getTime());
            list.add(month);
            calendar.add(Calendar.MONTH, 1);//进行当前日期月份加1
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
        }
        return res;
    }

    /**
     * 返回区间内所有日期
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String[] getDateArrayByBetweenDate(Date beginDate, Date endDate) {

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        int num = getDayNumber(beginDate, endDate);
        String res[] = new String[num];
        res[0] = formatter.format(beginDate);
        for (int i = 1; i < num; i++) {
            Date nextDay = getNextDaysByStartDate(beginDate, 1);
            String nextDayString = formatter.format(nextDay);
            res[i] = nextDayString;
            beginDate = nextDay;

        }

        return res;
    }


    /**
     * 得到某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
    }

    /**
     * 得到某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

    }

    /**
     * 得到某年某月的天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }


    /**
     * 给定两个日期，返回日期的天数差
     *
     * @param startDate
     * @param endDate
     * @return int
     */
    public static int getMonthNumber(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        if (startCal.after(endCal)) {
            return 0;
        }
        int num = 1;
        while (startCal.before(endCal)) {
            startCal.add(Calendar.MONTH, 1);
            num++;
        }
        return num;
    }


    /**
     * 几周后的时间
     *
     * @param date
     * @param week
     * @return
     */
    public static Date getNextWeeksByStartDate(Date date, int week) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, week * 7);
        return calendar.getTime();
    }

    /**
     * 几月后的时间
     *
     * @param date
     * @param month
     * @return
     */
    public static Date getNextMonthsByStartDate(Date date, int month) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 几年后的时间
     *
     * @param date
     * @param year
     * @return
     */
    public static Date getNextYearsByStartDate(Date date, int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 几小时后的时间
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date getNextHoursByStartDate(Date date, int hour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    /**
     * 几分钟后的时间
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date getNextMinutesByStartDate(Date date, int minute) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 几秒后的时间
     *
     * @param date
     * @param second
     * @return
     */
    public static Date getNextSecondsByStartDate(Date date, int second) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Timestamp getNextDayStartTimestamp(Date date) {
        Date start = getNextDayStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取月开始时间
     *
     * @return
     */
    public static Date getMonthStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Timestamp getMonthStartTimestamp(Date date) {
        Date start = getMonthStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取下月开始时间
     *
     * @param date
     * @return
     */
    public static Date getNextMonthStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.MONTH, 1);

        return calendar.getTime();
    }

    public static Timestamp getNextMonthStartTimestamp(Date date) {
        Date start = getNextMonthStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取当年开始时间
     *
     * @return
     */
    public static Date getYearStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Timestamp getYearStartTimestamp(Date date) {
        Date start = getYearStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取下一年开始时间
     *
     * @return
     */
    public static Date getNextYearStartDate(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.YEAR, 1);

        return calendar.getTime();
    }

    public static Timestamp getNextYearStartTimestamp(Date date) {
        Date start = getNextYearStartDate(date);
        return new Timestamp(start.getTime());
    }

    /**
     * 获取N天之后的具体时间;
     *
     * @param dateNum
     * @return
     */
    public static Date getAfterDate(int dateNum) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day + dateNum);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }

    /**
     * 获取N天之后的具体时间;
     *
     * @param dateNum
     * @return
     */
    public static Date getAfterDateByDate(Date date, int dateNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day + dateNum);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }

    /**
     * 获取N天之前的具体时间;
     *
     * @param dateNum
     * @return
     */
    public static Date getBeforeDate(int dateNum) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day - dateNum);
        Date beforeDate = calendar.getTime();
        return beforeDate;
    }

    /**
     * 比较两个时间是否大于要比较时间；
     *
     * @param compareDate
     * @param currentDate
     * @return
     */
    public static boolean isLargeCurrentDate(Date compareDate, Date currentDate) {

        // long ms = compareDate.getTime()-currentDate.getTime();
        if (compareDate.after(currentDate)) {
            return true;
        }
        return false;
    }

    /**
     * 获取当年的月份
     *
     * @param currentdate
     * @return
     */
    public static int getMonthOfThisYear(Date currentdate) {
        Calendar cal = Calendar.getInstance();
        if (currentdate != null) {
            cal.setTime(currentdate);
        } else {
            cal.setTime(new Date());
        }
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当月的天份
     *
     * @param currentdate
     * @return
     */
    public static int getDayOfThisYear(Date currentdate) {
        Calendar cal = Calendar.getInstance();
        if (currentdate != null) {
            cal.setTime(currentdate);
        } else {
            cal.setTime(new Date());
        }
        return cal.get(Calendar.DATE);
    }

    /**
     * 获取当年的时间
     *
     * @param currentdate
     * @return
     */
    public static int getYearOfThisYear(Date currentdate) {
        Calendar cal = Calendar.getInstance();
        if (currentdate != null) {
            cal.setTime(currentdate);
        } else {
            cal.setTime(new Date());
        }
        return cal.get(Calendar.YEAR);
    }

    /***
     * 两个日期比较，返回相差天数
     *
     * @param sDateValue1
     * @param sDateValue2
     * @return
     * @throws ParseException
     */
    public static long getCompareDateNum(String sDateValue1, String sDateValue2) throws ParseException {
        long DAY = 24L * 60L * 60L * 1000L;
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Date d1 = df.parse(sDateValue1);
        Date d2 = df.parse(sDateValue2);

        return ((d2.getTime() - d1.getTime()) / DAY);
    }

    /**
     * 得到本月的今天
     *
     * @return
     */
    public static int getMonthOfToday() {
        GregorianCalendar vTodayCal = new GregorianCalendar();
        return vTodayCal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static String getMonthLastDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取下个月的今天
     *
     * @param currDate
     * @return
     */
    public static Date getNextMonthDay(Date currDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(currDate);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }

    /**
     * 比较天数 endDate >= startDate为true,否则false
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareDate(Date startDate, Date endDate) {
        Calendar sd = Calendar.getInstance();
        Calendar ed = Calendar.getInstance();
        sd.setTime(startDate);
        int day1 = sd.get(Calendar.DAY_OF_YEAR);
        ed.setTime(endDate);
        int day2 = ed.get(Calendar.DAY_OF_YEAR);
        sd = null;
        ed = null;
        return (day1 - day2 > 0) ? true : false;
    }

    /**
     * 获取两个相隔天数 endDate > startDate为true,否则false
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getApartDate(Date startDate, Date endDate) {
        Calendar sd = Calendar.getInstance();
        Calendar ed = Calendar.getInstance();
        sd.setTime(startDate);
        int day1 = sd.get(Calendar.DAY_OF_YEAR);
        ed.setTime(endDate);
        int day2 = ed.get(Calendar.DAY_OF_YEAR);
        sd = null;
        ed = null;
        return (day2 - day1) + 1;
    }

    /**
     * <p>
     * Description: 获取两个日期之间的天差
     * </p>
     * <p>
     * Date: 2017年8月1日 下午4:10:59
     * </p>
     *
     * @author Bean.Li
     */
    public static int getNumOfDays(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        try {
            d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long diff = Math.abs(d2.getTime() - d1.getTime());
            long days = (long) (diff / (1000 * 60 * 60 * 24));
            return Long.valueOf(days).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param date1
     * @param date2
     * @return int
     * @Description 获取两个日期之间的小时差
     * @author Bean.Li
     * @date 2017年10月23日 下午1:12:49
     */
    public static int getNumOfHours(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        try {
            d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long diff = Math.abs(d2.getTime() - d1.getTime());
            long hours = (long) (diff / (1000 * 60 * 60));
            return Long.valueOf(hours).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNumOfHours(Date d1, Date d2) {
        long diff = Math.abs(d2.getTime() - d1.getTime());
        long hours = (long) (diff / (1000 * 60 * 60));
        return Long.valueOf(hours).intValue();
    }

    public static int getNumOfSeconds(Date d1, Date d2) {
        long diff = Math.abs(d2.getTime() - d1.getTime());
        long hours = (long) (diff / (1000));
        return Long.valueOf(hours).intValue();
    }

    /*
     * 获取当前天累加后的日期 如：今天是2011-4-9 传0:2011-4-9 传1:2011-4-10 传-1:2011-4-8
     * formatStr如：yyyy-MM-dd
     */
    public static String getDayStr(int i, String formatStr) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(new Date());
        gc.add(Calendar.DATE, i);
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        String dateString = formatter.format(gc.getTime());
        return dateString;
    }

    /*
     * 日期格式化
     *
     * @param time 参数格式为：20120515或201205，到月或到日
     *
     * @return 返回为2012年05月15日或2012年05月
     */
    public static String formatDate(String time) {
        int length = time.length();
        String year = time.substring(0, 4);
        String month = time.substring(4, 6);
        String day = null;
        String date = null;
        if (length == 6) {
            date = year + "年" + month + "月";
        } else {
            day = time.substring(6);
            date = year + "年" + month + "月" + day + "日";
        }
        return date;
    }

    /**
     * 计算 data2 月份减去data1的月份的差值
     *
     * @param data1
     * @param data2
     * @return
     */
    public static int getMonthBetween(Date data1, Date data2) {
        Calendar ca1 = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();
        ca1.setTime(data1);
        ca2.setTime(data2);
        return ca2.get(Calendar.MONTH) - ca1.get(Calendar.MONTH);
    }

    public static List getYears() {
        List list = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        list.add(String.valueOf(cal.get(Calendar.YEAR)));
        list.add(String.valueOf(cal.get(Calendar.YEAR) - 1));
        list.add(String.valueOf(cal.get(Calendar.YEAR) - 2));
        list.add(String.valueOf(cal.get(Calendar.YEAR) - 3));
        list.add(String.valueOf(cal.get(Calendar.YEAR) - 4));
        return list;
    }

    /**
     * 用户自定义格式化
     *
     * @param d
     * @param pattern
     * @return
     */
    public static String format(Date d, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }

    /**
     * @param d
     * @param pattern
     * @return
     */
    public static String parse(Date d, String pattern) {
        if (d == null)
            return "未知";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }

    /**
     * 输出类似博客论坛 "刚刚"等时间
     * <p>
     * 1.d和当前系统时间比较 小于10分钟 输出 “刚刚” 2.如果d和当前系统时间是同一天,计算出d和当前时间的差，四舍五入成整数小时 3.跨一天
     * 即d和当前时间差为一天 输出“昨天” 4.差2天 输出“前天” 5.差两天以上，直接输出yyyy-MM-dd HH:mm
     *
     * @param time
     * @param format
     * @return
     */
    public static String converDate(Date time, String format) {
        if (time == null || "".equals(time))
            return "";
        return converDate(time.toString(), format);
    }

    /**
     * 输出类似博客论坛 "刚刚"等时间
     * <p>
     * 1.d和当前系统时间比较 小于10分钟 输出 “刚刚” 2.如果d和当前系统时间是同一天,计算出d和当前时间的差，四舍五入成整数小时 3.跨一天
     * 即d和当前时间差为一天 输出“昨天” 4.差2天 输出“前天” 5.差两天以上，直接输出yyyy-MM-dd HH:mm
     *
     * @param time
     * @param format
     * @return
     */
    public static String converDate(String time, String format) {

        if (time == null || "".equals(time))
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat(STRING_DATE_FORMAT);
        Date d = null;
        Date d2 = new Date();
        // 首先将用户传入的time参数格式为date类型
        try {
            d = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StringBuffer sbuf = new StringBuffer(50);
        if (format == null || "".equals(format))// 假如用户未输入日期格式化表达式，则按照系统默认格式输出
        {
            /**
             * 1.d和当前系统时间比较 小于等于30分钟 输出 “刚刚”
             * 2.如果d和当前系统时间是同一天,计算出d和当前时间的差，四舍五入成整数小时 3.跨一天 即d和当前时间差为一天 输出“昨天”
             * 4.差2天 输出“前天” 5.差两天以上，直接输出yyyy-MM-dd HH:mm
             */
            double time1 = d.getTime();
            double time2 = d2.getTime();
            // 获取相差分钟数
            BigDecimal diffmin = new BigDecimal((time2 - time1) / 1000 / 60).setScale(0, BigDecimal.ROUND_HALF_UP);
            BigDecimal diffhour = new BigDecimal((time2 - time1) / 1000 / 3600).setScale(0, BigDecimal.ROUND_HALF_UP); // 获取小时数
            // 1.d和当前系统时间比较 小于10分钟 输出 “刚刚”
            if (diffmin.intValue() <= 30) {
                sbuf.append("刚刚");
            }
            // 不在同一天的
            else {
                int daydiff = daysBetween(d, d2);
                switch (daydiff) {
                    case 0:
                        // 2.如果d和当前系统时间是同一天,计算出d和当前时间的差，四舍五入成整数小时
                        sbuf.append(diffhour + "小时前");
                        break;
                    case 1:
                        sbuf.append("昨天");
                        break;
                    case 2:
                        sbuf.append("前天");
                        break;

                    default:
                        sdf = new SimpleDateFormat(STRING_DATE_FORMAT2);
                        sbuf.append(sdf.format(d));
                        break;
                }
            }
        } else {
            sdf = new SimpleDateFormat(format);
            sbuf.append(sdf.format(d));
        }

        return sbuf.toString();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    // 比较俩个时间相差多少小时
    public static Long getTwoTimeDifferHour(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;

        return hour;
    }

    // 比较俩个时间相差多少天
    public static Long getTwoTimeDifferDay(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;

        return day;
    }

    /**
     * 得到距离当天结束还有多少秒钟
     *
     * @return
     */
    public static long getToDayEndSeconds() {
        Date dayEndState = getDayEndState(new Date());
        // 获得两个时间的毫秒时间差异
        long diff = dayEndState.getTime() - new Date().getTime();
        // 计算差多少秒
        long seconds = diff / 1000;
        return seconds;
    }

    public static Date getExpiryDate(int minutes) {

        // 根据当前日期，来得到到期日期
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }

    public static Date getExpiryDateSecond(int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, second);

        return calendar.getTime();
    }


    public static Date StringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static final Date parseDateTime(String source) throws ParseException {
        if (source == null || source.length() == 0) {
            return null;
        }
        try {
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat1.parse(source);
        } catch (ParseException e) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                return dateFormat.parse(source);
            } catch (Exception e1) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd��");
                return dateFormat.parse(source);
            }
        }

    }

    public static Date parseDateFromTZDate(String tzDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return df.parse(tzDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param
     * @return
     */
    public static String dateToStrTZDate(Date tzDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = df.format(tzDate);
        return dateString;
    }

    public static int getWeekOfyear(String dateStr) {
        Date date = stringToDate(dateStr, DATE_FORMAT);
        int weekno;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        weekno = cal.get(Calendar.WEEK_OF_YEAR);
        return weekno;
    }

    public static int getMonthOfyear(String dateStr) {
        Date date = stringToDate(dateStr, DATE_FORMAT);
        int monthno;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        monthno = cal.get(Calendar.MONTH);
        return monthno + 1;
    }

    public static int getYearOfDate(String dateStr) {
        Date date = stringToDate(dateStr, DATE_FORMAT);
        int yearno;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        yearno = cal.get(Calendar.YEAR);
        return yearno;
    }

    public static int getYearOfDate(Date date) {
        int yearno;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        yearno = cal.get(Calendar.YEAR);
        return yearno;
    }

    public static int getDayOfWeek(String dateStr) {
        Date date = stringToDate(dateStr, DATE_FORMAT);
        int dayno;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            dayno = 7;
        } else {
            dayno = cal.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayno;
    }

    public static Date getDayEndState(Date endDate) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter2.parse(formatter.format(endDate) + DateUtil.DAY_END_STRING_HHMMSS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDayEndState(String endDate) {
        if (endDate.length() > 10) {
            endDate = endDate.substring(0, 10);
        }
        Date date = null;
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter2.parse(endDate + DateUtil.DAY_END_STRING_HHMMSS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期字符串转时间戳
     *
     * @param s
     * @return
     * @throws ParseException
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }


    /**
     * 0：周日
     */
    public final static String dayNames[] = {"0", "1", "2", "3", "4", "5", "6"};

    public static String getWeek(String curDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(curDate));
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            return dayNames[dayOfWeek - 1];
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        return imptimeBegin + "," + imptimeEnd;
    }

    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    public static String getWeekOfDateNum(Date date) {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 比较两个日期字符串大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据输入时间获取上周或下周周一和周五的日期
     *
     * @param date
     * @param operation last  next
     * @return
     * @throws ParseException
     */
    public static String getNextOrLastWeekMonday(Date date, String operation) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 5 - dayOfWeek;
        if ("last".equals(operation)) {
            calendar1.add(Calendar.DATE, offset1 - 7);
            calendar2.add(Calendar.DATE, offset2 - 7);
        } else if ("next".equals(operation)) {
            calendar1.add(Calendar.DATE, offset1 + 7);
            calendar2.add(Calendar.DATE, offset2 + 7);
        }
        String lastBeginDate = sdf.format(calendar1.getTime());
        String lastEndDate = sdf.format(calendar2.getTime());
        return lastBeginDate + "," + lastEndDate;
    }


    /**
     * 获取指定年度月份的开始和结束日期
     *
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    public static Date[] getMonthStartAndEndDate(String year, String month) throws ParseException {
        Date[] date = new Date[2];
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = sf.parse(year + "-" + month + "-01");
        calendar.setTime(theDate);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(calendar.DATE));
        date[0] = calendar.getTime();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
        date[1] = calendar.getTime();
        return date;
    }

    /**
     * @param status -1 上周， 1 下周
     * @param date
     * @return
     */
    public static String nextOrLastWeekDate(int status, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.WEEK_OF_MONTH, status);// 增加一个礼拜
        return dateToStringYMD(calendar.getTime());
    }

    /**
     * 当前时间是否是周末
     *
     * @param bDate
     * @return true 周末， false 非周末
     * @throws ParseException
     */
    public static boolean isWeekend(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    public static final Date parseDate(String source) throws ParseException {
        if (source == null || source.length() == 0) {
            return null;
        }
        try {
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat1.parse(source);
        } catch (ParseException e) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                return dateFormat.parse(source);
            } catch (Exception e1) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd��");
                return dateFormat.parse(source);
            }
        }

    }

    public static String formatYMD(Date date) {
        return date == null ? "" : formatDateTime(date, "yyyy-MM-dd");
    }

    public static String formatDateTime(Date date, String format) {
        if (date == null)
            return null;
        if (format == null)
            return date.toString();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 获取一天的开始时间
     */
    public static Date getTodayStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一天的开始时间 yyyy:MM:dd 00:00:00
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        return dayStart;
    }

    /**
     * 获取一天的结束时间
     */
    public static Date getTodayEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一天的结束时间 yyyy:MM:dd 23:59:59
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dayEnd = calendar.getTime();
        return dayEnd;
    }

    /**
     * 是否是同一天
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 是否是同一天
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 获取两个时间中的每一天
     */
    public static String[] getDays(Date bigtime, Date endtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //定义一个接受时间的集合
        List<String> dates = new ArrayList<>();
        dates.add(simpleDateFormat.format(bigtime));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(bigtime);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endtime);
        while (endtime.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(simpleDateFormat.format(calBegin.getTime()));
        }
        String[] date = new String[dates.size()];
        dates.toArray(date);
        return date;
    }

    /**
     * 获取两个时间中的每个月
     */
    public static String[] getMonths(Date bigtime, Date endtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        List<String> dates = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(bigtime);
        calBegin.set(calBegin.get(Calendar.YEAR), calBegin.get(Calendar.MONTH), 1);

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endtime);
        calEnd.set(calEnd.get(Calendar.YEAR), calEnd.get(Calendar.MONTH), 2);
        while (calBegin.before(calEnd)) {
            dates.add(simpleDateFormat.format(calBegin.getTime()));
            calBegin.add(Calendar.MONTH, 1);
        }
        String[] date = new String[dates.size()];
        dates.toArray(date);
        return date;
    }

    public static String[] getDay(Date bigtime, Date endtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //定义一个接受时间的集合
        List<String> dates = new ArrayList<>();
        dates.add(simpleDateFormat.format(endtime));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(endtime);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(bigtime);
        while (bigtime.before(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, -1);
            dates.add(simpleDateFormat.format(calBegin.getTime()));
        }
        String[] date = new String[dates.size()];
        dates.toArray(date);
        return date;
    }

    public static String[] getWeeks(Date start, Date end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dates = new ArrayList<>();
        long diff = Math.abs(start.getTime() - end.getTime());
        long days = (diff / (1000 * 60 * 60 * 24));
        int i = Long.valueOf(days).intValue();
        int j = i / 7;
        if (i % 7 == 0) {
            j = j - 1;
        }
        Date date = end;
        dates.add(simpleDateFormat.format(end));
        for (int k = 0; k <= j; k++) {
            date = DateUtil.getPastDates(date, 7);
            dates.add(simpleDateFormat.format(date));
        }
        String[] str = new String[dates.size()];
        dates.toArray(str);
        return str;
    }

    public static String[] getMonth(Date start, Date end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dates = new ArrayList<>();
        long diff = Math.abs(start.getTime() - end.getTime());
        long days = (diff / (1000 * 60 * 60 * 24));
        int i = Long.valueOf(days).intValue();
        int j = i / 30;
        if (i % 30 == 0) {
            j = j - 1;
        }
        Date date = end;
        dates.add(simpleDateFormat.format(end));
        for (int k = 0; k <= j; k++) {
            date = DateUtil.getPastDates(date, 30);
            dates.add(simpleDateFormat.format(date));
        }
        String[] str = new String[dates.size()];
        dates.toArray(str);
        return str;
    }

    public static Date beforeOneHourToNowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        return calendar.getTime();
    }

    /**
     * 获取一天的某个小时开始时间
     */
    public static Date getCurrentHourStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一天的开始时间 yyyy:MM:dd 00:00:00
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        return dayStart;
    }

    /**
     * 获取一天的某个小时开始时间
     */
    public static Date getTodayHourStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一天的开始时间 yyyy:MM:dd 00:00:00
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        return dayStart;
    }

    /**
     * 获取一天的某个小时结束时间
     */
    public static Date getTodayHourEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一天的结束时间 yyyy:MM:dd 23:59:59
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dayEnd = calendar.getTime();
        return dayEnd;
    }

    /***
     *  功能描述：日期转换cron表达式
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
    
    public static String date2String(Date date){
		String data = "";
		if(date != null){
			data = date2String(date,"yyyy-MM-dd HH:mm:ss");
		}
		return data;
	}

	public static String date2String(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
	}
}
