package com.YEW;

/**
 * @description:
 * @author: 86177
 * @date: Created in 2020/6/16 12:15
 * @version: 1.0
 * @modified By:
 */

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class Game {

    Player h;

    List<Monster> monsters = new ArrayList<Monster>();



    public Game(String name, String weapon) {

        h = new Player(name, weapon);

        monsters.add(new LittleMonster(1));

        monsters.add(new LittleMonster(2));

        monsters.add(new LittleMonster(3));



        monsters.add(new Vampire(1));

        monsters.add(new Vampire(2));

        monsters.add(new Vampire(4));

        monsters.add(new Vampire(1));



    }



    public void start() {

        // 死循环 实现游戏自动打

        while (true) {

            // 生成一个随机数 0-5

            int ran = GameUtil.getNumber(0, monsters.size());

            int choice=menu();
            if (choice == 1){
                h.fight(monsters.get(ran));
            }else if (choice == 2){
                continue;
            }else {
                break;
            }
            // 玩家死亡 游戏结束

            if (!h.isLive()) {

                System.out.println("游戏失败，再来一次");

                h.setLife(100);
                h.setLive(true);

                end();
                break;

            }

            // 如果当前对手是死亡

            if (!monsters.get(ran).isLive()) {
                // 将此怪物移除集合
                monsters.remove(monsters.get(ran));

            }

            // 判断集合大小 如果小于等于0 证明所有的怪物都死亡了

            if (monsters.size() <= 0) {
                System.out.println("恭喜您，赢得胜利！");

                end();
                break;

            }

            try {

                System.out.println("-----------正在寻找对手--------------");

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    }



    public void end() {

        System.out.println("Game Over!!!");

    }

    public int menu(){
        System.out.println("请选择：1.开始战斗吧！\t2.这个怪物太厉害了，换一个打\t3.退出游戏\n");
        Scanner input=new Scanner(System.in);
        return input.nextInt();

    }

}
