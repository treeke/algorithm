package com.treeke.algorithm.math;

/**
 *给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        boolean b = judgeSquareSum.judgeSquareSum(0);
        System.out.println(b);
    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - (a * a));
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }
}
