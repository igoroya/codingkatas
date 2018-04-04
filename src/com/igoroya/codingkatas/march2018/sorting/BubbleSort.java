package com.igoroya.codingkatas.march2018.sorting;

import static com.igoroya.codingkatas.march2018.sorting.Utils.*;

public final class BubbleSort {
	private final int[] values;
	
	public BubbleSort(int[] values) {
		this.values = values;
		
	}
	
	public void sort() {
		int arraySize = values.length;
		boolean allOrdered;
		
		while(true) {
			allOrdered = true;
			for (int p1=0; p1<arraySize-1; p1++) {
				if(values[p1]>values[p1+1]) {
					swap(p1, p1+1, values);
					allOrdered = false;
				}
			}
			if(allOrdered)
				break;
		}
	}
	
	public int[] getValues() {
		return values;
	}
	
}
