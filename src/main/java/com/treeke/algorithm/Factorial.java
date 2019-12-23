package com.treeke.algorithm;

/**
 * 阶乘
 * @author treeke
 *
 */
public class Factorial {
	public static void main(String[] args) {
		int c= factorialTest(10);
		System.out.println(c);
	}
	
	public static int factorialTest(int a) {
		return a == 1 ? 1 : a * factorialTest(a - 1); 
	}

}
