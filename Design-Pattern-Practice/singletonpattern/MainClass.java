package singletonpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//There are ways to exploit singlton design pattern
//1.Using Reflection
//2.Using Serialization/Deserialization
//3.Using Multi Threaded model
//4.GC/Multi class loader
public class MainClass {
	public static void main(String[] args) throws FileNotFoundException {

		// get singleton object
		SingletonClass one = SingletonClass.getInstance();
		SingletonClass two = SingletonClass.getInstance();

		print("one", one);
		print("two", two);

		//Uncomment below code to check Using Reflection,Singleton pattern gets violated
		//reflectionUsage();

		// Serialization & Deserialization
		 usingSerialization();

		// MultiThreaded Usage
		//useMultiThreading();
		
		//cloning 
		
		//multiple Calss loaders
		//Using GC
		
	}

	public static void print(String output, SingletonClass object) {
		System.out.println(output + " - hashcode is ::" + object.hashCode());
	}

	public static void reflectionUsage() {
		// Exploit using
		// Reflection
		try {
			Class clazz = Class.forName("singletonpattern.SingletonClass");
			Constructor<SingletonClass> constructor = SingletonClass.class
					.getDeclaredConstructor();
			constructor.setAccessible(true);
			SingletonClass three = constructor.newInstance();
			print("three", three);

		} catch (NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void usingSerialization() {
		try {
			SingletonClass tobeSerialized = SingletonClass.getInstance();
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("/home/ronak/Desktop/abc.ser"));
			oos.writeObject(tobeSerialized);
			print("tobeSerialized", tobeSerialized);

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"/home/ronak/Desktop/abc.ser"));
			SingletonClass serializedObject = (SingletonClass) ois.readObject();

			print("serializedObject", serializedObject);

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void useMultiThreading(){
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				SingletonClass three = SingletonClass.getInstance();
				print("three", three);
			}
		});

		service.submit(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SingletonClass four = SingletonClass.getInstance();
				print("four", four);
			}
		});
		
		service.shutdown();
	}
		
}
