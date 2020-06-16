package com.YEW;

/**
 * @description:
 * @author: 86177
 * @date: Created in 2020/6/16 11:56
 * @version: 1.0
 * @modified By:
 */
public class Vampire extends Monster {
    private int blood;// 吸血系数

    public Vampire() {
    }

    public Vampire(int t) {
        switch (t) {
            case 1:
                this.setType("青铜吸血鬼");
                this.setLife(70);
                this.setAttack(6);
                this.setDefend(2);
                this.setMiss(20);
                this.blood=30;
                break;
            case 2:
                this.setType("白银吸血鬼");
                this.setLife(80);
                this.setAttack(10);
                this.setDefend(4);
                this.setMiss(30);
                this.blood=40;
                break;
            case 3:
                this.setType("黄金吸血鬼");
                this.setLife(90);
                this.setAttack(12);
                this.setDefend(6);
                this.setMiss(60);
                this.blood=50;
                break;
            case 4:
                this.setType("铂金吸血鬼");
                this.setLife(100);
                this.setAttack(18);
                this.setDefend(10);
                this.setMiss(70);
                this.blood=60;
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        this.setLive(true);
        this.setMaxLife(this.getLife());        // maxLife=life;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    } 	// 吸血

    public void getBlood(int loseLife) {
        System.out.println("[+]" + ":吸血成功！");
        int getBlood = loseLife * blood / 100;
        this.setLife(this.getLife() + getBlood);
        if (this.getLife() >= this.getMaxLife()) {
            this.setLife(this.getMaxLife());			// life=maxLife;
        }
    }


}
