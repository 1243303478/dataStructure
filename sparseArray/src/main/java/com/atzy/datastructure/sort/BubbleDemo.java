package com.atzy.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleDemo {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,-10,-2};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d H:m:s");

        System.out.println(format.format(date));

        bubbleSort(arr);


        Date date2 = new Date();
        System.out.println(format.format(date2));

        //定义一个辅助变量
        /*System.out.println("交换后的数组");
        System.out.println(Arrays.toString(arr));*/

        //因为遍历后 最后一个元素相对于是最大的了 所以不用遍历到他了
        /*for (int j = 0; j < arr.length -1 -1 ; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length -1 -2 ; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("交换后的数组");
        System.out.println(Arrays.toString(arr));*/
    }

    /**
     * 加上flag 13秒
     * 不加上12秒？
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false; //定义一个flag 判断当前是否被排序了 没有的话提前退出排序
        for (int i = 0; i < arr.length; i++) {
            //使用减i来降低循环次数
            for (int j = 0; j < arr.length -i - 1 ; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                //提前退出循环
                break;
            }else{
                flag = false;
            }
        }
    }
}
