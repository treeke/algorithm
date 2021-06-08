package com.treeke.algorithm.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumsTarget {

    public static void main(String[] args) {
        NumsTarget numsTarget = new NumsTarget();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        List<List<Integer>> list1 = numsTarget.numsTarget1(nums, 10);
        List<List<Integer>> list2 = numsTarget.numsTarget2(nums, 10);
    }


    //方法二 利用HashSet的查找当前数字所匹配的数字
    //时间复杂度O(n)
    public List<List<Integer>> numsTarget2(int[] nums, int target){
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            //判断set中是否包含当前需要的数字
            if(set.contains(j)){
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[i]);
                arr.add(j);
                res.add(arr);
            }else {
                //将未匹配到的数字放入hashset
                set.add(nums[i]);
            }
        }
        return res;
    }

    //方法一 循环两遍数组
    public List<List<Integer>> numsTarget1(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[i] + nums[j] == target && nums[i] != nums[j]){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    res.add(arr);
                }
            }
        }
        return res;
    }
}
