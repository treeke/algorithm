package com.treeke.algorithm;

import java.util.List;

public class Factorization {
	public static void main(String[] args) {
		factorizationTest(90);
	}
	
	public static void factorizationTest(int a){
		for (int i = 2; i < a; i++) {
            while (a % i == 0) {
                System.out.println(i);
                a = a / i;
            }
        }
        if (a > 1) {
            System.out.println(a);
        }
	}

}
