package com.imooc.analyze;

import com.imooc.base.BinarySearch;
import com.imooc.base.In;
import com.imooc.base.StdOut;
import com.imooc.base.Stopwatch;

import java.util.Arrays;

/**
 * @ClassName TwoSumFast
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 16:31
 * @Version 1.0
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int count3(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (BinarySearch.indexOf(a,-a[i]-a[j]) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In("data/1Mints.txt");
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count3(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
