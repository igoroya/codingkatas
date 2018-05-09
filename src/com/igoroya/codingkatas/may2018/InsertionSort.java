package com.igoroya.codingkatas.may2018;

import java.util.Arrays;

public class InsertionSort {
  private int[] values;
  
  public InsertionSort(int[] values) {
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
    int position = 1;
    
    while(position < this.values.length) {
      for (int i = position - 1   ; i >= 0; i--) {
        if(values[i + 1] < values[i]) {
          swap(i + 1, i);
        }
        else {
          break;
        }
      }
      position++;
    }
  } 
  
  
  
  public static void main(String[] args) {
    int[] values = {5, 6, 1, 4 ,9, 11, 3, 67};
    
    InsertionSort sort = new InsertionSort(values);
    sort.print();
    sort.sort();
    sort.print();

  }
}
