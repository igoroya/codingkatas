package com.igoroya.codingkatas.may2018;

import java.util.Arrays;

public class BubbleSort {

  private int[] values;
  
  public BubbleSort(int[] values) {
      this.values = values;
  }
  
  public void displayValues() {
    System.out.println(Arrays.toString(this.values));
  }
  
  public void sort() {
    int length = this.values.length;
    int upLimit = length - 1 ;
    while( upLimit > 0) {
      for (int i = 0; i < upLimit; i++) {
        if(this.values[i] >  this.values[i + 1])
          swap(i, i+1);
      }
      upLimit--;
    }

  }
  
  private void swap(int i, int j) {
    int temp = this.values[i];
    this.values[i] = this.values[j];
    this.values[j] = temp;
  }

  public static void main(String[] args) {
    int[] values = {5, 6, 1, 4 ,9, 11, 3};
    
    BubbleSort sort = new BubbleSort(values);
    sort.displayValues();
    sort.sort();
    sort.displayValues();
    
    
  }

}
