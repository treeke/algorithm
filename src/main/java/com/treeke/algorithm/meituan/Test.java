package com.treeke.algorithm.meituan;

public class Test {

    public static void main(String[] args) {
        nums(6);
    }

    public static void nums(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i != 0 && i != num-1){
                    if(j != 0 && j != num-1){
                        System.out.print(" ");
                        continue;
                    }
                }
                if (j == num - 1) {
                    System.out.print("+\n");
                    continue;
                }
                System.out.print("+");
            }
        }
    }
}
