package com.igoroya.codingkatas.april2018.serializingfun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

	public static void main(String[] args) {

		Person bob = new Person("bob", 47);
		System.out.println(bob);
	
		 
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("person.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(bob);
			objectOutputStream.flush();
			objectOutputStream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
