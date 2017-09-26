package com.logan.project1;

import java.util.Random;

public class Sorts {

    public static void main(String[] args) {
        int[] mergeWins = new int[7], quickWins = new int[7];
        long[] mergeMean = new long[7], quickMean = new long[7];
        
        for(int trials = 0; trials < 20; ++trials) {
            System.out.println("Trial " + trials);
            int[][] mergeArrays = new int[7][];
            mergeArrays[0] = new int[10];
            mergeArrays[1] = new int[100];
            mergeArrays[2] = new int[1000];
            mergeArrays[3] = new int[10000];
            mergeArrays[4] = new int[100000];
            mergeArrays[5] = new int[1000000];
            mergeArrays[6] = new int[2000000];
            Random rand = new Random();
            for(int i = 0; i < mergeArrays.length; ++i) {
                for(int j = 0; j < mergeArrays[i].length; ++j) {
                    mergeArrays[i][j] = Math.abs(rand.nextInt(999999)) + 1 ;
                }
            }
            
            int[][] quickArrays = new int[7][];
            quickArrays[0] = new int[10];
            quickArrays[1] = new int[100];
            quickArrays[2] = new int[1000];
            quickArrays[3] = new int[10000];
            quickArrays[4] = new int[100000];
            quickArrays[5] = new int[1000000];
            quickArrays[6] = new int[2000000];
            for(int i = 0; i < quickArrays.length; ++i) {
                System.arraycopy(mergeArrays[i], 0, quickArrays[i], 0, mergeArrays[i].length);
            }
    
            long[] mergeTimes = new long[7], quickTimes = new long[7];
            long currentTime;
            for(int i = 0; i < mergeArrays.length; ++i) {
                currentTime = System.nanoTime();
                mergeSort(mergeArrays[i]);
                mergeTimes[i] = System.nanoTime() - currentTime;
                mergeMean[i] += mergeTimes[i];
            }
            for(int i = 0; i < quickArrays.length; ++i) {
                currentTime = System.nanoTime();
                quicksort(quickArrays[i]);
                quickTimes[i] = System.nanoTime() - currentTime;
                quickMean[i] += quickTimes[i];
            }
            
            for(int i = 0; i < mergeTimes.length; ++i) {
                if(mergeTimes[i] < quickTimes[i]) {
                    ++(mergeWins[i]);
                }
                else if(quickTimes[i] < mergeTimes[i]) {
                    ++(quickWins[i]);
                }
            }
            
            for(int i = 0; i < mergeMean.length; ++i) {
                mergeMean[i] /= 20;
                quickMean[i] /= 20;
            }
            
            long[] nlog2n = {
                    10l * (long)(Math.log(10)/Math.log(2)),
                    100l * (long)(Math.log(100)/Math.log(2)),
                    1000l * (long)(Math.log(1000)/Math.log(2)),
                    10000l * (long)(Math.log(10000)/Math.log(2)),
                    100000l * (long)(Math.log(100000)/Math.log(2)),
                    1000000l * (long)(Math.log(1000000)/Math.log(2)),
                    2000000l * (long)(Math.log(2000000)/Math.log(2))
            };
            System.out.println("10 : mergesort mean runtime=" + mergeMean[0] + ", div=" + mergeMean[0]/nlog2n[0] + ", quicksort mean runtime=" + quickMean[0] + ", div=" + quickMean[0]/nlog2n[0]);
            System.out.println("100 : mergesort mean runtime=" + mergeMean[1] + ", div=" + mergeMean[1]/nlog2n[1] + ", quicksort mean runtime=" + quickMean[1] + ", div=" + quickMean[1]/nlog2n[1]);
            System.out.println("1000 : mergesort mean runtime=" + mergeMean[2] + ", div=" + mergeMean[2]/nlog2n[2] + ", quicksort mean runtime=" + quickMean[2] + ", div=" + quickMean[2]/nlog2n[2]);
            System.out.println("10000 : mergesort mean runtime=" + mergeMean[3] + ", div=" + mergeMean[3]/nlog2n[3] + ", quicksort mean runtime=" + quickMean[3] + ", div=" + quickMean[3]/nlog2n[3]);
            System.out.println("100000 : mergesort mean runtime=" + mergeMean[4] + ", div=" + mergeMean[4]/nlog2n[4] + ", quicksort mean runtime=" + quickMean[4] + ", div=" + quickMean[4]/nlog2n[4]);
            System.out.println("1000000 : mergesort mean runtime=" + mergeMean[5] + ", div=" + mergeMean[5]/nlog2n[5] + ", quicksort mean runtime=" + quickMean[5] + ", div=" + quickMean[5]/nlog2n[5]);
            System.out.println("2000000 : mergesort mean runtime=" + mergeMean[6] + ", div=" + mergeMean[6]/nlog2n[6] + ", quicksort mean runtime=" + quickMean[6] + ", div=" + quickMean[6]/nlog2n[6]);
            
        }
        
        for(int i = 0; i < mergeWins.length; ++i) {
            System.out.println("" + i + " : mergewins=" + mergeWins[i] + ", quickwins=" + quickWins[i] );
        }
        
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
	    int temp[] = new int[a.length];
	    int current = 0;
	    int leftIndex = i;
	    int rightIndex = j+1;
	    
	    while(leftIndex < j+1 && rightIndex < k+1) {
	        if(a[leftIndex] < a[rightIndex]) {
	            temp[current++] = a[leftIndex++];
	        }
	        else {
	            temp[current++] = a[rightIndex++];
	        }
	    }
	    
	    while(leftIndex < j+1) {
	        temp[current++] = a[leftIndex++];
	    }
	    
	    while(rightIndex < k+1) {
	        temp[current++] = a[rightIndex++];
	    }

	    current = 0;
	    for(int x = i; x < k+1; ++x, ++current) {
	        a[x] = temp[current];
	    }
	}
	
