package com.imooc.leetcode;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/29 17:52
 * @Version 1.0
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int left = 0;
        int right = nums1.length;
        int half = nums1.length + nums2.length + 1;
        while (left<right) {
            int i = (left + right) / 2;
            int j = half/2 - i;

            if(i < right && nums1[i]<nums2[j-1]) {

            } else if(i > left && nums1[i-1] > nums2[j]){

            } else {
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (nums1.length + nums2.length) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == nums1.length) { minRight = nums2[j]; }
                else if (j == nums2.length) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }




}