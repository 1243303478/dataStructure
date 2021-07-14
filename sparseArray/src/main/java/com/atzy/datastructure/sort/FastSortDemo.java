package com.atzy.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序算法 demo
 */
public class FastSortDemo {
    public static void main(String[] args) {
        int[] arr = {-8,3,0,-567,101,9};
        System.out.println("排序前~~~~~");
        System.out.println(Arrays.toString(arr));
        fastSort(arr,0,arr.length-1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序算法实现
     * @param arr 待排序的数组
     * @param left 从数组的左边第几个开始
     * @param right 从数组的右边第几个元素开始排序
     */
    private static void fastSort(int[] arr,int left,int right){
        int middle = arr[(left + right) / 2];
        int l = left;
        int r = right;

        //临时变量
        int temp = 0;
        //从中间开始找 左边的大于自己的数 右边小于自己的数 交换位置
        while (l < r){
            //从中间数的左边找 一直找到大于中间数的值
            while (arr[l] < middle){
                l += 1;
                /*temp = arr[middle + 1];
                arr[middle+1] = arr[l];
                arr[l] = temp;*/
            }
            //一直在中间值的右边找 找到小于当前数的才退出
            while (arr[r] > middle){
                r -= 1;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完发现arr[l] 与middle中间值相等 则后移一位
            if(arr[l] == middle){
                r-=1;
            }
            //如果交换完发现arr[r] 与middle中间值相等 则前移一位
            if(arr[r] == middle){
                l+=1;
            }
        }
        //如果左边边界 == 右边边界 必须l++ r-- 否则栈溢出
        if(l == r){
            l++;
            r--;
        }
        if(left<r){
            fastSort(arr,left,r);
        }
        if(right > l){
            fastSort(arr,l,right);
        }
    }
}
