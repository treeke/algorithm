package com.treeke.algorithm.doublepointer;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(ints));
    }

    /**
     * 双指针
     * 面积能不能更大取决于短边的指针
     * 每次判断移动短边的指针 计算面积大小
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, max = 0;
        while (left != right){
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            int i = height[left] <= height[right] ? left++ : right--;
        }
        return max;
    }
}
