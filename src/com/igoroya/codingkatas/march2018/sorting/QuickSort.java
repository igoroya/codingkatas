package com.igoroya.codingkatas.march2018.sorting;

import static com.igoroya.codingkatas.march2018.sorting.Utils.*;



public class QuickSort {
	private final int[] values;
	
	public QuickSort(int[] values) {
		this.values = values;
	}
	
	public void sort() {
		sortReq(0, values.length -1);
	}
	
	
	private void sortReq(int first, int last) {
		
		if (last - first <= 0) 
			return;//nothing to sort, done
		if (last - first == 1) {
			sortTwo(first, last, values);
			return;//nothing to sort, done
		}
		
		int pivot = last; // we take as the pivot for the partition the element in the right
		
		int partition = partitionIt(first, last-1, pivot);
		sortReq(0, partition - 1);
		sortReq(partition + 1, pivot);
		
	}

	private int partitionIt(int first, int last, int pivot) {
		System.out.println("Start partition: "+first+" "+last+" "+pivot) ;
		
		
		int ptrStart = first - 1 ;//will be first in the while (++pstStart)
		int ptrEnd = last + 1;//will be last in the while (--pstStart)
		int pivotValue = values[pivot];
		
		while(true) {
			
			System.out.println(ptrStart + " " + ptrEnd);
			
			while(values[++ptrStart] < pivotValue)
				;//nop
			while(ptrEnd > 0 && values[--ptrEnd] > pivotValue)
				;//nop
			
			if(ptrStart >= ptrEnd)
				break; //pointers crossed;
			else
				swap(ptrStart, ptrEnd, values);
			
		}
		
		swap(ptrStart, pivot, values);
	
		return ptrStart;
	}
	
	public int[] getValues() {
		return values;
	}
	

}
