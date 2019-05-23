package com.ytuan.java.data_structure.map;

import com.ytuan.java.data_structure.FileOperation;

import java.util.ArrayList;

public class Main {

    private static double testMap(Map_interface<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // 如果文件找不到就换成本机的绝对路径
        String filename = "/Users/ytuan/java_idea/dataStructure_algorithm/dataStructure_algorithm/src/main/java/com/ytuan/java/data_structure/pride-and-prejudice.txt";

        BinarySearchTreeMap_Impl<String, Integer> bstMap = new BinarySearchTreeMap_Impl<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap_Impl<String, Integer> linkedListMap = new LinkedListMap_Impl<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

    }
}

