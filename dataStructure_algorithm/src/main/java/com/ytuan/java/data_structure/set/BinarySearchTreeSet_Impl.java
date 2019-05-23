package com.ytuan.java.data_structure.set;

import com.ytuan.java.data_structure.binarySearchTree.BinarySearchTree_Impl;
import com.ytuan.java.data_structure.binarySearchTree.BinarySearchTree_interface;

public class BinarySearchTreeSet_Impl<E extends Comparable<E>> implements Set_interface<E> {

    private BinarySearchTree_interface<E> bst;

    public BinarySearchTreeSet_Impl() {

        this.bst = new BinarySearchTree_Impl<>();
    }

    @Override
    public void add(E element) {

        bst.add(element);
    }

    @Override
    public boolean contains(E element) {

        return bst.contains(element);
    }

    @Override
    public void remove(E element) {

        bst.removeElement(element);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
