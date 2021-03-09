package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class Palindrome {

    public static void main(String[] args) {
        String s = "aaabssb";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res  = new ArrayList<>();
        String[] split = s.split("");
        res.add(Arrays.asList(split));
        for (int i = 0; i < split.length; i++) {
            cut(res, split, i, i+1);
            cut(res, split, i-1, i+1);
        }
        return res;
    }


    public static void cut(List<List<String>> res, String[] split, int start, int end){
        if(start < 0 || end >= split.length) {
            return;
        }
        if(!split[start].equals(split[end])){
            return;
        }
        List<String> list = new ArrayList<>();
        String cut = "";
        String rOther = "";
        List<String> lList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(i < start){
                lList.add(split[i]);
                list.add(split[i]);
                continue;
            }
            if(i > end){
                rOther = rOther + split[i];
                list.add(split[i]);
                continue;
            }
            cut = cut + split[i];
            if(i == end){
                list.add(cut);
            }
        }
        if(rOther.length() > 1){
            List<List<String>> rPartition = partition(rOther);
            for (List<String> strings : rPartition) {
                if(strings.size() == rOther.length()){
                    continue;
                }
                List<String> rList = new ArrayList<>();
                rList.addAll(lList);
                rList.add(cut);
                rList.addAll(strings);
                res.add(rList);
            }
        }
        res.add(list);
        cut(res, split, start-1, end+1);
    }

}
