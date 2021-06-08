package com.treeke.algorithm.simulation;

public class ABCalc {


    public int calculate(String s) {
        int x = 1, y = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'A'){
                x = 2 * x + y;
            }else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}
