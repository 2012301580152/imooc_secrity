package com.imooc.analyze;

import com.imooc.base.In;
import com.imooc.base.StdIn;
import com.imooc.base.StdOut;
import com.imooc.base.Stopwatch;

/**
 * @ClassName ThreeSum
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 16:05
 * @Version 1.0
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+ 1; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (a[i] + a[j] + a[k]==0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        In in = new In("data/4Kints.txt");
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
