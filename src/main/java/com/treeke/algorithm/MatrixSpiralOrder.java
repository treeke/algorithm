package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class MatrixSpiralOrder {

    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10}};
        //int[][] matrix = new int[][]{{1,2},{3,4}};
        //int[][] matrix = new int[][]{{1,2,3}};
        //int[][] matrix = new int[][]{{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        MatrixSpiralOrder matrixSpiralOrder = new MatrixSpiralOrder();
        List<Integer> integers = matrixSpiralOrder.spiralOrder(matrix);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int tCount = 0;
        int dCount = 0;
        int lCount = 0;
        int rCount = 0;
        boolean top = false;
        boolean down = false;
        boolean left = false;
        boolean right = true;
        for (int i = 0; i < m + n -1; i++) {
            if (top){
                for (int j = m - 1 - dCount; j > tCount - 1; j--) {
                    int[] arr = matrix[j];
                    list.add(arr[lCount]);
                }
                top = false;
                right = true;
                lCount++;
                if(rCount + lCount >= n){
                    return list;
                }
                continue;
            }
            if (down){
                for (int j = tCount; j < m - dCount; j++) {
                    int[] arr = matrix[j];
                    list.add(arr[n - 1 - rCount]);
                }
                down = false;
                left = true;
                rCount++;
                if(rCount + lCount >= n){
                    return list;
                }
                continue;
            }
            if (left){
                int[] arr = matrix[m - 1 - dCount];
                for (int j = n - 1 - rCount; j > lCount - 1; j--) {
                    list.add(arr[j]);
                }
                left = false;
                top = true;
                dCount++;
                if(tCount + dCount >= m){
                    return list;
                }
                continue;
            }
            if (right){
                int[] arr = matrix[tCount];
                for (int j = lCount; j < n - rCount; j++) {
                    list.add(arr[j]);
                }
                right = false;
                down = true;
                tCount++;
                if(tCount + dCount >= m){
                    return list;
                }
                continue;
            }
        }
        return list;
    }
}
