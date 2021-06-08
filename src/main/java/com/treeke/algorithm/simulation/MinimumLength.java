package com.treeke.algorithm.simulation;

public class MinimumLength {
    public static void main(String[] args) {
        MinimumLength minimumLength = new MinimumLength();
        int i = minimumLength.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb");
        System.out.println(i);
    }

    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        return subChars(chars, 0, chars.length-1);
    }

    public int subChars(char[] chars, int start, int end){
        if(chars[start] != chars[end] || start == end){
            return end - start + 1;
        }
        while (chars[start] == chars[start+1] && start+1 < end){
            start++;
        }
        while (chars[end] == chars[end-1] && end-1 > start){
            end--;
        }
        if(start + 1 == end){
            return 0;
        }
        return subChars(chars, start+1, end-1);
    }
}
