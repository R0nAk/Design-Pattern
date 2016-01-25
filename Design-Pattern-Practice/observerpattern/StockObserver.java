package observerpattern;

public class StockObserver implements Observer {

	private int stockPrice;
	private Subject stockGrabber;
	
	
	public StockObserver(Subject grabber){
		this.stockGrabber = grabber;
		stockGrabber.registerObserver(this);
	}
	@Override
	public void updateData(int price) {
		// TODO Auto-generated method stub
		this.stockPrice = price;
		printPrice();
	}
	
	public void printPrice(){
		System.out.println("Updated price is  :" + stockPrice);
	}

}
