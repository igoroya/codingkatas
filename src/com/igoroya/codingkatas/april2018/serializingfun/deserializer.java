package com.igoroya.codingkatas.april2018.serializingfun;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class deserializer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p2 = null;
		
		try {
			FileInputStream fileInputStream
		      = new FileInputStream("person.ser");
		    ObjectInputStream objectInputStream
		      = new ObjectInputStream(fileInputStream);
		    p2 = (Person) objectInputStream.readObject();
		    objectInputStream.close();
		}
	    catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(p2);
		
		
	}

}
