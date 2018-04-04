package com.igoroya.codingkatas.march2018.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Sorter {

	public static void main(String[] args) {

		int[] randomized = generateArray(5);		
		System.out.println("Random order: "+ Arrays.toString(randomized));
	
//		BubbleSort bubble = new BubbleSort(randomized);
//		bubble.sort();
//		System.out.println(Arrays.toString(bubble.getValues()));
		
		
		QuickSort quick = new QuickSort(randomized);
		quick.sort();
		System.out.println(Arrays.toString(quick.getValues()));
		
	}

	private static int[] generateArray(int numEntries) {
		
		int numbers[] = new int[numEntries];
		
		ThreadLocalRandom random =  ThreadLocalRandom.current();
		
		for (int i = 0; i < numEntries; i++) {
			numbers[i] = random.nextInt(numEntries*5);
		}
		
		return numbers;
		
	}
	
}