	// sorts a[i..k] for 0 <= i <= k < a.length
	public static void mergeSort(int[] a, int i, int k) {
        if(i >= k) {
            return;
        }
        mergeSort(a, i, ((k-i)/2) + i);
        mergeSort(a, ((k-i)/2) + i + 1, k);
        merge(a, i, ((k-i)/2) + i, k);
	}
	// Sorts the array using mergesort
	public static void mergeSort(int[] a) {
	    mergeSort(a, 0, (a.length-1)/2);
	    mergeSort(a, (a.length-1)/2 + 1, a.length - 1);
	    merge(a, 0, (a.length-1)/2, a.length-1);
	}
	
	//Implements in-place partition from text. Partitions subarrays
	//s[a..b] into s[a..l-1] and [l+1..b] so that all elements of
	//s[a..l-1] are less than each element in s[l+1..b]
	public static int partition(int[] s, int a, int b) {
	    int pivot = s[b];
	    int lscan = a;
	    int rscan = b-1;
	    
	    while(lscan <= rscan) {
	        while(lscan <= rscan && s[lscan] <= pivot) {
	            ++lscan;
	        }
	        while(rscan >= lscan && s[rscan] >= pivot) {
	            --rscan;
	        }
	        if(lscan < rscan) {
	            int temp = s[lscan];
	            s[lscan] = s[rscan];
	            s[rscan] = temp;
	        }
	    }
	    
	    int temp = s[lscan];
	    s[lscan] = pivot;
	    s[b] = temp;
	    
        return lscan;
	}
	//quick sorts subarray a[i..j]
	public static void quickSort(int[] a, int i, int j) {
		if(i >= j) {
		    return;
		}
		int partIndex = partition(a, i, j);
		quickSort(a, i, partIndex-1);
		quickSort(a, partIndex+1, j);
	}
	//quick sorts array a
	public static void quicksort(int[] a) {
		int partIndex = partition(a, 0, a.length-1);
		quickSort(a, 0, partIndex-1);
		quickSort(a, partIndex+1, a.length-1);
	}
	
}
