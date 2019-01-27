package com.imooc.collections;

/**
 * @ClassName BootStarp
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 12:03
 * @Version 1.0
 */
public class BootStarp {
    public static void main(String[] args) {
        Test t = new Test();
        t.add(2);
        System.out.println(t.getCur());
        System.out.println(t.getNext());
    }
}
