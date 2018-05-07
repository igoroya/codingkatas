package com.igoroya.codingkatas.may2018;

import java.util.Arrays;

public class SelectionSort {

  private int[] values;
  
  public SelectionSort(int[] values) {
    this.values = values;
  }
  
  public void print() {
    System.out.println(Arrays.toString(this.values));
  }
  
  private void swap(int i, int j) {
    int tmp = values[i];
    values[i] = values[j];
    values[j] = tmp;
  }
  
  public void sort() {
    int position = 0;
    
    while(position < values.length) {
      for(int i = position + 1; i<values.length; i++) {
        if(values[position] > values[i])
          swap(position, i);
      }
      position++;
    }
    
  }
  
  public static void main(String[] args) {
    int[] values = {5, 6, 1, 4 ,9, 11, 3, 67};
    
    SelectionSort sort = new SelectionSort(values);
    sort.print();
    sort.sort();
    sort.print();

  }

}
