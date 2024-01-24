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
        //获取目标对象方法参数
        Object[] args = joinPoint.getArgs();
        // 使用数组
        List<Object> equips =  Arrays.asList(args);
        Object object = equips.get(0);
        Equip equip= (Equip) object;
        if(equip.getType().equals("指环")){
            System.out.println("获取传入目标方法的参数对象" + equip);
            String name = "紫色梦幻" + equip.getName();
            equip.setName(name);
            equip.setAttackPlus(equip.getAttackPlus()+6);
            equip.setDefencePlus(equip.getDefencePlus()+6);
//            System.out.println(equip.getAttackPlus());
            System.out.println("修改后的参数对象"+equip);
        }
        System.out.println("----------------------------------------");
    }
}