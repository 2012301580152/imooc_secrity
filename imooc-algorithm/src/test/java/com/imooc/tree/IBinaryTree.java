package com.imooc.tree;

import com.imooc.tree.exception.UnderflowException;

/**
 * @ClassName ITree
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 13:28
 * @Version 1.0
 */
public interface IBinaryTree<T extends Comparable<? super T>> {

    public void makeEmpty();

    public boolean isEmpty();

    public boolean contains(T x);

    public T findMin() throws UnderflowException;
    public T findMax() throws UnderflowException;
    public void insert(T x);
    public void remove(T x);

    public void printTree();
}
