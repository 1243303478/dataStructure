package com.atzy.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        /*int[] arr = {101,34,119,1};
        System.out.println("排序前~~~");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后~~~~");
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d H:m:s");

        System.out.println(format.format(date));

        selectSort(arr);


        Date date2 = new Date();
        System.out.println(format.format(date2));
    }

    /**
     * 选择排序算法 平均耗时 : 2s
     * @param arr
     */
    private static void selectSort(int[] arr){
        //从下方的案例中找出了规律 
        int minIndex = 0;
        int min = arr[0];
        /**
         * 排序因为最后一个元素到最后一次排序前已经定好位置了 所以不用多循环一次
         */
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = 0;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                /**
                 * 如果遍历到的值比当前拿到的值还小 则使用这个值来作为最小值
                 */
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(min != arr[i]){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

        /*minIndex = 1;
        min = arr[1];
        /**
         * 排序因为最后一个元素到最后一次排序前已经定好位置了 所以不用多循环一次

        for (int j = 1; j < arr.length -1; j++) {
            /**
             * 如果遍历到的值比当前拿到的值还小 则使用这个值来作为最小值

            if(arr[j] < min){
                min = arr[j];
                minIndex = j;
            }
        }
        if(min != arr[1]){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }*/
    }
}
