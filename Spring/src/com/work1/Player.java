package com.work1;
public class Player { //玩家
    private Equip armet;//头盔
    private Equip loricae;//铠甲
    private Equip boot;//靴子
    private Equip ring;//指环

    //升级装备
    public void updateEquip(Equip equip){
        if ("指环".equals(equip.getType())){
            System.out.println(ring.getName()+"升级为"+equip.getName());
            this.ring = equip;
        }
    }
    public Equip getArmet() {
        return armet;
    }
    public void setArmet(Equip armet) {
        this.armet = armet;
    }
    public Equip getLoricae() {
        return loricae;
    }
    public void setLoricae(Equip loricae) {
        this.loricae = loricae;
    }

    public Equip getBoot() {
        return boot;
    }

    public void setBoot(Equip boot) {
        this.boot = boot;
    }

    public Equip getRing() {
        return ring;
    }

    public void setRing(Equip ring) {
        this.ring = ring;
    }

    public String toString() {
        return "Player{" +
                "\n  armet=" + armet +
                ",\n  loricae=" + loricae +
                ",\n  boot=" + boot +
                ",\n  ring=" + ring +
                "\n}";
    }
}