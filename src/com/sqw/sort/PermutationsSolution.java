package com.sqw.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: algorithm_exercise
 * @Description: 排列组合
 * @Author: sqw
 * @Create: 2022-05-31
 */
public class PermutationsSolution {

//    public static void permutations(int[] arrays, int n) {
//        //终止条件
//        if( arrays.length == 1) {
//            System.out.println(arrays[0]);
//            return;
//        }
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.println(arrays[i]);
////            permutations()
//        }
//
//    }

    public static void permutations(List<Integer> arrays) {
        //终止条件
        if( arrays.size() == 1) {
            System.out.print(arrays.get(0));
            System.out.println(";");
            return;
        }
        for (int i = 0; i < arrays.size(); i++) {
            System.out.print(arrays.get(i));
            System.out.print(",");
            List cloned_list = new ArrayList(arrays);
            cloned_list.remove(i);
            permutations(cloned_list);
        }

    }


    public static void main(String[] args) {
        List original = new ArrayList();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        permutations(original);
//        List cloned_list = new ArrayList(original);
//        original.remove(1);
//        System.out.println(original);
//        System.out.println(cloned_list);
    }

}
