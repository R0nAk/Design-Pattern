package volatilekeyword;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UseOfVolatileKeyWord {

	boolean var = false;

	public static void main(String[] args) throws CloneNotSupportedException {

		final SecondClass object1 = new SecondClass();

		
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
			
			for (int i = 0; i < 19; i++) {
				executor.submit(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						object1.checkVariable();
						
					}
				});
		
			}
		
		
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					object1.toogleValue();
				}
			});
			
			executor.shutdown();
		
		
	

	}


