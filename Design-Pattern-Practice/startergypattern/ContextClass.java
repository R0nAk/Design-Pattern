package startergypattern;

import java.util.Random;
import java.util.Scanner;

public class ContextClass {
	
	public ContextClass(){
		
	}
	
	public int checkWeatherCondition() {
		System.out.println("Select below input for weather condition");
		System.out.println("1.Sunny  2.Windy  3.Stormy");
		Scanner sc = new Scanner(System.in);
		int condition = sc.nextInt();
		return condition;
	}

	public TransportInterface selectModeOfTransport() {
		switch (checkWeatherCondition()) {
		case 1:
			return new CycleTravel();  //Bike
		case 2:   
			return new BikeTravel(); //Bus
		case 3:
			return new TaxiTravel(); //Oye Taxi
		default:
			System.out.println("Bad Weather....Stay here only (Point A)");
			break;
		}

	 return null;
	}

}
