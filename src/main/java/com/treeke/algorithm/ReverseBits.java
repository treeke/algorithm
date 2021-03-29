package com.treeke.algorithm;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
