package com.imooc.tree.avlTree;

/**
 * @ClassName AvlNode
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 12:58
 * @Version 1.0
 */
public class AvlTree<T extends Comparable<? super T>>{
    private class AvlNode<T> {

        public AvlNode(T element) {
            this(element, null, null);
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }

    private int height(AvlNode<T> t){
        return t == null?-1:t.height;
    }

    private AvlNode<T> insert(T x,  AvlNode<T> t) {
        if (t==null) {
            return new AvlNode<>(x, null, null);
        }
        int comparaResult = x.compareTo(t.element);

        if (comparaResult< 0){
            t.left = insert(x, t.left);
        }else if (comparaResult>0){
            t.right = insert(x, t.right);
        } else {

        }
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> t){
        if (t==null) {
            return t;
        }

        if (height(t.left)-height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left)>=height(t.left.right)){
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right)-height(t.left) > ALLOWED_IMBALANCE){
            if (height(t.right.right)>=height(t.right.left)){
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return t;
        }

        int comparaResult = x.compareTo(t.element);

        if (comparaResult< 0){
            t.left = remove(x, t.left);
        }else if (comparaResult>0){
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = t.left!=null?t.left:t.right;
        }
        return balance(t);

    }

    private AvlNode<T> findMin(AvlNode<T> t){
        if (t==null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }
}

