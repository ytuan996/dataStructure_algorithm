package com.ytuan.java.data_structure.set;

import com.ytuan.java.data_structure.linkedList.LinkedList_Impl;
import com.ytuan.java.data_structure.linkedList.LinkedList_interface;

public class LinkedListSet_Impl<E> implements Set_interface<E> {

    private LinkedList_interface linkedList;

    public LinkedListSet_Impl() {

        this.linkedList = new LinkedList_Impl();
    }

    @Override
    public void add(E element) {

        linkedList.addLast(element);
    }

    @Override
    public boolean contains(E element) {

        return linkedList.contains(element);
    }

    @Override
    public void remove(E element) {

        linkedList.removeElement(element);
    }

    @Override
    public int getSize() {

        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {

        return linkedList.isEmpty();
    }
}
