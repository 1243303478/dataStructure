package com.atzy.datastructure.recursion;

public class RecursionDemo {
    public static void main(String[] args) {
        //创建一个地图
        int[][] maps = new int[8][7];

        //将地图的第一行和最后一行设为墙壁
        for (int i = 0; i < maps[i].length; i++) {
            maps[0][i] = 1;
            maps[7][i] = 1;
        }

        //设置地图上下墙的位置
        for (int i = 0; i < maps.length; i++) {
            maps[i][0] = 1;
            maps[i][6] = 1;
        }

        //给地图中添加路障
        maps[4][1] = 1;
        maps[5][1] = 1;
        maps[5][2] = 1;

        //输出地图看看
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + "  ");
            }
            System.out.println();
        }
        //开始走迷宫
        setWay(maps,1,1);

        //输出结果看看
        System.out.println("--------------------分割线");
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] maps,int i ,int j){
        if(maps[6][5] == 2){
            //说明当前已经走到了终点
            return true;
        }else{
            if(maps[i][j] == 0){//说明当前这个位置还没有走过 可以走
                maps[i][j] = 2;
                //调用策略 使小球按照策略 下左右上的方向开始走
                if(setWay(maps,i+1,j)){
                    return true;
                }else if(setWay(maps,i,j-1)){
                    return true;
                }else if(setWay(maps,i,j+1)){
                    return true;
                }else if(setWay(maps,i-1,j)){
                    return true;
                }else {
                    //说明走到了死路 当前位置的数字为123
                    return false;
                }
            }else{
                return false; //当前位置不等于0 直接return false
            }
        }
    }
}
