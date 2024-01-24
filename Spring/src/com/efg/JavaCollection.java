package com.efg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class JavaCollection {
    List addressList;
    Set  addressSet;
    Map  addressMap;
    Properties addressProp;

    // ���� List �� setter ����
    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    // ��ӡ�������б������Ԫ�ء�
    public List getAddressList() {
        System.out.println("List Elements :"  + addressList);
        return addressList;
    }

    // ���� Set �� setter ����
    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    // ��ӡ������ Set ������Ԫ�ء�
    public Set getAddressSet() {
        System.out.println("Set Elements :"  + addressSet);
        return addressSet;
    }

    // ���� Map �� setter ����
    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    // ��ӡ������ Map ������Ԫ�ء�
    public Map getAddressMap() {
        System.out.println("Map Elements :"  + addressMap);
        return addressMap;
    }

    // �������Ե� setter ����
    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    // ��ӡ���������Ե�����Ԫ�ء�
    public Properties getAddressProp() {
        System.out.println("Property Elements :"  + addressProp);
        return addressProp;
    }
}