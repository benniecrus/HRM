package com.iist.hrm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatUtils {
	public static Date convertStringToDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_DD_MM_YYYY);
		sdf.setTimeZone(TimeZone.getTimeZone(Constants.TIMEZONE_VIETNAM));
		Date date = sdf.parse(dateString);
		return date;
	}
}
