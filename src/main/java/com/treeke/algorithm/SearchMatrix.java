package com.treeke.algorithm;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {};
        boolean b = searchMatrix.searchMatrix(matrix, 30);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int n = matrix[0].length;
        Integer index = null;
        for (int i = 0; i < matrix.length; i++) {
            if(target == matrix[i][0] || target == matrix[i][n-1]){
                return true;
            }
            if(target > matrix[i][0] && target < matrix[i][n-1]){
                index = i;
                break;
            }
        }
        if(index == null) return false;
        for (int i = 0; i < matrix[index].length; i++) {
            if(target == matrix[index][i]){
                return true;
            }
        }
        return false;
    }
}
