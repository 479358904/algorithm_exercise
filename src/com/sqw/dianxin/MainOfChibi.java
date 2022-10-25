package com.sqw.dianxin;

import java.util.*;
/**
 * @description: 电信的一个火烧赤壁的题
 * @param null
 * @return null 
 * @Author: sqw on 2022/10/25 16:33
 */

public class MainOfChibi {


    public static void main(String[] args) {
        int[][] chips = {{1,2,3},{4,5,6},{7,8,9}};
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            String str = String.valueOf(n);
            int[] arr = new int[str.length()];
            if(arr.length <7) {
                System.out.println("drew");
            } else {
                for (int i = 0; i < str.length(); i++) {
                    // 遍历str将每一位数字添加如intArray
                    Character ch = str.charAt(i);
                    arr[i] = Integer.parseInt(ch.toString());
                }
                List<Integer> returnList = fight(chips, arr);
                // 将数组排序，从小到大
                Collections.sort(returnList);
                if(returnList.size() <3) {
                    System.out.println("cao wins");
                } else if(HuangIsWin(chips,returnList)) {
                    System.out.println("huang wins");
                } else {
                    System.out.println("cao wins");
                }
            }
        }
    }


    public static List fight(int[][] chips,int[] arr)  {
        List<Integer> resultList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            // 攻
            if(i%2 == 0) {
                resultList.add(arr[i]);
                // 获取元素的下下标
                int[] indexs = indexOfChip(chips,arr[i]);
                if(indexs[0]>0 && indexs[1] >0) {
                    resultList.add(chips[indexs[0]-1][indexs[1]-1]);
                }
            } else {
                //守
                // 获取迭代器
                Iterator<Integer> it = resultList.iterator();
                while(it.hasNext()){
                    Integer obj = it.next();
                    if(obj == arr[i]){
                        it.remove();
                    }
                }
            }
        }
        return resultList;
    }

    public static boolean HuangIsWin(int[][] chips, List<Integer> list){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int oblCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] curIndexs = indexOfChip(chips,list.get(i));
            rowSet.add(curIndexs[0]);
            colSet.add(curIndexs[1]);
            if(curIndexs[0] == curIndexs[1]) {
                oblCount ++;
            }
        }

        if((rowSet.size()-list.size()) >= 2 || (colSet.size()-list.size()) >= 2 || oblCount >= 3) {
            return true;
        }
        return false;
    }
    public static int[] indexOfChip(int[][] chips, int n) {
        int[] resultIndex = new int[2];
        int i = (n-1) / chips[0].length;
        int j = (n % chips[0].length) == 0 ? chips[0].length-1 : n % chips[0].length-1;
        resultIndex[0] = i;
        resultIndex[1] = j;
        return resultIndex;
    }
}
