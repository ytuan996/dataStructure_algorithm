package com.ytuan.java.data_structure.queue;

import com.ytuan.java.data_structure.array.Arrays_Impl;
import com.ytuan.java.data_structure.array.Arrays_interface;

public class ArrayQueue_Impl<E> implements Queue_interface<E> {

    private Arrays_interface<E> arrays;

    public ArrayQueue_Impl(int capacity) {

        this.arrays = new Arrays_Impl<>(capacity);
    }

    public ArrayQueue_Impl() {

        this.arrays = new Arrays_Impl<>();
    }

    @Override
    public int getSize() {

        return arrays.getSize();
    }

    @Override
    public boolean isEmpty() {

        return arrays.isEmpty();
    }

    public int getCapacity() {

        return arrays.getCapacity();
    }

    @Override
    public void enqueue(E element) {

        arrays.addLast(element);
    }

    @Override
    public E dequeue() {

        return arrays.removeFirst();
    }

    @Override
    public E getFront() {

        return arrays.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < arrays.getSize(); i++) {
            res.append(arrays.get(i));
            if (i != arrays.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
