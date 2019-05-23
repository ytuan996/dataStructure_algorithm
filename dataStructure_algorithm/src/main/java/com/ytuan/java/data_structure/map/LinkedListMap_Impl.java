package com.ytuan.java.data_structure.map;

public class LinkedListMap_Impl<K, V> implements Map_interface<K, V> {

    private ListNode dummyNode;

    private int size;


    public LinkedListMap_Impl() {

        this.dummyNode = new ListNode();

        this.size = 0;
    }

    private ListNode getNode(K key) {

        if (isEmpty())
            return null;

        ListNode curNode = dummyNode.next;
        while (curNode != null) {
            if (curNode.key.equals(key))
                return curNode;
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

        ListNode node = getNode(key);

        if (node == null) {
            size++;
            dummyNode.next = new ListNode(key, value, dummyNode.next);
        } else
            node.value = value;
    }

    @Override
    public boolean contains(K key) {

        return getNode(key) != null;
    }

    @Override
    public V get(K key) {

        ListNode node = getNode(key);

        if (node != null)
            return node.value;

        return null;
    }

    @Override
    public void set(K key, V newValue) {

        ListNode node = getNode(key);

        if (node != null)
            node.value = newValue;
        else
            throw new IllegalArgumentException("the map does not exists this key!!!");
    }

    @Override
    public V remove(K key) {

        ListNode node = getNode(key);

        if (node != null) {

            ListNode preNode = dummyNode;
            while (preNode.next != null) {
                if (preNode.next.key.equals(key))
                    break;
                preNode = preNode.next;
            }

            if (preNode.next != null) {

                ListNode delNode = preNode.next;
                preNode.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            } else
                return null;

        } else {
            throw new IllegalArgumentException("the map does not exists this key!!!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class ListNode {

        K key;

        V value;

        ListNode next;

        public ListNode(K key, V value, ListNode next) {

            this.key = key;

            this.value = value;

            this.next = next;
        }

        public ListNode() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
}
