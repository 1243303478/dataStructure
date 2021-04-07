package com.atzy.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序 交换法
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        /*int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前~~~~~~~");
        System.out.println(Arrays.toString(arr));
        shellSort2(arr);*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d H:m:s");

        System.out.println(format.format(date));

        shellSort2(arr);


        Date date2 = new Date();
        System.out.println(format.format(date2));
    }

    /**
     * 希尔排序算法
     * @param arr 待排序的数组
     */
    public static void shellSort(int[] arr){
        /**
         * 第一轮排序 将数组除以2 拆分为5组
         * 判断每组的两个元素哪个大 将大的移动到后面
         *
         *  [1,5,3,6,0,4,9,8,2,7]
         * 第二轮排序 将步长再除以2 等于2 分为2组 每组5个元素
         * [1, 5, 0, 6, 3, 4, 7, 2, 9, 8]
         */
        /**
         * 因为是第一轮排序 从5开始 每组两个元素
         */
        //通过推算得到规律
        int count = 0;
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
//            count++;
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0; j -= gap) {
                    if(arr[j] > arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            /*System.out.println("第"+count+"轮排序后~~~~");
            System.out.println(Arrays.toString(arr));*/
        }



        /**
         * 第二轮排序 每组5个元素
         */
        /*for (int i = 2; i < arr.length; i++) {
            for (int j = i-2; j >=0; j -= 2) {
                if(arr[j] > arr[j + 2]){
                    int temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("第2轮排序后~~~~");
        System.out.println(Arrays.toString(arr));

        *//**
         * 第三轮排序 只分为一组 遍历全部元素
         *//*
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0; j -= 1) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("第3轮排序后~~~~");
        System.out.println(Arrays.toString(arr));*/
    }

    /**
     * 希尔排序算法 - 移位法
     * @param arr 待排序的数组
     */
    public static void shellSort2(int[] arr){
        /**
         * 增量gap 并逐步缩小的增量
         * 通过gap分组 每次排序后 最小的值肯定会往前面移动
         * 然后使用简单插入排序 判断当前的值小于前面的值没有 如果小于则移动到小于的数的位置
         * 一直这样移动 最后元素就会到自己的位置 因为最后增量为1 每次循环都是前一个位置的比较
         */
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            //从第gap个元素 直接对所在元素进行插入排序
            for (int i = gap; i <arr.length; i++) {
                int j = i;
                int value = arr[j];
                //当前数 小于前面的数
                if(arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && value < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = value;
                }
            }
        }
      /*  System.out.println("排序后~~~");
        System.out.println(Arrays.toString(arr));*/
    }
}
