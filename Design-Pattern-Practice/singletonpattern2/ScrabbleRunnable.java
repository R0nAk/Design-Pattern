package singletonpattern2;

import java.util.LinkedList;

public class ScrabbleRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ScrabbleSingletonClass  singletonClass = ScrabbleSingletonClass.getInstance();
		System.out.println(singletonClass.getScrabblerLettersList());
		LinkedList<String> playerOneTiles = singletonClass.getTiles(8);
		System.out.println("Hashcode :" + singletonClass.hashCode());
		System.out.println("List \n" + playerOneTiles);
		

/*		ScrabbleSingletonClass  singletonClass2 = ScrabbleSingletonClass.getInstance();
		System.out.println(singletonClass2.getScrabblerLettersList());
		LinkedList<String> playerTwoTiles = singletonClass2.getTiles(8);
		System.out.println("Hashcode :" + singletonClass2.hashCode());
		System.out.println("List \n" + playerOneTiles);
		*/
	}


}
