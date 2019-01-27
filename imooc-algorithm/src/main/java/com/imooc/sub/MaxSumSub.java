package com.imooc.sub;

/**
 * @ClassName MaxSumSub
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 19:44
 * @Version 1.0
 */
public class MaxSumSub {
    static double MaxAddSub(double[] a, int from, int to) {
        if (to==(from+1)) {
            return a[from];
        }

        int mid = (from+to) / 2;
        double m1 = MaxAddSub(a, from, mid);
        double m2 = MaxAddSub(a, mid, to);

        double leftMax = a[mid-1];
        double now = a[mid-1];
        for (int i = mid-2; i >= from; i-- ) {
            now += a[i];
            leftMax = Math.max(leftMax, now);
        }
        double rightMax = a[mid];
        now = a[mid];
        for (int i = mid+1; i < to; i++) {
            now += a[i];
            rightMax = Math.max(rightMax, now);
        }
        double m3 = leftMax + rightMax;
        return Math.max(Math.max(m1,m2),m3);
    }


    // 前缀和
    // 比较完善
    static double MaxAddSub3(double[] a) {
        double m = 0;
//        double l = m;
        double now = m;
        double result = m;
        for (int i = 0; i < a.length; i++) {
            now += a[i];
            m = m < now?m:now;
            result = result > now - m?result:now-m;
//            l = l > now?l:now;
        }
        return result;
    }

    // 后缀和
    static double MaxAddSub4(double[] a) {
        double m = 0;
        double result = m;
        double now = m;
        for (int i = a.length-1; i >= 0; i--) {
            now += a[i];
            m = m < now?m:now;
            result = result > now - m?result:now-m;
        }
        return result;
    }

    // 中缀和
    static double MaxAddSub2(double[] a) {
        double result = a[0];
        double sum = a[0];

        for (int i = 1; i < a.length; i++) {
            if (sum > 0) {
                sum += a[i];
            } else {
                sum = a[i]; //如果数组全部是负数
            }
            result = result > sum?result:sum;
//            result = sum;
        }
        return result;
    }

    // 中缀和
    static double ZeroAddSub2(double[] a) {
        double result = a[0];
        double sum = a[0];

        for (int i = 1; i < a.length; i++) {
//           if
        }
        return result;
    }

    public static void main(String[] args) {
        double[] a = {1,-3,3,5,6,-2,-2,5,-4,3,-10,-10,10,20,8,-9,-3,12,16,-20,-10};
//        double[] a = {-5,-6,-2,1,-4,-3};
//        double[] a = {1,2};
        double x = MaxAddSub(a, 0, a.length);
        double y = MaxAddSub2(a);
        double z = MaxAddSub3(a);
        double w = MaxAddSub4(a);
        System.out.println(x);

        System.out.println(y);
        System.out.println(z);
        System.out.println(w);

    }
}
