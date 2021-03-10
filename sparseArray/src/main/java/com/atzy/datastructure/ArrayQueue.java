package com.atzy.datastructure;

public class ArrayQueue {

    int front; //指向头部的指针

    int rear; //指向最后一个元素的指针

    int max_size; //队列的最大容量

    int[] arr; //真实数组

    /**
     * 初始化队列相关参数
     * @param max
     */
    public ArrayQueue(int max){
        max_size = max;
        arr = new int[max];
        front = -1;
        rear = -1;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("当前队列为空");
        }else{
            for (int data : arr) {
                System.out.printf("%d\n",data);
            }
        }
    }

    /**
     * 判断队列是否已满
     * @return boolean
     */
    public boolean isFull(){
        return rear == max_size -1;
    }

    /**
     * 判断队列是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 向队列中添加数据
     * @param  value
     */
    public void addQueue(int value){
        if(isFull()){ //当前指针指向最大值 队列已满了
            System.out.println("当前队列已满了,无法插入");
        }else{
            rear++;
            arr[rear] = value;
        }
    }

    /**
     * 从队列中 取出一条数据
     * @return int
     */
    public int popQueue(){
        if(isEmpty()){
            System.out.println("当前队列为空,没有数据可以取出");
            return -1;
        }
        front++;
        return arr[front];
    }

    /**
     * 获取当前队列中的第一条数据
     * @return int
     */
    /*public int headQueue(){
        if(isEmpty()){
            System.out.println("当前队列为空,没有数据可以取出");
            return -1;
        }
        return arr[front];
    }*/

}
