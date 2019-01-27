package com.imooc.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 18:44
 * @Version 1.0
 */
public class QuickSort {
    public static void sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size()/2);

            for (Integer i : items) {
                if (i < chosenItem) {
                    smaller.add(i);
                } else if (i > chosenItem) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }
            sort(smaller);
            sort(larger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }


}
