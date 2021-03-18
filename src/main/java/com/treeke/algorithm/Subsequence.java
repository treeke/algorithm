package com.treeke.algorithm;

import java.util.Arrays;


/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class Subsequence {

    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        int i = subsequence.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc","bcddceeeebecbc");
        //int i = subsequence.numDistinct("aabb", "ab");
        //int i = subsequence.numDistinct("babgbag", "bag");
        //int i = subsequence.numDistinct("rabbbit", "rabbit");
        System.out.println(i);
    }

    int n;
    int m;
    int[][] flag;

    public int numDistinct(String s, String t) {
        if(s.isEmpty() || t.isEmpty()){
            return 0;
        }
        n = t.length();
        m = s.length();
        flag = new int[m][n];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], -1);
        }
        return sub(s, t, 0, 0);
    }

    public int sub(String s, String t, int sIndex, int tIndex){
        if(tIndex == n) {
            return 1;
        }
        if(sIndex == m){
            return 0;
        }
        int count = 0;
        if(flag[sIndex][tIndex] != -1){
            return flag[sIndex][tIndex];
        }
        if(s.charAt(sIndex) == t.charAt(tIndex)){
            flag[sIndex][tIndex] = sub(s, t, sIndex + 1, tIndex + 1) + sub(s, t, sIndex + 1, tIndex);
            count = flag[sIndex][tIndex];
        }else {
            flag[sIndex][tIndex] = sub(s, t, sIndex + 1, tIndex);
            count = flag[sIndex][tIndex];
        }
        return count;
    }
}
/*
    public int numDistinct(String s, String t) {
        return s.isEmpty() || t.isEmpty() ? 0 : sub(s, t, 0, 0);
    }

    public int sub(String s, String t, int sIndex, int tIndex){
        if(tIndex == t.length()) return 1;
        for (int i = tIndex; i < t.length(); i++) {
            if(s.indexOf(Character.toString(t.charAt(i)), sIndex) == -1){
                return 0;
            }
        }
        int count = 0;
        for (int i = sIndex; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(tIndex)){
                count = count + sub(s, t, i + 1, tIndex + 1);
            }
        }
        return count;
    }*/
