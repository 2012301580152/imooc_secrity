package com.imooc.analyze;

import com.imooc.base.StdOut;
import com.imooc.base.Stopwatch;


/**
 * @ClassName Fastsqrt
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 17:05
 * @Version 1.0
 */
public class Fastsqrt {

//    static float Q_rsqrt(float number) {
//        long i;
//        float x2, y;
//        final float threehalfs = 1.5F;
//
//        x2 = number * 0.5F;
//        y  = number;
//        i  = * ( long * ) &y;						// evil floating point bit level hacking
//        i  = 0x5f3759df - ( i >> 1 );               // what the fuck?
//        y  = * ( float * ) &i;
//        y  = y * ( threehalfs - ( x2 * y * y ) );   // 1st iteration
////	y  = y * ( threehalfs - ( x2 * y * y ) );   // 2nd iteration, this can be removed
//
//    }




    public static void main(String[] args) {
        int n = Integer.parseInt("100000000");

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }
}
