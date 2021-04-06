package com.atzy.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortDemo {
    public static void main(String[] args) {
        /*int[] arr = {-1,-3,5,2,0,9};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));*/
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d H:m:s");

        System.out.println(format.format(date));

        insertSort(arr);

        Date date2 = new Date();
        System.out.println(format.format(date2));
    }

    /**
     * 插入排序
     * @param arr 需要排序的数组
     */
    private static void insertSort(int[] arr) {
        int insertIndex = 0; //即是当前arr[1]前面一个数的下标
        int insertVal = 0;
        for (int i = 1; i <arr.length; i++) {
            insertIndex = i -1; //即是当前arr[1]前面一个数的下标
            insertVal = arr[i];
            /**
             *  给insertValue 找的需要插入的位置
             *  1.保证insertIndex下标不越界
             *  2.如果当前数小于前面这个数 则把这个树插入到这个数的前面
             *  3.讲insertIndex后移
             */
            while (insertIndex >=0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];//arr[1]的前一个数 arr[0]比arr[1]小 所以让 arr[1] = arr[0]
                insertIndex--; //因为前一个数小 所以继续减1
            }
            /**
             * 当前下标被修改过后 在进行修改当前下标的值
             */
            if(i - 1 != insertIndex){
                arr[insertIndex + 1] = insertVal; //在当前数后面插入当前需要插入的数 arr[0]后面arr[1] = 1
                /*System.out.println("第"+i+"轮排序~~~");
                System.out.println(Arrays.toString(arr));*/
            }
        }
        /*insertIndex = 2 -1; //即是当前arr[1]前面一个数的下标
        insertVal = arr[2];
        while (insertIndex >=0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--; //将需要插入的下标前移 下面插入的时候再+1 就修改了前一个数
        }
        arr[insertIndex + 1] = insertVal; //在当前下标后面插入当前需要插入的数
        System.out.println("第2轮排序~~~");
        System.out.println(Arrays.toString(arr));

        insertIndex = 3 -1; //即是当前arr[1]前面一个数的下标
        insertVal = arr[3];
        while (insertIndex >=0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--; //将需要插入的下标前移 下面插入的时候再+1 就修改了前一个数
        }
        arr[insertIndex + 1] = insertVal; //在当前下标后面插入当前需要插入的数
        System.out.println("第3轮排序~~~");
        System.out.println(Arrays.toString(arr));

        insertIndex = 4 -1; //即是当前arr[1]前面一个数的下标
        insertVal = arr[4];
        while (insertIndex >=0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--; //将需要插入的下标前移 下面插入的时候再+1 就修改了前一个数
        }
        arr[insertIndex + 1] = insertVal; //在当前下标后面插入当前需要插入的数
        System.out.println("第4轮排序~~~");
        System.out.println(Arrays.toString(arr));*/
    }
}
