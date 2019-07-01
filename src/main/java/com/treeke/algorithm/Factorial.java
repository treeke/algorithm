package com.treeke.algorithm;

public class Factorial {
	public static void main(String[] args) {
		int c= factorialTest(4);
		System.out.println(c);
	}
	
	public static int factorialTest(int a) {
		return a == 0 ? 1 : a * factorialTest(a - 1); 
	}

}
