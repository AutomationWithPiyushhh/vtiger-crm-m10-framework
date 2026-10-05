package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static int generateRandomNumber() {
		double r1 = Math.random() * 10000;
		int r2 = (int) r1;
		return r2;
	}
	
	public static String getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hhmmss_ddMMMyyyy");
		String time = now.format(dtf);
		return time;
	}
}
