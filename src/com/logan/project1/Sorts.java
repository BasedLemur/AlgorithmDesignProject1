package com.logan.project1;

public class Sorts {

    public static void main(String[] args) {
        
    }
    
    // returns true only if a is sorted from smallest to largest values
    public static boolean isSorted(int[] a) {
        for(int i = 0; i < a.length - 1; ++i) {
            if(a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }
    // merges sorted slices a[i..j] and a[j+1..k] for 0 <= i <= j < k < a.length
	public static void merge(int[] a, int i, int j, int k) {
	    int temp[] = new int[k - i + 1];
	    int current = 0;
	    int leftIndex = i;
	    int rightIndex = j+1;
	    boolean leftDone = false;
	    boolean rightDone = false;
	    
	    while(!(leftDone || rightDone)) {
	        if(a[leftIndex] < a[rightIndex]) {
	            temp[current++] = a[leftIndex++];
	        }
	    }
	}
	// sorts a[i..k] for 0 <= i <= j < a.length
	public static void mergeSort(int[] a, int i, int j) {
        
	}
	// Sorts the array using mergesort
	public static void mergeSort(int[] a) {

	}
	
	//Implements in-place partition from text. Partitions subarrays
	//s[a..b] into s[a..l-1] and [l+1..b] so that all elements of
	//s[a..l-1] are less than each element in s[l+1..b]
	public static int partition(int[] a, int i, int j) {
	    
        return 0;
	}
	//quick sorts subarray a[i..j]
	public static void quickSort(int[] a, int i, int j) {
		
	}
	//quick sorts array a
	public static void quicksort(int[] a) {
		
	}
	
}
