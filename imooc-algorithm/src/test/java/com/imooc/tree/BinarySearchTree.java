package com.imooc.tree;

import com.imooc.tree.exception.UnderflowException;

/**
 * @ClassName BinarySearchTree
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 10:35
 * @Version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(T element) {
            this(element, null, null);
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return findMin(root).element;
    }
    public T findMax() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return findMax(root).element;
    }
    public void insert(T x){
        root = insert(x, root);
    }
    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree(){
        if (isEmpty()){
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }



    private boolean contains(T x, BinaryNode<T> t){
        if (t==null){
            return false;
        }
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if (t==null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if (t!=null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }
    private BinaryNode<T> insert(T x, BinaryNode<T> t){
        if (t==null) {
            return new BinaryNode<>(x, null, null);
        }

        int compareResult =  x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {

        }
        return t;

    }

//    private T removeMin(BinaryNode<T> t) {
//        if (t==null) {
//            return null;
//        }
//        BinaryNode<T> tempT = t.right;
//        T result = null;
//        if (tempT==null) {
//            result = tempT.element;
//            t.right = null;
//        }
//
//        while (tempT!=null){
//            if(tempT.left!=null){
//                tempTFather = tempT;
//                tempT = tempT.left;
//            } else {
//                tempT.element;
//                tempTFather.left = null;
//            }
//
//        }
//    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t){
        if (t==null) {
            return t;
        }

        int compareResult =  x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left!=null&&t.right!=null){
            // 查找并删除最小值，做了两次查询
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);

//            removeMin(t);


        } else {
            t = (t.left != null) ? t.left:t.right;
        }
        return t;
    }
    private void printTree(BinaryNode<T> t){
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }
}
