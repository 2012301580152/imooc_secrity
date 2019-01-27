package com.imooc.tree;

/**
 * @ClassName MaxSubSum
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 9:10
 * @Version 1.0
 */
public class MaxSubSum {

    private int maxSumRec(int[] a, int left, int right) {
        if(left == right) {
            if(a[left]>0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int center = (left+right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxrightSum = maxSumRec(a, center+1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--){
            leftBorderSum += a[i];
            if( leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center; i >= left; i--){
            rightBorderSum += a[i];
            if( rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(Math.max(maxLeftSum, maxrightSum),maxLeftBorderSum+maxRightBorderSum);
    }


}
