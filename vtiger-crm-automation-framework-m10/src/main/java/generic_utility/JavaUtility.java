package generic_utility;

public class JavaUtility {
	public static int generateRandomNumber() {
		double r1 = Math.random() * 10000;
		int r2 = (int) r1;
		return r2;
	}
}
