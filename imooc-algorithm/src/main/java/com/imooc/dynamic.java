package com.imooc;

/**
 * @ClassName dynamic
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/28 22:31
 * @Version 1.0
 */
public class dynamic {
    static int memoizedCutRod(int[] p, int n) {
        int[] r = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            r[i] = -1;
        }
        return memoizedCutRodAux(p,n,r);

    }

    static int memoizedCutRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0){
            return r[n];
        }
        int q;
        if (n==0) {
            q = 0;
        } else {
            q = -1;
            for (int i = 1; i < n + 1; i++) {
                q = Math.max(q,p[i-1]+memoizedCutRodAux(p,n-i,r));
            }
        }

        return r[n] = q;
    }

    //
    static int cutRod(int[] p, int n) {
        if (n==0) {
            return 0;
        }
        int q = -1;
        for (int i = 1; i < n + 1; i++) {
            q = Math.max(q, p[i-1]+cutRod(p,n-i));
        }
        return q;
    }

    // N2
    static int bottomUpCutRod(int[] p, int n) {
        int[] r = new int[n+1];
        r[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int q = -1;
            for (int j = 1; j < i+1; j++) {
                q = Math.max(q, p[j-1]+r[i-j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {
        int[] p = {1,5,8,9,10,17,17,20,24,30};
        int n = 8;
        int x = memoizedCutRod(p, n);
        int y = cutRod(p,n);
        int z = bottomUpCutRod(p,n);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
