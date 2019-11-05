package com.org.soda.foodtruck;

import java.text.SimpleDateFormat;
import java.util.Date;

class TimeStampValidator {
	
	public static SimpleDateFormat formatter;
	static Date now = new Date();
	
	
	//This method checks if the current time is in between the start time and end time
	public static boolean isTimeValid(String currentTime, String startTime, String endTime) {
        return ((currentTime.compareTo(startTime) >= 0) && (currentTime.compareTo(endTime) <= 0));
    }
	
	
	//This method converts the current time to HH:mm format
	public static String getCurrentTime() {	
		formatter = new SimpleDateFormat("HH:mm");
		return (String)formatter.format(now);
	}
	
	
	//This method returns the current day
	public static String getCurrentDay() {
		formatter = new SimpleDateFormat("EEEE");
		return (String)formatter.format(now);		
	}	
}
