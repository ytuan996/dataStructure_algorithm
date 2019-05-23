package com.ytuan.java.data_structure.binarySearchTree;

public interface BinarySearchTree_interface<E extends Comparable<E>> {

    int getSize();

    boolean isEmpty();

    void add(E element);

    boolean contains(E element);

    void preOrder();

    void inOrder();

    void postOrder();

    void levelOrder();

    E minElement();

    E maxElement();

    E removeMinElement();

    E removeMaxElement();

    void removeElement(E element);
}
