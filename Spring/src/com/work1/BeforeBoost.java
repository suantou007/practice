package com.work1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class BeforeBoost {
    @Pointcut("execution(* com.work1.Player.updateEquip(..))")
    public void myPointCut(){

    }
    @Before("myPointCut()")
    public void ringBeforeAdvice(JoinPoint joinPoint){
        //��ȡĿ����󷽷�����
        Object[] args = joinPoint.getArgs();
        // ʹ������
        List<Object> equips =  Arrays.asList(args);
        Object object = equips.get(0);
        Equip equip= (Equip) object;
        if(equip.getType().equals("ָ��")){
            System.out.println("��ȡ����Ŀ�귽���Ĳ�������" + equip);
            String name = "��ɫ�λ�" + equip.getName();
            equip.setName(name);
            equip.setAttackPlus(equip.getAttackPlus()+6);
            equip.setDefencePlus(equip.getDefencePlus()+6);
//            System.out.println(equip.getAttackPlus());
            System.out.println("�޸ĺ�Ĳ�������"+equip);
        }
        System.out.println("----------------------------------------");
    }
}