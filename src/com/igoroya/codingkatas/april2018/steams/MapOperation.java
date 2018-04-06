package com.igoroya.codingkatas.april2018.steams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class that converts elements from a collection to uppercase
 * @author igoroya
 *
 */
public class MapOperation {

	public static List<String> toUpperCase(List<String> list) {
		
		List<String> newList = new ArrayList<>();	
		for (String s: list) {
			newList.add(s.toUpperCase());
		}
		return newList;
	}
	
	public static List<String> toUpperCaseStream(List<String> list) {
		
		List<String> newList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		return newList;
	}
	
	
}	

