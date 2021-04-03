package com.atzy.datastructure;

public class JosephuDemo {
    public static void main(String[] args) {
        LinkedListBoy.addNumBoy(5);
        LinkedListBoy.showBoy();
        LinkedListBoy.countBoy(1,2,5);
    }
}

/**
 * 小孩链表
 */
class LinkedListBoy{

    private static Boy first = new Boy(-1);

    /**
     * 给环形链表中添加指定数量的节点
     * @param num
     */
    public static void addNumBoy(int num){
        if(num < 1){
            System.out.println("输入的数字不合法~~~");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(curBoy);
            }else{
                boy.setNext(first);
                curBoy.setNext(boy);
            }
            curBoy = boy;

        }
    }

    /**
     * 遍历链表中的节点
     */
    public static void showBoy(){
        Boy helper = first;
        while (true){//因为是环形链表 所以下一个是头节点则说明结束
            System.out.println(helper.getNo());
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();

        }
    }

    /**
     * 让小孩节点出圈
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示圈中共有多少名小孩
     */
    public static void countBoy(int startNo,int countNum, int nums){
        //先对数据进行合法性校验
        if(first == null || startNo < 1 || countNum < 1){
            System.out.println("参数输入有误 , 请重新输入");
            return;
        }

        //1.先建立一个辅助指针 帮助我们后面的删除
        Boy helper = first;
        while (helper.getNext() != first){
            helper = helper.getNext();
        }
        System.out.println(helper);
        //让当前first 和helper指针指向startNo的小孩
        for (int i =1;i<startNo;i++){
            helper = helper.getNext();
            first = first.getNext();
        }
        System.out.println(first);
        System.out.println(helper);
        //2.开始数数
        while (helper != first){
            //开始数到需要删除的节点
            for (int i = 1; i < countNum; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            //移除当前节点
            System.out.println("当前出圈顺序 : " + first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first);
        System.out.println(helper);
    }
}

class Boy{
    private Integer no;
    private Boy next;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(Boy next) {
        this.next = next;
    }

    public Boy(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
