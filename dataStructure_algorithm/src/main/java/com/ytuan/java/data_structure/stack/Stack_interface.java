package com.ytuan.java.data_structure.stack;

/**
 * 先进后出
 *
 * @param <E>
 */
public interface Stack_interface<E> {

    int getSize();

    boolean isEmpty();

    void push(E element);

    E pop();

    E peek();
}
