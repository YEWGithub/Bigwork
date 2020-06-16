package com.YEW;

/**
 * @description:
 * @author: 86177
 * @date: Created in 2020/6/16 12:11
 * @version: 1.0
 * @modified By:
 */



public class LittleMonster extends Monster{

    public LittleMonster(int t) {
        switch (t) {
            case 1:

                this.setType("青铜小怪");

                this.setLife(70);

                this.setAttack(8);

                this.setDefend(2);

                this.setMiss(20);

                break;
            case 2:

                this.setType("白银小怪");

                this.setLife(80);

                this.setAttack(12);

                this.setDefend(4);

                this.setMiss(30);

                break;
            case 3:
                this.setType("黄金小怪");

                this.setLife(90);

                this.setAttack(16);

                this.setDefend(6);

                this.setMiss(60);

                break;
            case 4:

                this.setType("铂金小怪");

                this.setLife(100);

                this.setAttack(20);

                this.setDefend(10);

                this.setMiss(70);

                break;
            case 5:

                this.setType("钻石小怪");

                this.setLife(110);

                this.setAttack(28);

                this.setDefend(12);

                this.setMiss(70);

                break;
            default:

                System.out.println("输入错误");

                break;

        }

        this.setLive(true);

        this.setMaxLife(this.getLife());

        //maxLife=life;

    }

}





