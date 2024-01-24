package com.work1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class EquipTest2 {
    @Autowired
    private Player player;

    @Autowired
    @Qualifier("ring")
    private Equip equip;
    @Test
    public void test1(){
        Equip ring = player.getRing();
        System.out.println(ring);
        player.updateEquip(equip);
        System.out.println(player);
    }
}