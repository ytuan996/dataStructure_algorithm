package com.ytuan.java.data_structure.array;

public class Main {

    public static void main(String[] args) {

        Arrays_Impl<Integer> arr = new Arrays_Impl<>(10);

        for (int i = 0; i < 10; i++)
            arr.addLast(i);

        System.out.println(arr);

        arr.add(0, 100);
        System.out.println(arr);

//        arr.addFirst(-1);
//        System.out.println(arr);

//        arr.remove(1);
//        System.out.println(arr);

//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
    }
}
