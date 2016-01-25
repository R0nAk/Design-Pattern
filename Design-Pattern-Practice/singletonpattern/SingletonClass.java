package singletonpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonClass implements Serializable {

	private static SingletonClass singletonInstance;
	
	//Below declaration can be used....As per JAVA Memory model class loader loads one class defination at time
	//below impl makes single instance
	//private static final SingletonClass singletonInstance1 = new SingletonClass();

	private SingletonClass() {

		System.out.println("Creating object....");
	}

	// This method returns single object across app enviorment.
	public static SingletonClass getInstance() {
		if (singletonInstance == null) {
			synchronized (SingletonClass.class) {
				if (singletonInstance == null) {
					singletonInstance = new SingletonClass();
				}
			}
		}
		return singletonInstance;
	}
	
	
	public static SingletonClass getInstanceUsingHolder() {
		return Holder.INSTANCE;
	}
	

	
	//or Using Holder class
	//As 
	
	static class Holder{
	   static final SingletonClass INSTANCE = new SingletonClass();
	}
	
	

	// ////////////////////This method used to provide consitent behavior for
	// serialization ///////////////////////
	private Object readResolve() throws ObjectStreamException {
		return singletonInstance;
	}

}
