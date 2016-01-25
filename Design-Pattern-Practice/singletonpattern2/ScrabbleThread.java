package singletonpattern2;

public class ScrabbleThread {

	public static void main(String[] args){
		
		Runnable one = new ScrabbleRunnable();
		Runnable two = new ScrabbleRunnable();
		
		
		new Thread(one).start();
		new Thread(two).start();
		
	}
}
