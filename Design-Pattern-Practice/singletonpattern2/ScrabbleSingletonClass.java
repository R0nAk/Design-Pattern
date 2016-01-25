package singletonpattern2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ScrabbleSingletonClass {

	public static ScrabbleSingletonClass singleton = null;

	String[] scrabbleLetters = { "a", "a", "a", "a", "a", "a", "a", "a", "a",
			"b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
			"e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
			"h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
			"l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
			"o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
			"r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
			"u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z", };

	LinkedList<String> scrabbleLettersList = new LinkedList<>(
			Arrays.asList(scrabbleLetters));

	private static boolean myBoolean = true;

	private ScrabbleSingletonClass() {

	}

	public static ScrabbleSingletonClass getInstance() {
		if (singleton == null) {

			if (myBoolean) {

				myBoolean = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			 singleton = new ScrabbleSingletonClass();
			 Collections.shuffle(singleton.scrabbleLettersList);
			
			/*synchronized (ScrabbleSingletonClass.class) {
				if (singleton == null) {
					singleton = new ScrabbleSingletonClass();
					Collections.shuffle(singleton.scrabbleLettersList);
				}

			}*/

		}
		return singleton;
	}

	public LinkedList<String> getScrabblerLettersList() {
		return singleton.scrabbleLettersList;
	}

	public LinkedList<String> getTiles(int numberOfTiles) {
		LinkedList<String> tilesToBeGiven = new LinkedList<String>();
		for (int i = 0; i < numberOfTiles; i++) {
			tilesToBeGiven.add(singleton.getScrabblerLettersList().remove(0));
		}
		return tilesToBeGiven;

	}
}
