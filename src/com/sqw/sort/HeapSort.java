package com.sqw.sort;

import java.util.Arrays;

/**
 * @Program: algorithm_exercise
 * @Description: 堆排序
 * @Author: sqw
 * @Create: 2022-09-01
 */
@SuppressWarnings({"all"})
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,6,34,57,8,9,10,32,11};

        doHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void doHeapSort(int[] arr) {
        // 首先创建堆，堆初始堆进行调整，调整成一个大顶堆
        // 1、计算父节点的个数(根据堆的特性和排列顺序)
        // 节点数-父节点数：1-0 2-1 3-1 4-2 5-2 -6-3 7-3 8-4
        //以此类推，有n个节点时，总共有n/2个父节点，但是数组下标是从0开始，所以父节点的最大下标为(arr.length/2)-1
        for(int i= (arr.length/2)-1;i >= 0;i--) {
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            // 为什么从0开始？
            // 因为在第一次构建大顶堆后让堆顶元素和末尾元素进行交换
            // 而对于其他的非叶子结点所对应的子树都是大顶堆就无需调整，
            // 只需要堆顶元素(下标为0的非叶子结点)的子树调整成大顶堆
            adjustHeap(arr, 0, j);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        // 假如父节点所在的数组的下标为k，则左孩子的下标值为lChild=2*k+1，右孩子的下标值为rChild = lChild + 1
        // 如果是第一次构建时，不需要循环，因为是从最下面的元素构建大顶堆的
        // 但是当从堆中取走根节点后，需要一直往下与子树比较，所以需要循环
        for (int lChild = 2*parent + 1; lChild < length; lChild = lChild*2 +1) {

            int rChild = lChild+ 1;
            // 要先判断rChild < length，即判断有没有右孩子，不然会下标超出范围
            if(rChild < length && arr[lChild] < arr[rChild]) {
                // 如果右孩子比左孩子大，那就将lChild换成rChild的小标，后面统一用lChild进行处理
                lChild = rChild;
            }
            if(arr[lChild] > temp) {// 如果子节点大于父节点
                // 先把较大的赋给父节点，但是先不需要把父节点赋给子节点，因为还需要继续操作子树
                arr[parent] = arr[lChild];
                // 继续对子树进行操作
                parent = lChild;
            } else {
                // 子树已经是大顶堆了
                break;
            }
        }
        // 此时的parent已经是最终temp改在的位置
        arr[parent] = temp;
    }
}
