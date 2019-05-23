package com.ytuan.java.data_structure.array;

public class Arrays_Impl<E> implements Arrays_interface<E> {

    private E data[];

    private int size;

    public Arrays_Impl(int capacity) {

        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Arrays_Impl(E[] data) {
        this.data = data;
        this.size = data.length;
    }

    public Arrays_Impl() {
        this(8);
    }

    @Override
    public int getCapacity() {
        return this.data.length;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(int index, E element) {

        checkIndex(index);

        // 元素个数和数组容量相等时，需要扩容，这里扩展至原来的 1.5 倍
        if (size == getCapacity())
            resize((getCapacity() >> 1) + getCapacity());

        // 循环从最后一个元素： size - 1 到 index，向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;

    }

    private void checkIndex(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index is out of bound: " + index);
    }

    private void resize(int newCapacity) {

        E newData[] = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void addLast(E element) {
        add(size, element);
    }

    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 此函数返回数组中的 第index 个元素， 下标从 0 开始 [0, size - 1] 闭区间
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {

        checkIndex(index);
        return data[index];
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);

        E result = data[index];
        data[index] = element;
        return result;
    }

    @Override
    public boolean contains(E element) {

        if (isEmpty())
            throw new IllegalArgumentException("the array is Empty!!");

        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int find(E element) {

        if (contains(element))
            for (int i = 0; i < size; i++) {
                if (data[i].equals(element))
                    return i;
            }
        return -1;
    }

    @Override
    public E remove(int index) {

        checkIndex(index);

        E result = data[index];
        // 从 [index, size - 1] 闭区间内 ，所有的元素等于其后一位，也就是前移
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        if (size < (getCapacity()) / 4 && (getCapacity() >> 2) > 0)
            resize(getCapacity() >> 2);

        return result;
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

        int index = find(element);
        remove(index);
    }

    @Override
    public void swap(int index1, int index2) {

        E tmp  = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, getCapacity()));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
