package com.sqw.sort;

import java.util.Arrays;

/**
 * @Program: algorithm_exercise
 * @Description: 冒泡排序
 * @Author: sqw
 * @Create: 2022-08-31
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2,6,34,57,8,9,10,32,11};
        doBubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * @description: 冒泡排序方法
     * @param arr
     * 冒泡排序就是重复“从序列右边开始比较相邻两个数字的大小，再根据结果交换两个数字
     * 的位置”这一操作的算法。在这个过程中，数字会像泡泡一样，慢慢从右往左“浮”到序列的
     * 顶端，所以这个算法才被称为“冒泡排序”。
     * @return void
     */
    private static void doBubbleSort(int[] arr) {
        // 有n个元素，需从n轮比较
        for (int i = 0; i < arr.length; i++) {
            // 每一轮从最右边开始
            for (int j = arr.length - 2; j >= i; j--) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
