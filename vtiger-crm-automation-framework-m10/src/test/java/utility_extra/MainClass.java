package utility_extra;

class One {
	public static void checkEven() {
		int i = 1;
		if (i % 2 == 0) {
			System.out.println(i +" is  even");
		}else {
			System.out.println(i +" is odd");
		}
	}
}

class Two {
	public static void checkEven() {
		int i = 2;
		if (i % 2 == 0) {
			System.out.println("even");
		}
	}
}

class Three {
	public static void checkEven() {
		int i = 3;
		if (i % 2 == 0) {
			System.out.println("even");
		}
	}
}

public class MainClass {
	public static void main(String[] args) {
		One.checkEven();
		Two.checkEven();
		Three.checkEven();
	}
}
