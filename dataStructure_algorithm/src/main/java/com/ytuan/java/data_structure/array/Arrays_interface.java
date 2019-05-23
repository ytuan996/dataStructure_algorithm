package com.ytuan.java.data_structure.array;

public interface Arrays_interface<E> {

    int getCapacity();

    int getSize();

    boolean isEmpty();

    void add(int index, E element);

    void addLast(E element);

    void addFirst(E element);

    E get(int index);

    E set(int index, E element);

    boolean contains(E element);

    int find(E element);

    E remove(int index);

    E removeFirst();

    E removeLast();

    void removeElement(E element);

    void swap(int index1, int index2);
}
