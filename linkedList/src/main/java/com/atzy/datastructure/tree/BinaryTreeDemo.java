package com.atzy.datastructure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(3);

        node1.left = node2;
        node3.left = node4;
        root.left = node1;
        root.right = node3;

        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.preOrder(root);
        binaryTree.fixOrder(root);

        System.out.println("查找节点" + "15 :结果：");
        binaryTree.preSearch(root,15);
    }
}

class BinaryTree{
    /**
     * 调用前序遍历
     * @param root
     */
    public void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("当前节点为空");
        }
    }

    /**
     * 调用中序遍历
     * @param root
     */
    public void fixOrder(Node root){
        if(root != null){
            root.inFixOrder();
        }else{
            System.out.println("当前节点为空");
        }
    }

    /**
     * 调用后序遍历
     * @param root
     */
    public void postOrder(Node root){
        if(root != null){
            root.postOrder();
        }else{
            System.out.println("当前节点为空");
        }
    }

    /**
     * 调用前序查找
     * @param root
     */
    public void preSearch(Node root,int no){
        if(root != null){
            System.out.println(root.preSearch(no));
        }else{
            System.out.println("当前节点为空");
        }
    }
}

class Node{
    int no;
    Node left;
    Node right;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        Node node = this;

        /**
         * 输出当前节点
         */
        System.out.println("当前节点:"+node.no);

        /**
         * 遍历当前节点的左子节点
         */
        if(node != null && node.left != null){
            node.left.preOrder();
        }

        /**
         * 遍历当前节点的右子节点
         */
        if(node != null && node.right != null){
            node.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void inFixOrder(){
        Node node = this;
        if(node != null && node.left != null){
            node.left.inFixOrder();
        }

        System.out.println("当前节点：" + node.no);

        if (node != null && node.right != null){
            node.right.inFixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        Node node = this;
        if(node != null && node.left != null){
            node.left.inFixOrder();
        }

        if (node != null && node.right != null){
            node.right.inFixOrder();
        }

        System.out.println("当前节点：" + node.no);
    }

    /**
     * 前序查找
     * @param no
     * @return
     */
    public boolean preSearch(int no){
        Node node = this;

        if(node.no == no){return true;}

        if(node.left != null){
            return node.left.preSearch(no);
        }

        if(node.right != null){
            return node.right.preSearch(no);
        }

        return false;
    }
}
