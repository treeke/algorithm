package com.treeke.algorithm;

/**
 * 冒泡排序
 * @author treeke
 *
 */
public class BubbleSort {

	public static void main(String[] args) {        
	    int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,5,6,4656,7,8,9,343,57765,23,12321};        
	    int len = arr.length-1;      
	    long start = System.currentTimeMillis();  
	    arr = sort(arr);
	    System.out.println(System.currentTimeMillis() - start);
	    for (int i:arr) {            
	        System.out.print(i + " ");        
	    }    
	}
	
	public static int[] sort(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				} 
			}
		}
		return arr;
	}
}
