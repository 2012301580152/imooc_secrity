package com.imooc;

import com.imooc.base.In;
import com.imooc.base.Out;
import com.imooc.base.StdOut;
import com.imooc.base.Stopwatch;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * @ClassName DataSort
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 17:19
 * @Version 1.0
 */
public class DataSort {
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        In in = new In("data/smalltest");
        String[] a = in.readAllLines();
        StdOut.println(a.length);
        StdOut.println("elapsed time = " + timer.elapsedTime());
//        Arrays.LegacyMergeSort
        Arrays.sort(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        Out out = new Out("data/test2.csv");
        for (int i = 0; i < a.length; i++) {
            out.println(a[i]);
        }
        StdOut.println("elapsed time = " + timer.elapsedTime());

        out.close();




        StdOut.println("elapsed time = " + timer.elapsedTime());

    }
}
