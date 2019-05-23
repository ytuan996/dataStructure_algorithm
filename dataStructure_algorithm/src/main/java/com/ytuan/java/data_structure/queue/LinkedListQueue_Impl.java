package com.ytuan.java.data_structure.queue;

import com.ytuan.java.data_structure.linkedList.LinkedList_Impl;
import com.ytuan.java.data_structure.linkedList.LinkedList_interface;

public class LinkedListQueue_Impl<E> implements Queue_interface<E> {

    private LinkedList_interface<E> linkedList;

    public LinkedListQueue_Impl() {

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
    public void enqueue(E element) {

        linkedList.addLast(element);
    }

    @Override
    public E dequeue() {

        return linkedList.removeFirst();
    }

    @Override
    public E getFront() {
        return linkedList.getFirst();
    }
}
