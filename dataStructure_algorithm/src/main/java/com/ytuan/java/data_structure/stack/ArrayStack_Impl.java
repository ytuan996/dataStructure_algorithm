package com.ytuan.java.data_structure.stack;

import com.ytuan.java.data_structure.array.Arrays_Impl;
import com.ytuan.java.data_structure.array.Arrays_interface;

public class ArrayStack_Impl<E> implements Stack_interface<E> {

    private Arrays_interface<E> arrays;

    public ArrayStack_Impl(int capacity) {

        this.arrays = new Arrays_Impl<>(capacity);
    }

    public ArrayStack_Impl() {

        this.arrays = new Arrays_Impl<>();
    }

    @Override
    public int getSize() {

        return arrays.getSize();
    }

    public int getCapacity() {

        return arrays.getCapacity();
    }

    @Override
    public boolean isEmpty() {

        return arrays.isEmpty();
    }

    @Override
    public void push(E element) {

        arrays.addLast(element);
    }

    @Override
    public E pop() {

        return arrays.removeLast();
    }

    @Override
    public E peek() {

        return arrays.get(getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < arrays.getSize(); i++) {
            res.append(arrays.get(i));
            if (i != arrays.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
