package com.treeke.algorithm;


public class MatrixSpiralOrder2 {

    public static void main(String[] args) {
        MatrixSpiralOrder2 matrixSpiralOrder2 = new MatrixSpiralOrder2();
        int[][] ints = matrixSpiralOrder2.generateMatrix(5);
        System.out.println(ints);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int tCount = 0,dCount = 0,lCount = 0,rCount = 0;
        while(true){
            for (int j = lCount; j < n - rCount; j++) {
                matrix[tCount][j] = count++;
            }
            tCount++;
            if(tCount + dCount >= n) break;
            for (int j = tCount; j < n - dCount; j++) {
                matrix[j][n - 1 - rCount] = count++;
            }
            rCount++;
            if(rCount + lCount >= n) break;
            for (int j = n - 1 - rCount; j > lCount - 1; j--) {
                matrix[n - 1 - dCount][j] = count++;
            }
            dCount++;
            if(tCount + dCount >= n) break;
            for (int j = n - 1 - dCount; j > tCount - 1; j--) {
                matrix[j][lCount] = count++;
            }
            lCount++;
            if(rCount + lCount >= n) break;
        }
        return matrix;
    }
}
