package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        //int[] arr = new int[]{3,2,2,4,1,4};
        int[] arr = new int[]{361,321,186,186,67,283,36,471,304,218,60,78,149,166,282,384,61,242,426,275,236,221,27,261,487,90,468,19,453,241};
        //int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        int i = shipWithinDays.shipWithinDays(arr, 15);
        System.out.println(i);
    }

    public int shipWithinDays(int[] weights, int D) {
        int length = weights.length;
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();
        int avg = (int)Math.ceil((double) sum / D);
        int rule = Math.max(avg, max);
        return findIt(weights, length, rule, D);
    }

    private Integer findIt(int[] arr, int length, int rule, int d) {
        int temp = 0, count = 0, index = 0;
        while (count < d && index < length){
            if(temp == 0){
                temp = arr[index];
                index++;
                continue;
            }
            int i = temp + arr[index];
            if(i < rule){
                temp = i;
                index++;
                if(index >= length){
                    count++;
                }
                continue;
            }
            if(i == rule){
                temp = 0;
                count++;
                index++;
                continue;
            }
            if(i > rule){
                temp = 0;
                count++;
                continue;
            }
        }
        if(index < length || count > d){
            return findIt(arr, length, rule+1, d);
        }
        return rule;
    }
}
