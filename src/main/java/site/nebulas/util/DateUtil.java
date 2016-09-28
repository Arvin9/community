package site.nebulas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	public final static String FORMAT_DATE = "yyyy-MM-dd";  
    public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";  

    public final static String FORMAT_DATE_ZH = "yyyy年MM月dd日";  
    public final static String FORMAT_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";  

    public final static String TYPE_DATE = "date";  
    public final static String TYPE_DATETIME = "datetime"; 
	
	public static void main(String[] args) {
		System.out.println(getCurrentSysDate());
	}
	/** 
     * 得到当前系统日期 
     * @return YYYY-MM-DD HH:mm:ss
     */  
    public static String getCurrentSysDate() {  
            java.sql.Timestamp timeNow = new java.sql.Timestamp(System.currentTimeMillis());  
            return format(timeNow, TYPE_DATETIME);  
    }
    
    /** 
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date 
     * @dateType 格式化的类型,date和datetime 
     */  
    public static String format(Object dateValue, String dateType) {  
            if (dateValue == null)  
                    return "";  
            if (dateValue instanceof java.sql.Date) {  
                    return dateValue.toString();  
            } else if (dateValue instanceof java.util.Date) {  
                    if (dateType.equals(TYPE_DATE)) {  
                            java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE);  
                            return sfdate.format(dateValue);  
                    } else if (dateType.equals(TYPE_DATETIME)) {  
                            java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME);  
                            return sftime.format(dateValue);  
                    } else {  
                            return "非法日期格式[" + dateType + "]";  
                    }  
            } else {  
                    return "非日期类型";  
            }  
    }
    
    
    /** 
     * 转换日期对象为中文化日期 
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date 
     * @dateType 格式化的类型,date和datetime 
     */  
    public static String formatZh(Date dateValue, String dateType) {  
            if (dateValue == null)  
                    return "";  
            if (dateValue instanceof java.sql.Date) {  
                    return dateValue.toString();  
            } else if (dateValue instanceof java.util.Date) {  
                    if (dateType.equals(TYPE_DATE)) {  
                            java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE_ZH);  
                            return sfdate.format(dateValue);  
                    } else if (dateType.equals(TYPE_DATETIME)) {  
                            java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME_ZH);  
                            return sftime.format(dateValue);  
                    } else {  
                            return "非法日期格式[" + dateType + "]";  
                    }  
            } else {  
                    return "非日期类型";  
            }  
    }
    
    /**
	 * 
	 * return : "2016-09-23"
	 * */
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 
	 * return : "2016-09-23 22:19:56"
	 * */
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * Param  ： "2016-09-28","2016-10-02"
	 * return : [2016-09-28, 2016-09-29, 2016-09-30, 2016-10-01, 2016-10-02]
	 * */
	public static List<String> getDateList(String begin,String end){
		List<String> list = new ArrayList<String>();
		Calendar calendar  = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date beginDate = sdf.parse(begin);
			Date endDate = sdf.parse(end);
			
			long days;
			if(endDate.getTime() >= beginDate.getTime()){
				days = (endDate.getTime() - beginDate.getTime())/(1000 * 60 * 60 * 24);
				calendar.setTime(beginDate);
				System.out.println(days);
				list.add(sdf.format(calendar.getTime()));
				for(int i = 0; i < days; i++){
					calendar.add(Calendar.DATE, 1);
					list.add(sdf.format(calendar.getTime()));
				}
			}else{
				days = (beginDate.getTime() - endDate.getTime())/(1000 * 60 * 60 * 24);
				calendar.setTime(endDate);
				System.out.println(days);
				list.add(sdf.format(calendar.getTime()));
				for(int i = 0; i < days; i++){
					calendar.add(Calendar.DATE, 1);
					list.add(sdf.format(calendar.getTime()));
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
 
}
