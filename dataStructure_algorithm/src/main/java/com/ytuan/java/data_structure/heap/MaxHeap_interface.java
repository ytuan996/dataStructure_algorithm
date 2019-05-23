package com.ytuan.java.data_structure.heap;

public interface MaxHeap_interface<E extends Comparable> {

    void add(E element);

    E getMax();

    E extractMax();

    E replaceMax(E element);
}
