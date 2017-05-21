package com.ms.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;



public class DateUtils {

	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	/**
	 * @return
	 */
	public static Date getCurrentDateTimeInGMT() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MILLISECOND, cal.getTimeZone().getRawOffset() * (-1));
		return cal.getTime();
	}

	/**
	 * @return
	 */
	public static Date getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.getTime();
	}

	/**
	 * @return
	 */
	public static Calendar getCustomCalendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(0);
		return cal;
	}

	/**
	 * @param currentDate
	 * @param noOfDays
	 * @return
	 */
	public static Date getPreviousDateByDays(Date currentDate, int noOfDays) {
		Calendar currentCalander = Calendar.getInstance();
		currentCalander.setTime(currentDate);
		currentCalander.add(Calendar.DAY_OF_YEAR, -noOfDays);
		return currentCalander.getTime();
	}

	/**
	 * @param date
	 * @return
	 */
	public static long getTimeInMilis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * @param date
	 * @return
	 */
	public static Date convertToDateObject (String dateinStr,String format ) {
		 Date date = null;
		 if(dateinStr !=null  && !dateinStr.equals("")){
			 try {
				 DateFormat df = new SimpleDateFormat(format); 
				 date = df.parse(dateinStr);
			        
			    } catch (ParseException e) {
			        e.printStackTrace();
			    }
		 }
		 
		 return date;
	}
	
	public static String convertToStringObject (Date date,String format ) {
		String dateStr = null;
		if(date != null){
		 DateFormat df = new SimpleDateFormat(format); 
		 dateStr = df.format(date);
		}
		 return dateStr;
	}
	
	
	
	public static Timestamp convertStrtDatetoTimeStamp(String dateStr) {
		Date date = convertToDateObject(dateStr,"MM/dd/yyyy");
		if(date!= null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			Timestamp tm = new Timestamp(cal.getTimeInMillis());
			return tm;
		}else
			return null;
		
	}
	public static String convertTimeStampToDateStr(Timestamp timestamp) {
		if(timestamp != null){
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(timestamp.getTime());
		return convertToStringObject(cal.getTime(),"MM/dd/yyyy");
		}else 
			return null;
		
	}
	
	/**
	 * @param sourceDate
	 * @return
	 */
	public static String  convertDateFormat(String sourceDate) {
		String formattedDate = "";
		DateFormat readFormat = new SimpleDateFormat("MMM dd yyyy hh:mmaaa", Locale.US);

		DateFormat writeFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = readFormat.parse(sourceDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			formattedDate = writeFormat.format(date);
		}
		return formattedDate;
		
	}
	
	

}
