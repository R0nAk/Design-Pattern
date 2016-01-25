package startergypattern;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "";

		System.out.println("Please Enter your Good name :");
		name = sc.nextLine();
		System.out.println("Hello :: " + name);
		System.out.println("I will suggest you for using mode of transport");
		System.out.println("Provide Cureent weather information");

		ContextClass contextClazz = new ContextClass();
		
		TransportInterface modeOfTransport = contextClazz
				.selectModeOfTransport();

		if (modeOfTransport != null) {
			modeOfTransport.transit();
		}

	}

}
