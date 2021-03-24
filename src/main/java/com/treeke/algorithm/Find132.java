package com.treeke.algorithm;

import java.util.*;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 */
public class Find132 {

    public static void main(String[] args) {
        Find132 find132 = new Find132();
        //boolean pattern = find132.find132pattern(new int[]{-1, 3, 2, 0});
        //boolean pattern = find132.find132pattern(new int[]{1,0,1,-4,-3});
        boolean pattern = find132.find132pattern(new int[]{0,2,-3,-1,-2});
        System.out.println(pattern);

    }

    public boolean find132pattern(int[] nums) {
        Integer min = null;
        List<Node> pattern = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            for (int j = 0; j < pattern.size(); j++) {
                if(pattern.get(j).getLeft() < index && index < pattern.get(j).getRight()){
                    return true;
                }
                if(index > pattern.get(j).getRight()){
                    pattern.get(j).setRight(index);
                }
            }

            if(min == null || min > index){
                min = index;
                continue;
            }
            if(min < index){
                pattern.add(new Node(min, index));
                min = null;
            }
        }
        return false;
    }
}
class Node{
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }
}