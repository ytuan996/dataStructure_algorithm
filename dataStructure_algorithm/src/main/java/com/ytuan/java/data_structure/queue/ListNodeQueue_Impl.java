package com.ytuan.java.data_structure.queue;

public class ListNodeQueue_Impl<E> implements Queue_interface<E> {

    private ListNode front, tail;

    private int size;

    public ListNodeQueue_Impl() {

        this.front = this.tail = null;

        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {

        if (front == null) {
            tail = new ListNode(element);
            front = tail;
        } else {
            tail.next = new ListNode(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty!!!");

        ListNode delNode = front;
        front = delNode.next;

        delNode.next = null;
        if (front == null)
            tail = null;

        size--;
        return delNode.val;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty!!!");

        return front.val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        ListNode cur = front;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    private class ListNode {

        E val;

        ListNode next;

        public ListNode(E val) {
            this(val, null);
        }

        public ListNode() {
            this(null);
        }

        public ListNode(E val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
