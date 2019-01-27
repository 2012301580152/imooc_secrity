package com.imooc.sort;

import java.util.ArrayList;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/27 19:07
 * @Version 1.0
 */
public class Sort<T extends Comparable<? super T>> {
    void insertionSort(T[] a) {
        insertionSort(a, 0, a.length);
    }

    void insertionSort(T[] a, int left, int right) {
        int j;

        for (int p = left + 1; p < right; p++) {
            T tmp = a[p];
            for (j = p; j >0 && tmp.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    void heapsort(T[] a) {
        for (int i = a.length/2-1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length-1; i>0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private void swapReferences(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int leftChild(int i) {
        return 2*i+1;
    }

    private void percDown(T[] a, int i, int n) {
        int child;
        T tmp;

        for (tmp = a[i]; leftChild(i) < n; i= child) {
            child = leftChild(i);
            if (child != n-1 && a[child].compareTo(a[child+1]) < 0) {
                child++;
            }
            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    final int CUTOFF = 10;

    T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }

        swapReferences(a, center, right-1);
        return a[right-1];
    }

    void quickSelect(T[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            int i = left, j = right - 1;
            for (;;) {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[--j].compareTo(pivot) > 0) {}
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right-1);

            if (k <= i) {
                quickSelect(a, left, i-1, k);
            } else if (k > i + 1) {
                quickSelect(a, i+1, right, k);
            }
        } else {
            insertionSort(a, left, right);
        }
    }


    void quickSort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            int i = left, j = right - 1;
            for (;;) {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[--j].compareTo(pivot) > 0) {}
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right-1);

            quickSort(a, left, i-1);
            quickSort(a, i+1, right);
        } else {
            insertionSort(a, left, right);
        }
    }

    void radixSortA(String[] arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s:arr) {
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;

            for (ArrayList<String> thisBucket:buckets) {
                for (String s:thisBucket) {
                    arr[idx++] = s;
                }

                thisBucket.clear();
            }
        }

    }

    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public void selectSort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[i], a[min])) {
                    min = j;
                }
            }
            exch(a, i , min);
        }
    }
}
