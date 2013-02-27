package com.rickwebstudy.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	private static final String DATE_FMT = "yyyy-MM-dd";
	private static final SimpleDateFormat FORMATER = new SimpleDateFormat(
			DATE_FMT,Locale.US);

	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		return new Date(calendar.get(Calendar.YEAR) - 1900,
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
	}

	public static String getCurrentDateString() {
		return FORMATER.format(getCurrentDate());
	}

	public static Date getDateWithInterval(int field, int interval) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		calendar.add(field, interval);
		return calendar.getTime();
	}
	
	public static String getFileNameByCurrentDate(Calendar date){
		return date.get(Calendar.YEAR) + "_" + (date.get(Calendar.MONTH) + 1) + "_"
				+ date.get(Calendar.DAY_OF_MONTH) + "_" + date.get(Calendar.HOUR_OF_DAY) + "_"
				+ date.get(Calendar.MINUTE) + "_" + date.get(Calendar.SECOND);
	}

	public static int compare(Date first, Date second) {
		return first.compareTo(second);
	}

	public static String format(Date date) {
		return FORMATER.format(date);
	}

	public static String format(String fmt, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt,Locale.US);
		return sdf.format(date);
	}

	public static String format(String fmt, long milliseconds){
		SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.US);
		return sdf.format(milliseconds);
	}
	
	public static Date parse(String date) {
		try {
			return FORMATER.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date parse(String fmt, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int compareDayCount(Calendar startTimeCalendar,Calendar endTimeCalendar){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long nd = 1000*24*60*60;//one day millisecond
		long nh = 1000*60*60;//one hour millisecond
		long nm = 1000*60;//one minutes millisecond
		long ns = 1000;//one seconds millisecond
		long diff;
		int result = 0;
		try {
			Date d1 = startTimeCalendar.getTime();
			Date d2 = endTimeCalendar.getTime();
			diff = sdf.parse(sdf.format(d2)).getTime() - sdf.parse(sdf.format(d1)).getTime();
			long day = diff/nd;//count how many days
			long hour = diff%nd/nh;//count how many seconds
			long min = diff%nd%nh/nm;//count how many minutes
			long sec = diff%nd%nh%nm/ns;//count how many seconds
			result = (int)day;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Date stringToDate(String dateString,String dateFormat){
		Date date = null;
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date stringToDate(String dateString,DateFormat dateFormat){
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}