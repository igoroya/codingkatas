package com.igoroya.codingkatas.march2018.sorting;

import java.util.Arrays;

public final class Utils {

	public static void swap(int a, int b, int[] values) {
		//System.out.println("swapping: "+a +" ,"+b);
		int tmp = values[a];
		values[a] = values[b];
		values[b] = tmp;
		//System.out.println(Arrays.toString(values));
	}
	
	public static void sortTwo(int a, int b, int[] values) {
		if (values[a] > values[b])
			swap(a, b, values);
	}
}
