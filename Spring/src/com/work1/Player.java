package com.work1;
public class Player { //���
    private Equip armet;//ͷ��
    private Equip loricae;//����
    private Equip boot;//ѥ��
    private Equip ring;//ָ��

    //����װ��
    public void updateEquip(Equip equip){
        if ("ָ��".equals(equip.getType())){
            System.out.println(ring.getName()+"����Ϊ"+equip.getName());
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