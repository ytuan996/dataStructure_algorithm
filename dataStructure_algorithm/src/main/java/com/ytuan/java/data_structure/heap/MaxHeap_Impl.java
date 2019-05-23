package com.ytuan.java.data_structure.heap;

import com.ytuan.java.data_structure.array.Arrays_Impl;
import com.ytuan.java.data_structure.array.Arrays_interface;

public class MaxHeap_Impl<E extends Comparable> implements MaxHeap_interface<E> {

    private Arrays_interface<E> arrays;

    public MaxHeap_Impl(int capacity) {

        this.arrays = new Arrays_Impl<>(capacity);
    }

    public MaxHeap_Impl() {

        this(8);
    }

    public MaxHeap_Impl(E[] arr) {
        arrays = new Arrays_Impl<E>(arr);
        // 从第一个非叶子节点开始执行shiftDown， heapify过程
        for (int i = parent(arr.length - 1); i >= 0; i--)
            shiftDown(i);
    }

    public int getSize() {

        return arrays.getSize();
    }

    public boolean isEmpty() {

        return arrays.isEmpty();
    }

    private int parent(int index) {

        if (index == 0 || index >= getSize())
            throw new IllegalArgumentException(index + " does not exists parent index");

        return (index - 1) >> 2;
    }

    private int leftChild(int index) {

        if (index < 0 || index > getSize())
            throw new IllegalArgumentException(index + " does not exists child index");

        return (index << 1) + 1;

    }

    @Override
    public void add(E element) {

        arrays.addLast(element);
        shiftUP(getSize() - 1);
    }

    private void shiftUP(int index) {

        while (index > 0 && arrays.get(parent(index)).compareTo(arrays.get(index)) < 0) {
            arrays.swap(parent(index), index);
            index = parent(index);
        }
    }

    @Override
    public E getMax() {

        if (isEmpty())
            throw new IllegalArgumentException("the heap is Empty");

        return arrays.get(0);
    }

    @Override
    public E extractMax() {

        E result = getMax();

        arrays.swap(0, getSize() - 1);
        arrays.removeLast();
        shiftDown(0);
        return result;
    }

    private void shiftDown(int index) {

        while (leftChild(index) < getSize()) {

            int k = leftChild(index);

            if (k + 1 < getSize() && arrays.get(k + 1).compareTo(arrays.get(k)) > 0)
                k = k + 1;

            if (arrays.get(index).compareTo(arrays.get(k)) >= 0)
                break;

            arrays.swap(index, k);

            index = k;
        }
    }

    @Override
    public E replaceMax(E element) {

        E result = getMax();

        arrays.set(0, element);
        shiftDown(0);
        return result;
    }
}
