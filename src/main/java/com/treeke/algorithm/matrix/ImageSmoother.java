package com.treeke.algorithm.matrix;

public class ImageSmoother {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
        ImageSmoother imageSmoother = new ImageSmoother();
        imageSmoother.imageSmoother(nums);
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                ans[i][j] = getAvg(img, i ,j);
            }
        }
        return ans;
    }

    public int getAvg(int[][] img, int i, int j){
        int res = img[i][j];
        int count = 1;
        if(j > 0){
            res = res + img[i][j-1];
            count++;
        }
        if(j < img[i].length-1){
            res = res + img[i][j+1];
            count++;
        }
        if(i > 0){
            res = res + img[i-1][j];
            count++;
            if(j > 0){
                res = res + img[i-1][j-1];
                count++;
            }
            if(j < img[i].length-1){
                res = res + img[i-1][j+1];
                count++;
            }
        }
        if(i < img.length - 1){
            res = res + img[i+1][j];
            count++;
            if(j > 0){
                res = res + img[i+1][j-1];
                count++;
            }
            if(j < img[i].length-1){
                res = res + img[i+1][j+1];
                count++;
            }
        }
        return res / count;
    }
}
