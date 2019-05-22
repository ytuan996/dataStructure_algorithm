package com.ytuan.java.data_structure.stack;

import com.ytuan.java.data_structure.linkedList.LinkedList_Impl;
import com.ytuan.java.data_structure.linkedList.LinkedList_interface;

public class LinkedListStack_Impl<E> implements Stack_interface<E> {

    private LinkedList_interface<E> linkedList;

    public LinkedListStack_Impl() {

        this.linkedList = new LinkedList_Impl<>();
    }

    @Override
    public int getSize() {

        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {

        return linkedList.isEmpty();
    }

    @Override
    public void push(E element) {

        linkedList.addLast(element);
    }

    @Override
    public E pop() {

        return linkedList.removeLast();
    }

    @Override
    public E peek() {

        return linkedList.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }
}
