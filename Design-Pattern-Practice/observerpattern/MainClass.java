package observerpattern;

public class MainClass {
	public static void main(String[] args) {
		StockGrabber stockGrabber = new StockGrabber();	
		
		StockObserver observer1 = new StockObserver(stockGrabber);
		stockGrabber.setNewPrice(30);
		
		
		StockObserver observer2 = new StockObserver(stockGrabber);
		stockGrabber.setNewPrice(40);
		
		try {
			Thread.sleep(3000);
			stockGrabber.unregisterObserver(observer2);
			stockGrabber.setNewPrice(30);
			
			new Thread(new GrabberThread(stockGrabber, 300, 400)).start();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
}
