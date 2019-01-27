package com.imooc.leetcode;

import com.imooc.base.In;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SolutionTests
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/29 19:27
 * @Version 1.0
 */
public class SolutionTests {

    private String initStr(String s) {
        char starb = '\11';
        char sb = '\10';
        StringBuffer newstr = new StringBuffer(s.length()*2+3);
        newstr.append(starb);
        for (int i = 0; i < s.length(); i++) {
            newstr.append(sb);
            newstr.append(s.charAt(i));
        }
        newstr.append(sb);
        newstr.append('\01');
        return newstr.toString();
    }


    public String longestPalindrome(String s) {

        s = initStr(s);
        int maxLen = -1;

        String result = null;

        int[] p = new int[s.length()];

        int id = -1;
        int mx = 0;

        for (int i = 1; i < s.length()-1; i++) {
            if (i<mx) {
                p[i] = Math.min(p[2*id-i], mx -i);
            } else {
                p[i] = 1;
            }
            while (s.charAt(i-p[i])==s.charAt(i+p[i])) {
                p[i]++;
            }

            if (mx < i + p[i]){
                id = i;
                mx = i + p[i];
            }


            if (maxLen < p[i] - 1) {
                maxLen = p[i] - 1;

                result = s.substring(i-(p[i]-1), i+(p[i]-1));
            }

        }

        return getResult(result);
    }

    private String getResult(String s) {
        StringBuffer result = new StringBuffer(s.length()/2);
        for (int i = 0; i < s.length(); i++) {
            if (i%2==1) {
                result.append(s.charAt(i));
            }
        }
        return  result.toString();
    }

    @Test
    public void test01() {


            String s = "abadbjk";

            String ret = new SolutionTests().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);

    }


    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        int len = s.length();
        int singleLen = 2 * (numRows -1);
        StringBuffer buffer = new StringBuffer(len);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len/singleLen + 1; j++) {
                int idx = j*singleLen;

                if (idx+i < len) {
                    buffer.append(s.charAt(idx+i));
                }


                if (i==0 || i == numRows-1) {

                } else {

                    if (idx+singleLen-i < len) {
                        buffer.append(s.charAt(idx+singleLen-i));
                    }


                }

            }
        }

        return buffer.toString();


    }

    @Test
    public void test02(){
        convert("LEETCODEISHIRING", 4);
    }

    private String reverse(String s) {
        int len = s.length();
        StringBuffer result = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            result.append(s.charAt(len-1-i));
        }
        return result.toString();
    }

    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }


    @Test
    public void test03() {

        reverse(-2147483648);
    }


    public String optimalDivision(int[] nums) {

        if (nums.length == 0) return "";
        if (nums.length == 1) return ""+nums[0];
        if (nums.length == 2) return ""+nums[0] + "/" + nums[1];

        StringBuffer buffer = new StringBuffer();
        buffer.append(nums[0]);
        buffer.append("/(");
        for (int i = 1; i < nums.length-1; i++) {
            buffer.append(nums[i]);
            buffer.append('/');
        }
        buffer.append(nums[nums.length-1]);
        buffer.append(")");
        return buffer.toString();
    }

//    private int getBestJumps(int[] nums, int pos) {
//        int setp =
//        getBestJumps(nums, pos-1);
//    }


    public int jump(int[] nums) {

        int len = nums.length;
        if (len==1) return 0;
        int current = 0;
        int maxDis = 0;
        int step = 0;
        for (int i = 0; i < len; i++) {
            if (i > current) {
                current = maxDis;
                step++;
            }
            maxDis = Math.max(maxDis, i + nums[i]);
            if (maxDis >= len-1) {
                return ++step;
            }

        }
        return step;

    }

    @Test
    public void test04() {
        int[] nums = {2,3,1,1,4};
        int x = jump(nums);
        System.out.println(x);
    }


    public String minWindow(String s, String t) {

        List<Integer>[] lists = new List[t.length()];
        for (int i = 0; i < t.length(); i++) {
            lists[i] = new ArrayList<>();
        }
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i)==t.charAt(j)){
                    lists[j].add(i);
                    pos.add(i);
                }
            }
        }


        loop1: while (true) {
            int biggest = pos.get(pos.size()-1);
            for (int i = 0; i < t.length(); i++) {

                if(lists[i].contains(biggest)){
                    if (lists[i].size()>1) {
                        lists[i].remove(lists[i].size()-1);
                        pos.remove(pos.size()-1);
                    } else {
                        break loop1;
                    }
                }
            }
        }

        loop2: while (true) {
            int smallest = pos.get(0);
            for (int i = 0; i < t.length(); i++) {

                if(lists[i].contains(smallest)){
                    if (lists[i].size()>1) {
                        lists[i].remove(0);
                        pos.remove(0);
                    } else {
                        break loop2;
                    }
                }
            }
        }

        return s.substring(pos.get(0), pos.get(pos.size()-1)+1);

    }

    @Test
    public void test005() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String x = minWindow(s, t);

        System.out.println(x);
    }
}
