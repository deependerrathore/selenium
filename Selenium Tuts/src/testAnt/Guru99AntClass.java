package testAnt;

import java.util.Date;

public class Guru99AntClass {
	public static void main(String[] args) {
		System.out.println("HELLO TO ANT PROGRAM");
		System.out.println("Today's Date is->" + currentDate());
		
		System.out.println("Deepender");
	}

	public static String currentDate() {
		return new Date().toString();
	}
}
