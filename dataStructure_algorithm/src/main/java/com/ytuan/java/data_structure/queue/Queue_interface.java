package com.ytuan.java.data_structure.queue;

public interface Queue_interface<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();

    E getFront();
}
