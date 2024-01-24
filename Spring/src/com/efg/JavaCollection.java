package com.efg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class JavaCollection {
    List addressList;
    Set  addressSet;
    Map  addressMap;
    Properties addressProp;

    // 设置 List 的 setter 方法
    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    // 打印并返回列表的所有元素。
    public List getAddressList() {
        System.out.println("List Elements :"  + addressList);
        return addressList;
    }

    // 设置 Set 的 setter 方法
    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    // 打印并返回 Set 的所有元素。
    public Set getAddressSet() {
        System.out.println("Set Elements :"  + addressSet);
        return addressSet;
    }

    // 设置 Map 的 setter 方法
    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    // 打印并返回 Map 的所有元素。
    public Map getAddressMap() {
        System.out.println("Map Elements :"  + addressMap);
        return addressMap;
    }

    // 设置属性的 setter 方法
    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    // 打印并返回属性的所有元素。
    public Properties getAddressProp() {
        System.out.println("Property Elements :"  + addressProp);
        return addressProp;
    }
}