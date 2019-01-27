package com.imooc.collections;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 11:55
 * @Version 1.0
 */
public class Test {
    public void add(int i) {
        new A().add2(i);
    }

    public int getCur() {
        return new A().current;
    }

    public int getNext() {
        return new A().getNext();
    }
    private class A {
        public int current = 0;
        public int next = 2;

        public void add2(int i) {
            current += i;
            next += i;
        }

        public int getNext() {
            return next;
        }
    }
}
