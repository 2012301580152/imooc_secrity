package com.imooc.heap;

/**
 * @ClassName Heap
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/29 15:24
 * @Version 1.0
 */
public class Heap<T extends Comparable<? super T>> {
    public int parrent(int i) {
//        return (i+1)/2 -1;
        return (i-1)/2;
    }

    public int left(int i) {
        return 2*i+1;
    }

    public int right(int i) {
        return 2*i+2;
    }

    public void maxHeapify(T[] a, int i) {
        int l = left(i);
        int r = right(i);
//        if (l <= a)
    }
}
