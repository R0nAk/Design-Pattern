package observerpattern;

public class GrabberThread implements Runnable{

	private int startTime;
	private int price;
	private Subject stockGrabber;
	public GrabberThread(Subject grabber,int time,int price) {
		// TODO Auto-generated constructor stub
		this.stockGrabber = grabber;
		this.startTime = time;
		this.price = price;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(3000);
					
					price = (int)(Math.random()*100);
					((StockGrabber)stockGrabber).setNewPrice(price);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

}
