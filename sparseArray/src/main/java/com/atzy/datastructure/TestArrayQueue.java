package com.atzy.datastructure;

import java.util.Scanner;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("1:showQueue");
            System.out.println("2:addQueue");
            System.out.println("3:popQueue");
            System.out.println("0:getSize");
            System.out.println("4:exit");
            int next = scanner.nextInt();
            switch (next){
                case 1:
                    queue.showQueue();
                    break;
                case 2:
                    System.out.println("请输入要添加进队列的值");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 3:
                    int res = queue.popQueue();
                    System.out.println("取出的值是：" + res);
                    break;
                case 4:
                    loop = false;
                    break;
                case 0:
                    int length = queue.getSize();
                    System.out.println("队列当前有效个数：" + length);
            }
        }
    }
}
