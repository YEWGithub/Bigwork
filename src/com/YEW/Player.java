package com.YEW;

/**
 * @description:
 * @author: 86177
 * @date: Created in 2020/6/16 12:08
 * @version:
 * @modified By:
 */

//玩家

public class Player {
    private String name;

    private String weapon;// 武器
    private int life;// 生命值
    private boolean isLive;// 是否活着
    private int attack;// 攻击力
    private int defend;// 防御力
    private int exp;// 经验值
    private int level;// 等级
    private int maxLife;// 最大生命值
    private int miss;// 躲避系数

    int times;

    public Player() {

    }

    public Player(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;

        setLife(100);
        setLive(true);
        setAttack(40);
        setDefend(3);
        setLevel(1);
        setExp(0);
        setMaxLife(getLife());
        setMiss(20);
    }

    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getWeapon() {

        return weapon;

    }



    public void setWeapon(String weapon) {

        this.weapon = weapon;

    }



    public int getLife() {

        return life;

    }



    public void setLife(int life) {

        this.life = life;

    }



    public boolean isLive() {

        return isLive;

    }



    public void setLive(boolean isLive) {

        this.isLive = isLive;

    }



    public int getAttack() {

        return attack;

    }



    public void setAttack(int attack) {

        this.attack = attack;

    }



    public int getDefend() {

        return defend;

    }



    public void setDefend(int defend) {

        this.defend = defend;

    }



    public int getExp() {

        return exp;

    }



    public void setExp(int exp) {

        this.exp = exp;

    }



    public int getLevel() {

        return level;

    }



    public void setLevel(int level) {

        this.level = level;

    }



    public int getMaxLife() {

        return maxLife;

    }



    public void setMaxLife(int maxLife) {

        this.maxLife = maxLife;

    }



    public int getMiss() {

        return miss;

    }



    public void setMiss(int miss) {

        this.miss = miss;

    }



    public int getTimes() {

        return times;

    }



    public void setTimes(int times) {

        this.times = times;

    }



    // 打怪

    public void fight(Monster e) {
        if (!isLive || !e.isLive()) {
            return;
        }
        System.out.println("[-]" + name + "挥舞着" + weapon + "杀向" + e.getType());
        e.injured(this);
    }

    // 死亡

    public void dead() {
        System.out.println("[-]" + name + "你挂了");
        isLive = false;
    }



    // 显示状态

    public void show() {
        System.out.println(name + "生命值是：" + life + "\n攻击力：" + attack + "\t防御力：" + defend+"\t躲避系数："+miss);
    }



    // 升级方法

    public void addLevel() {
        attack += 5;
        defend += 2;
        miss += 5;
        level++;
        // 满血
        life = maxLife;
        System.out.println("[-]" + "升级成功！当前的等级是：" + level);
        show();
    }

    public void addExp(int life) {

        exp += life-50;
        int needExp = 0;

        for (int i = 1; i < level; i++) {
            needExp += i * 50;
        }

        if (exp > needExp) {
            addLevel();
        }

    }


    public void injured(Monster monster) {
        int n = GameUtil.getNumber(1, 101);

        if (n < miss) {
            System.out.println("[-]" + "躲避成功");
            show();
            return;
        }

        System.out.println("[-]" + name + ": 掉血了");
        int loseLife = GameUtil.getLoseLife(monster.getAttack(), defend);
        life -= loseLife;

        if (life < 0) {
            life = 0;
            dead();
        }
        if (monster.getType()=="青铜吸血鬼" || monster.getType()=="白银吸血鬼" || monster.getType()=="黄金吸血鬼" || monster.getType()=="铂金吸血鬼"){
            Vampire v=new Vampire();
            v.getBlood(loseLife);
        }
        show();
    }
}

