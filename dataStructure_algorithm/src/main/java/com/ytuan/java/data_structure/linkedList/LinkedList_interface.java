package com.ytuan.java.data_structure.linkedList;

public interface LinkedList_interface<E> {

    int getSize();

    boolean isEmpty();

    void add(int index, E element);

    void addLast(E element);

    void addFirst(E element);

    E get(int index);

    E getFirst();

    E getLast();

    E set(int index, E element);

    boolean contains(E element);

    E remove(int index);

    E removeFirst();

    E removeLast();

    void removeElement(E element);

}
