package com.treeke.algorithm.simulation;

public class MaxDistance {

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int head = 0, tail = nums2.length-1;
        while (nums1[head] > nums2[tail] && head < nums1.length -1){
            head++;
        }
        int max1 = head == nums1.length - 1 ? 0 : tail - head;
        head = 0;
        while (nums1[head] > nums2[tail] && tail > 0){
            tail--;
        }
        int max2 = tail == 0 ? 0 : tail - head;
        return Math.max(max1, max2);
    }
}
