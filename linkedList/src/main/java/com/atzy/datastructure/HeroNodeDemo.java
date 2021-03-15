package com.atzy.datastructure;

public class HeroNodeDemo {
    public static void main(String[] args) {
        HeroNode head = new HeroNode(0, "", ""); //头节点不需要存储什么信息 所以设空
        LinkedList list = new LinkedList(head);
        list.list();

        list.addNode(new HeroNode(1, "宋江", "及时雨"));
        list.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
        list.addNode(new HeroNode(3, "吴用", "智多星"));
        list.list();
        System.out.println("--------------分割线");
        list.update(new HeroNode(2, "小卢", "玉麒麟~~~~"));
        list.list();
        System.out.println("--------------分割线");
        list.delete(new HeroNode(1, "小卢", "玉麒麟~~~~"));
        list.list();

        System.out.println("--------------分割线 顺序插入");
        list.addNodeOrder(new HeroNode(4, "卢俊义", "玉麒麟"));
        list.list();
        list.addNodeOrder(new HeroNode(1, "宋江", "及时雨"));
        list.addNodeOrder(new HeroNode(2, "林冲", "豹子头"));
        list.addNodeOrder(new HeroNode(3, "吴用", "智多星"));
        System.out.println("最终结果-------------");
        list.list();

        System.out.println("链表的节点个数:");
        System.out.println(LinkedList.getSize(head));

        System.out.println("获取倒数第二个节点信息");
        System.out.println(LinkedList.getLastNumNodeInfo(head, 4));
    }
}

class LinkedList{
    HeroNode head;

    public LinkedList(HeroNode head) {
        this.head = head;
    }

    /**
     * 插入新的节点到链表尾部
     * @param newHeroNode
     */
    public void addNode(HeroNode newHeroNode){
        //先遍历所有节点信息
        //因为头结点不能动 所以用一个临时变量存储节点信息
        HeroNode temp = head;
        while (true){
            if(temp.next == null) {
                //说明链表已经遍历结束
                break;
            }
            temp = temp.next;
        }
        temp.next = newHeroNode;
    }
    /**
     * 插入新的节点到链表尾部 [按顺序插入]
     * @param heroNode
     */
    public void addNodeOrder(HeroNode heroNode){
        //先遍历所有节点信息
        //因为头结点不能动 所以用一个临时变量存储节点信息
        HeroNode temp = head;
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
        HeroNode temp = head;
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
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("当前链表中无数据~~~");
            return;
        }
        boolean flag = false;
        HeroNode temp = head;
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

    public void delete(HeroNode heroNode){
        if(head.next == null){
            System.out.println("当前链表中无数据~~~");
            return;
        }
        //删除对应的节点信息 将找到的节点的next往后移
        boolean flag = false;
        HeroNode temp = head;
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
    public static int getSize(HeroNode head){
        if(head.next == null){
            System.out.println("链表中无数据~~~");
            return 0;
        }
        HeroNode temp = head;
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
    public static HeroNode getLastNumNodeInfo(HeroNode head,int k){
        //头节点的下一个为空 说明链表是空
        if(head.next == null){
            return null;
        }
        HeroNode temp = head.next; //指向头节点下的 第一个真实节点
        int size = getSize(head);
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }
}