package com.imooc;

import com.imooc.base.In;
import com.imooc.base.Out;
import com.imooc.base.StdOut;
import com.imooc.base.Stopwatch;

import java.util.Arrays;

/**
 * @ClassName JavaSortTest
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 18:04
 * @Version 1.0
 */
public class JavaSortTest {

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        In in = new In("data/1Mints.txt");
        int[] a = in.readAllInts();
        StdOut.println(a.length);
        StdOut.println("elapsed time = " + timer.elapsedTime());
//        Arrays.LegacyMergeSort
        Arrays.sort(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());


    }
}
