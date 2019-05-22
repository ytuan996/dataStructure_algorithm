package com.ytuan.java.data_structure.stack;

public class Main {

    public static void main(String[] args) {

        Stack_interface<Integer> stack = new LinkedListStack_Impl<>();
        //Stack_interface<Integer> stack = new ArrayStack_Impl<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
