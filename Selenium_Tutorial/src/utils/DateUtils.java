package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *DateUtils - Date and Time related utility functions
 */
public class DateUtils {
	
	
	public static String getCurrentDate(String desiredDateFormat){
		String dateString = null;
		try {
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormat.forPattern(desiredDateFormat);
			  dateString = format.print(date);
			System.out.println("Current Timestamp = "+ dateString);
			
 		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		return dateString;


	}
	
	/**
	 * @param desiredDateTimeFormat - Returns current timestamp
	 * @return
	 */
	public static String getCurrentTimestamp(String desiredDateTimeFormat){
		String timeStamp = null;
		try {
 			  timeStamp = new SimpleDateFormat(desiredDateTimeFormat,Locale.US).format(new Date());
 		//	System.out.println("Current Timestamp = "+ timeStamp);
			
 		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		return timeStamp;


	}
	
	/**
	 * @param getDateTimeDifference - Takes 3 arguments (StartTime, EndTime, DateTimeFormat) Returns the difference between two timestamps in format: 8 Min. 15 Sec.
	 * @return
	 * @throws ParseException 
	 */
	public static String getDateTimeDifference(String startDateTime, String endDateTime, String format_DateTime) throws ParseException{
 
	SimpleDateFormat format = new SimpleDateFormat(format_DateTime);
	
	Date d1 = null;
	Date d2 = null;
	
	int min = 0;
	int sec = 0;
	
	
	d1 =format.parse(startDateTime);
	d2 =format.parse(endDateTime);
	
	
	DateTime  dt1 = new DateTime(d1);
	DateTime  dt2 = new DateTime(d2);

	min= Minutes.minutesBetween(dt1, dt2).getMinutes()%60;
	sec =Seconds.secondsBetween(dt1, dt2).getSeconds()%60;
//	int hours = Hours.hoursBetween(dt1, dt2).getHours()%24;
	System.out.println("~ The difference between "+startDateTime +" & "+ endDateTime +" = "+ min+" Min."+" "+sec+ "Sec." );
	return min+" Min."+" "+sec+ "Sec.";
	
	}	
		
}
