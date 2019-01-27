package com.imooc.sort;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 16:46
 * @Version 1.0
 */
public class MergeSort {
    void mergeSort(int[] a, int[] temArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, temArray, left, center);
            mergeSort(a, temArray, center + 1, right);
            merge(a, temArray, left, center+1, right);
        }
    }

    public void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (Integer.compare(a[leftPos], a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
