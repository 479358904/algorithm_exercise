package com.sqw.recursion;

/**
 * @Program: my_algorithm_exercise
 * @Description: 汉诺塔
 * @Author: sqw
 * @Create: 2022-05-19
 */
public class TowerofHanoi {

    /**
     * 1，先把n-1个圆盘从A借助C成功的移动到B
     * 2，然后再把第n个圆盘从A移动到C
     * 3，最后再把n-1个圆盘从B借助A成功的移动到C。
     *
     * 递归终止条件：是A柱子上只有一个圆盘的时候，我们直接把A 柱子上的圆盘移动到C柱子上即可
     */

    /**
     * @description: 表示的是把n个圆盘借助柱子B成功的从A移动到C
     * @param n
     * @param a
     * @param b
     * @param c
     * @return void
     */
    public void hanoi(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("从"+ a + "移动到" + c);
            return;
        }
        //表示先把n-1个圆盘从A借助C成功的移动到B
        hanoi(n-1,a,c,b);
        //把第n个圆盘从A移动到C
        System.out.println("从" + a + "移动到" + c);
        //表示最后再把n-1个圆盘从B借助A成功的移动到C
        hanoi(n-1,b,a,c);
    }

    public static void main(String[] args) {
        TowerofHanoi hannuota = new TowerofHanoi();
//        hannuota.hanoi(4,"a","b","c");
        hannuota.hanoi(8,"a","b","c");
    }
}
