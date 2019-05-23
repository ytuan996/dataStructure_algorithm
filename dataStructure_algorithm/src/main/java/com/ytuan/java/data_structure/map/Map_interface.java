package com.ytuan.java.data_structure.map;

public interface Map_interface<K, V> {

    void add(K key, V value);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    V remove(K key);

    int getSize();

    boolean isEmpty();
}
