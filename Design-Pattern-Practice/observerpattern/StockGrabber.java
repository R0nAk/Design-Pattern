package observerpattern;

import java.util.ArrayList;
import java.util.Iterator;

public class StockGrabber implements Subject {

	private ArrayList<Observer> observers;
	private int price;
	
	public StockGrabber() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer newObserver) {
		// TODO Auto-generated method stub
		observers.add(newObserver);
	}

	@Override
	public void unregisterObserver(Observer removeObserver) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(removeObserver);
		System.out.println("Removing Observer @ indedx :" + (index+1));
		observers.remove(index);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer observer : observers){
			observer.updateData(price);
		}
	}
	
	public void setNewPrice(int newPrice){
		this.price = newPrice;
		notifyObserver();
	}

}
