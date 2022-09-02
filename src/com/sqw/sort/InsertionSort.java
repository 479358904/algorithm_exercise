package com.sqw.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @Program: algorithm_exercise
 * @Description: 插入排序
 * 插入排序是一种从序列左端开始依次对数据进行排序的算法。在排序过程中，左侧的数据
 * 陆续归位，而右侧留下的就是还未被排序的数据。插入排序的思路就是从右侧的未排序区域内
 * 取出一个数据，然后将它插入到已排序区域内合适的位置上。
 * @Author: sqw
 * @Create: 2022-09-01
 */
public class InsertionSort {

    public static void main(String[] args) {

//        int[] arr = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        int[] arr = new int[1000000];
        for (int i = 1000000; i > 1; i--) {
            arr[i-1] = i-1;
        }
        System.out.println("=================================");
        System.out.println("开始排序时间：" + new Date());
        doInsertionSort(arr);
        System.out.println("结束排序时间：" + new Date());

//        System.out.println(Arrays.toString(arr));

    }


    private static void doInsertionSort(int[] arr) {
        // 插入排序，总共有k个元素，需要比较k轮，第 k 轮需要比较 k -1 次
        // 第一个元素已经完成排序，已经归好位,所以需要比较1-1=0次
        for (int i = 0; i < arr.length; i++) {
            // 每个元素都要与右边的元素进行逐个比较、交换
            // 第一个元素不需要比较
            if(i > 0) {
                // 从i的前一个元素开始为已经归位的区域
                int k = i;
                for (int j = i-1; j >= 0; j--) {
                    if(arr[k] < arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        k = j;
                    }
                }
            }
        }
    }
}
