package com.ytuan.java.data_structure.queue;

import java.util.Random;

/**
 * 测试普通数组和循环数组实现队列的性能
 */
public class Main {

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue_interface<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 10000000;

//        ArrayQueue_Impl<Integer> arrayQueue = new ArrayQueue_Impl<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");
//
//        LoopArrayQueue_Impl<Integer> loopQueue = new LoopArrayQueue_Impl<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");

//        Queue_interface<Integer> linkedListQueue_ = new LinkedListQueue_Impl<>();
//        double time3 = testQueue(linkedListQueue_, opCount);
//        System.out.println("LoopQueue, time: " + time3 + " s");

        Queue_interface<Integer> linkedListQueue_ = new ListNodeQueue_Impl<>();
        double time3 = testQueue(linkedListQueue_, opCount);
        System.out.println("LoopQueue, time: " + time3 + " s");
    }
}
