package phipgn.sloppy_test.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
	
	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");  
	    Date date = new Date();
	    return formatter.format(date);
	}
}
