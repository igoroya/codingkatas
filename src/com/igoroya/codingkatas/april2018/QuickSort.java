package com.igoroya.codingkatas.april2018;

import java.util.Arrays;

public class QuickSort {

  private int[] values;
  
  public QuickSort(int[] values) {
    this.values = values;
  
  }
  
  public static void main(String[] args) {
    
    int[] original = {3, 1, 2, 7};
    System.out.println(Arrays.toString(original));
    QuickSort sort = new QuickSort(original);
    sort.sort();
    System.out.println("------");
    int[] original2 = {1, 5, 3, 45, 3};
    System.out.println(Arrays.toString(original2));
    sort = new QuickSort(original2);
    sort.sort();
  }

  public void sort() {
    recSort(0, values.length - 1);
    System.out.println(Arrays.toString(values));
  }
  
  
  private void recSort(int first, int last) {
      if (last-first < 1) {
        return;
      }
      
      int pivot = partitionAroundLast(first, last);
   
      recSort(first, pivot - 1);
      recSort(pivot + 1, last);
      
  }
  
  private int partitionAroundLast(int first, int last) {
    
    int ptrLeft = first;
    int prtRight = last - 1 ;
    int pivotPosition = last;
    int pivotValue = values[pivotPosition];
       
    while (true) {
      
      while (values[ptrLeft] < pivotValue && ptrLeft < last) {
        ptrLeft++;
      }
      
      while (values[prtRight] > pivotValue && prtRight > 0 ) {
        prtRight--;
      }
      if (ptrLeft >= prtRight)
        break;
      else
        swap(ptrLeft, prtRight);
      
    }
    
    swap(ptrLeft, last); //Move the pivot value to its position  
    
    return ptrLeft;
    
  }
  
  private void swap(int a, int b) {
    int tmp = values[a];
    values[a] = values[b];
    values[b] = tmp;
  }
  
}
