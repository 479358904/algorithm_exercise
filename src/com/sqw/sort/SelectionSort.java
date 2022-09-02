package com.sqw.sort;

import java.util.Arrays;

/**
 * @Program: algorithm_exercise
 * @Description: 选择排序
 * @Author: sqw
 * @Create: 2022-08-31
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2,6,34,57,8,9,10,32,56};
        doSelectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * @description: 选择排序就是重复“从待排序的数据中寻找最小值，将其与序列最左边的数字进行交换”
     * 这一操作的算法。在序列中寻找最小值时使用的是线性查找。
     * @param arr
     * @return void 
     * @Author: sqw on 2022/8/31 16:48
     */
    private static void doSelectionSort(int[] arr) {
        // 总共需要找n-1轮：寻找最小的数
        for (int i = 0; i < arr.length-1; i++) {

            int min = arr[i+1];
            int k = i+1;
            if(i < arr.length-2) {
                for (int j = i+2; j < arr.length; j++) {
                    if(arr[j] < min) {
                        min = arr[j];
                        k = j;
                    }
                }
            }
            //开始交换
            if(min < arr[i] ) {
                int temp = arr[i];
                arr[i] = min;
                arr[k] = temp;
            }

        }
    }

}
