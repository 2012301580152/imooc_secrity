package com.imooc.sort;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 15:48
 * @Version 1.0
 */
public class ShellSort<T extends Comparable<? super T>> {
    static void shellsort(int[] a) {
    int j;
    for (int gap = a.length / 2; gap >0; gap/=2) {
        for (int i = gap; i < a.length; i++) {
            int tmp = a[i];
            for (j = i; j >= gap && Integer.compare(tmp, a[j-gap]) < 0; j -= gap) {
                a[j] = a[j-gap];
            }
            a[j] = tmp;
        }
    }
}


    public static void main(String[] args) {
        int[] a = {3,5,23,43,23,5,2,25,345,1,123,423,23};

        shellsort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }

    }
}
