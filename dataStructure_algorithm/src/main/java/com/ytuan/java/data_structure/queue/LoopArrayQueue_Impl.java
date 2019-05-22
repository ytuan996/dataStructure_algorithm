package com.ytuan.java.data_structure.queue;

public class LoopArrayQueue_Impl<E> implements Queue_interface<E> {

    private E data[];

    private int front, tail;

    private int size;

    public LoopArrayQueue_Impl(int capacity) {

        this.data = (E[]) new Object[capacity + 1];

        this.front = this.tail = 0;

        this.size = 0;
    }

    public LoopArrayQueue_Impl() {

        this(8);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {

        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {

        if ((tail + 1) % data.length == front)
            resize(data.length + (data.length >> 1));

        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {

        E newData[] = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty!!!");

        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size < getCapacity() / 4 && getCapacity() >> 2 > 0)
            resize(getCapacity() >> 2);

        return result;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("the queue is Empty!!!");

        return data[front];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
