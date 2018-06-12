package com.igoroya.codingkatas.april2018;

import java.util.Arrays;

public class MergeSort {

  private int[] values;
  /**
   * Mergesort impl.
   * @param values array to order
   */
  public MergeSort(int[] values) {
    this.values = values;

    int[] aux = new int[values.length];
    
    recMergeSort(aux, 0, values.length - 1);
    System.out.println(Arrays.toString(this.values));
  }
  
  private void recMergeSort(int[] aux, int low, int high) {
    if (low == high) {
      return;
    }
    
    int mid = low + (high - low) / 2;
    
    recMergeSort(aux, low, mid);
    recMergeSort(aux, mid + 1, high);
    
    mergeOrdered(aux, low, mid, high);
    
    return;
  }
  
  /**
   * Merges two parts of the original.
   * @param aux temporal array, reused for efficiency
   * @param low
   * @param medium
   * @param high
   */
  private void mergeOrdered(int[] aux, int low, int medium, int high) {
    
    int lowPrr = low;
    int highPtr = medium + 1;
    int upperBound = high;
    int auxIndex = 0;
    
    while (lowPrr <= medium && highPtr <= upperBound) {
      if (this.values[lowPrr] < this.values[highPtr]) {
        aux[auxIndex] = this.values[lowPrr];
        auxIndex++;
        lowPrr++;
      } else {
        aux[auxIndex] = this.values[highPtr];
        auxIndex++;
        highPtr++;
      }
    }

    while (lowPrr <= medium) {
      aux[auxIndex] = this.values[lowPrr];
      auxIndex++;
      lowPrr++;
    }
      
    while (highPtr <= upperBound) {
      aux[auxIndex] = this.values[highPtr];
      auxIndex++;
      highPtr++;
    }
  
    int totalSize = high - low + 1;
    
    for (int i = 0; i < totalSize; i++) {
      this.values[low + i] = aux[i];
    }
   
  
  }

  public static void main(String[] args) {
    int[] orig =  {34, 12, 1, 2, 56, 1, 56, 34, 68, 2, -4};
    System.out.println(Arrays.toString(orig));
    MergeSort sort = new MergeSort(orig);
  }

}
