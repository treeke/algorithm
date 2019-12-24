package com.treeke.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 快速排序
 * @author treeke
 *
 */
public class QuickSort {
	public static AtomicInteger q = new AtomicInteger();
	
	public static int[] qsort(int arr[],int start,int end) { 
		System.out.println(q.incrementAndGet() + "-" + start + "-" + end);
	    int pivot = arr[start];        
	    int i = start;        
	    int j = end;        
	    while (i<j) {            
	        while ((i<j)&&(arr[j]>pivot)) {                
	            j--;            
	        }            
	        while ((i<j)&&(arr[i]<pivot)) {                
	            i++;            
	        }            
	        if ((arr[i]==arr[j])&&(i<j)) {                
	            i++;            
	        } else {                
	            int temp = arr[i];                
	            arr[i] = arr[j];                
	            arr[j] = temp;            
	        }        
	    }        
	    if (i-1>start) arr=qsort(arr,start,i-1);        
	    if (j+1<end) arr=qsort(arr,j+1,end);        
	    return arr;    
	}    
	 
	public static void main(String[] args) {        
	    int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,5,6,4656,7,8,9,343,57765,23,12321};        
	    int len = arr.length-1;      
	    long start = System.currentTimeMillis();
	    arr=qsort(arr,0,len);    
	    System.out.println(System.currentTimeMillis() - start);
	    for (int i:arr) {            
	        System.out.print(i + " ");        
	    }    
	}
	

}
