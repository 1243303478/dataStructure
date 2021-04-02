package com.atzy.datastructure;

import java.util.Stack;

public class LinkedList2 {

    HeroNode2 head;

    public LinkedList2(HeroNode2 head) {
        this.head = head;
    }

    /**
     * 插入新的节点到链表尾部
     * @param newHeroNode
     */
    public void addNode(HeroNode2 newHeroNode){
        //先遍历所有节点信息
        //因为头结点不能动 所以用一个临时变量存储节点信息
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            temp = temp.next;
        }
        newHeroNode.pre = temp;
        temp.next = newHeroNode;
    }
    /**
     * 插入新的节点到链表尾部 [按顺序插入]
     * @param heroNode
     */
    public void addNodeOrder(HeroNode2 heroNode){
        //先遍历所有节点信息
        //因为头结点不能动 所以用一个临时变量存储节点信息
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            if(temp.next.no > heroNode.no){
                break;//下一节点编号比要插入的大 所以直接在当前节点插入
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("编号:%d 已存在链表中 插入失败\n",heroNode.no);
            return;
        }
        heroNode.next = temp.next;
        heroNode.pre = temp;
        temp.next = heroNode;
    }

    /**
     * 显示链表上的所有节点信息
     */
    public void list(){
        if(head.next == null){
            System.out.println("当前链表中无数据~~~");
            return;
        }
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

    /**
     * 根据指定的heroNode信息 修改对应编号的节点信息
     * @param newHeroNode
     * @return boolean
     */
    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("当前链表中无数据~~~");
            return;
        }
        boolean flag = false;
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            System.out.printf("没有找到%d编号的节点数据",newHeroNode.no);
        }
    }

    public void delete(HeroNode2 heroNode){
        if(head.next == null){
            System.out.println("当前链表中无数据~~~");
            return;
        }
        //删除对应的节点信息 将找到的节点的next往后移
        boolean flag = false;
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next.pre = temp.pre;
            temp.next = temp.next.next;//将找到的节点的上一节点的next指向需要删除节点的next
        }else{
            System.out.printf("没有找到%d编号的节点数据",heroNode.no);
        }
    }

    /**
     * 通过head头节点 获取单链中一共有多少个节点
     * @param head
     * @return
     */
    public static int getSize(HeroNode2 head){
        if(head.next == null){
            System.out.println("链表中无数据~~~");
            return 0;
        }
        HeroNode2 temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 新浪面试题 查询单链表中的 倒数第k个节点信息
     * 思路: 倒数第 2个 相当于总数量减2 遍历到这个节点
     *  10 - 2 = 8 等于第八个节点信息
     */
    public static HeroNode2 getLastNumNodeInfo(HeroNode2 head,int k){
        //头节点的下一个为空 说明链表是空
        if(head.next == null){
            return null;
        }
        HeroNode2 temp = head.next; //指向头节点下的 第一个真实节点
        int size = getSize(head);
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }
    /**
     * 单链表的反转 [腾讯面试题]
     * 画图在记事本
     */
    public static void reverseLikedList(HeroNode2 head){
        if(head.next == null){
            System.out.println("当前链表为空哦~~~~");
            return;
        }
        HeroNode2 temp = head.next;

        //定义一个新的节点
        HeroNode2 cur = null;
        HeroNode2 next = null;
        while (temp != null) {
            next = temp.next; //定义一个next 可以让循环知道下一次该指向的节点
            temp.next = cur;//让当前节点的next指向上一次遍历的节点 cur
            head.next = temp;//head的next永远指向最新遍历到的值
            cur = temp; //让当前节点等于现在已经修改过的节点 就不会有next了
            temp = next;//temp指向真正的下一个节点
        }
    }

    /**
     * 在不打乱数据结构的情况下 使链表反向输出出来结果
     * @param head
     */
    public static void reversePrint(HeroNode2 head){
        //利用java栈的特性来达到反向打印的需求
        //栈的先进后出特性
        if(head.next == null){
            System.out.println("当前数组为空哦~~~");
            return;
        }
        HeroNode2 temp = head.next;
        Stack<Integer> ints = new Stack<Integer>();
        while (temp != null){

            /**
             * 将当前链表的编号放入栈中
             */
            ints.push(temp.no);
            temp = temp.next;
        }
        //遍 历栈 打印栈中数据
        while (!ints.isEmpty()){//栈的最顶端不为空则继续遍历
            System.out.println(ints.pop());
        }
    }
}
