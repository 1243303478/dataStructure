package com.atzy.datastructure;

public class SparseArray {

    public static void main(String[] args) {
        //建一个11*11的地图
        int sparse_array1[][] = new int[11][11];

        sparse_array1[1][2] = 1;
        sparse_array1[2][3] = 2;
        sparse_array1[4][3] = 2;

        //循环输出查看当前默认值
        for (int[] row : sparse_array1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //找到每个不等于0的值
        int sum = 0;
        for (int[] row : sparse_array1) {
            for (int data : row) {
                if (data != 0){
                    sum++;
                }
            }
        }

        //建立稀疏数组
        int sparse_array2[][] = new int[sum+1][3];
        sparse_array2[0][0] = sparse_array1.length;
        sparse_array2[0][1] = sparse_array1[1].length;
        sparse_array2[0][2] = sum;

        int count = 0;
        for (int i = 0; i <sparse_array1.length; i++) {
            for (int j = 0; j < sparse_array1[i].length; j++) {
                if (sparse_array1[i][j] != 0){
                    count++;
                    sparse_array2[count][0] = i;
                    sparse_array2[count][1] = j;
                    sparse_array2[count][2] = sparse_array1[i][j];
                }
            }
        }

        //循环遍历稀疏数组
        System.out.println("稀疏数组中的值~~~~~~~~~~");
        for (int[] row : sparse_array2) {
            System.out.printf("%d\t%d\t%d\t",row[0],row[1],row[2]);
            System.out.println();
        }

        //遍历稀疏数组 恢复成最初的二维数组
        int sparse_array3[][] = new int[11][11];
        for (int i = 1; i < sparse_array2.length; i++) {
            sparse_array3[sparse_array2[i][0]][sparse_array2[i][1]] = sparse_array2[i][2];
        }
        System.out.println("稀疏数组转换原数组~~~~~~~~~~");
        for (int[] row : sparse_array3) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
