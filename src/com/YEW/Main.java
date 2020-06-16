package com.YEW;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        System.out.println("请输入玩家姓名：");
        String name = s.next();
        System.out.println("请输入玩家武器:");
        String w = s.next();
        Game g = new Game(name, w);
        System.out.println("是否开始游戏？[Y][N]");
        String f = s.next();
        if (f.equals("Y") || f.equals("y")) {
            g.start();
        } else {
            System.out.println("结束");
        }
    }
}
