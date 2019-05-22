package com.ytuan.java.data_structure.linkedList;

public class LinkedList_Impl<E> implements LinkedList_interface<E> {

    private ListNode dummyNode; // 为了后续的操作方便，在此添加一个空的头节点

    private int size;

    public LinkedList_Impl() {

        this.dummyNode = new ListNode();

        this.size = 0;
    }

    private void checkIndex(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index is illegal!!!" + index);
    }

    private void checkEmpty() {

        if (isEmpty())
            throw new IllegalArgumentException("the linkdList is Empty!!!");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 找到待插入位置的前一个节点，新创建一个节点作为前一节点的下一节点，新建节点的下一个节点为原始前一个节点的下一个节点
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {

        checkIndex(index);

        ListNode pre = dummyNode;
        // 从空的头节点开始移动index次到插入位置的前一个节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new ListNode(element, pre.next);
        size++;
    }

    @Override
    public void addLast(E element) {

        add(size, element);
    }

    @Override
    public void addFirst(E element) {

        add(0, element);
    }

    @Override
    public E get(int index) {

        checkIndex(index);

        checkEmpty();

        ListNode cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);
        checkEmpty();

        ListNode cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        E result = cur.val;
        cur.val = element;

        return result;
    }

    @Override
    public boolean contains(E element) {

        checkEmpty();

        ListNode cur = dummyNode.next;
        while (cur != null) {
            if (cur.val.equals(element))
                return true;
            cur = cur.next;
        }

        return false;
    }

    @Override
    public E remove(int index) {

        checkIndex(index);

        checkEmpty();

        ListNode pre = dummyNode;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode delNode = pre.next;
        pre.next = delNode.next;

        delNode.next = null;
        size--;

        return delNode.val;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(E element) {

        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val.equals(element))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        ListNode cur = dummyNode.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

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
