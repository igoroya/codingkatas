package com.igoroya.codingkatas.april2018.steams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestToUppercase {
	MapOperation mapOperation;
	
	@BeforeEach
	void setUp() throws Exception {
		mapOperation = new MapOperation();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToUppercase() {
		List<String> myList = new ArrayList<>();
		String text1 = "hola";
		String text2 = "pepe";
		
		myList.add(text1);
		myList.add(text2);
		List<String> newList = MapOperation.toUpperCase(myList);
			
		assertEquals(text1.toUpperCase(), newList.get(0));
		assertEquals(text2.toUpperCase(), newList.get(1));	
	}
	
	@Test
	void testToUppercaseStream() {
		List<String> myList = new ArrayList<>();
		String text1 = "hola";
		String text2 = "pepe";
		
		myList.add(text1);
		myList.add(text2);
		List<String> newList = MapOperation.toUpperCaseStream(myList);
			
		assertEquals(text1.toUpperCase(), newList.get(0));
		assertEquals(text2.toUpperCase(), newList.get(1));	
	}

}
