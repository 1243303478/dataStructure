package com.atzy.datastructure.recursion;

public class Queen8 {

    int max = 8; //棋盘数量

    //使用一个二维数组保存解开题的思路
    int[] arr = new int[max];

    /**
     * 一共有count种解法
     */
    int count = 0;

    public static void main(String[] args) {
        //测试一下
        Queen8 queen = new Queen8();
        queen.putQueen(0); //从第0行开始放置
        System.out.printf("一共有%d种解法", queen.count);
    }

    /**
     * 给指定位置上放置旗子
     * @param n 在第n行上放置
     * @return boolean
     */
    public void putQueen(int n){
        if(n == max){ //n等于最大值 说明所有旗子已经摆放在自己的位置
            print();
            return ;
        }
        //依次放入皇后 并查看是否冲突
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(check(n)){
                putQueen(n+1);
                //如果不冲突 则继续安放下一行的棋子位子
            }
            //如果冲突了 会自动循环 找下一个不冲突的位置
            //会在同一列上 一直找到一个可以放置的位置
        }
    }

    /**
     * 校验在棋盘上是否合理
     * @param n 棋盘上的位置 arr[n]
     */
    public boolean check(int n){
        for (int i = 0; i < n; i++) {
            /**
             * arr[0] = 1 arr[1] = 0
             *
             * 1 1 0 0 0 0 0 0
             *
             * n = 1 i = 0
             * arr[1 - 0] arr[0] = 1
             * arr[1] - arr[0] = 1
             */
            if (arr[i] == arr[n] || Math.abs(arr[n]- arr[i]) == Math.abs(n-i)){
                //说明在同一行上 或者是在同一斜线上
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历输出解题的棋盘位置
     */
    public void print(){
        count++;
        //输出皇后信息
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
