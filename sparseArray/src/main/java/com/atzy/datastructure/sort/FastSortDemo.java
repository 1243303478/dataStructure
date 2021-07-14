package com.atzy.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FastSortDemo {
    public static void main(String[] args) {
//        int[] arr = {-3,-567,0,639,33,12};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d H:m:s");

        System.out.println(format.format(date));

        fastSort(arr,0,arr.length-1);


        Date date2 = new Date();
        System.out.println(format.format(date2));


        /*System.out.println("排序前---="+ Arrays.toString(arr));
        fastSort(arr,0,arr.length-1);

        System.out.println("排序后----="+Arrays.toString(arr));*/
    }

    /**
     *  快速排序算法
     * @param arr 待排序的数组
     * @param left
     * @param right
     */
    private static void fastSort(int[] arr,int left,int right){
        int middle = arr[(left+right)/2];
        int l = left;
        int r = right;

        int temp = 0;
        while (l<r){
            //找到左边比自己大的值
            while ( arr[l] < middle){
                l++;
            }
            while ( arr[r] > middle){
                r--;
            }
            if(l >= r){
                break;
            }
            //交换两个值的位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完后如果当前值等于中间值 则后移或前移一位
            if(arr[l] == middle){
                r-=1;
            }
            if(arr[r] == middle){
                l+=1;
            }
        }
        //递归左边的数
        if(l == r){
            l += 1;
            r -= 1;
        }
        if (left < r){
            fastSort(arr,left,r);
        }
        if(right > l){
            fastSort(arr,l,right);
        }
    }
}
