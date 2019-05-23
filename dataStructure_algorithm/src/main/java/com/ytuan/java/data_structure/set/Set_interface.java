package com.ytuan.java.data_structure.set;

public interface Set_interface<E> {

    void add(E element);

    boolean contains(E element);

    void remove(E element);

    int getSize();

    boolean isEmpty();
}
