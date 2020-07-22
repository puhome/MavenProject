package com.brzt.entity;

import java.util.*;

/**
 * 快速封装，右键Generate，Getter and Setter
 */
public class Users {

    private int id;
    private String name;
    private Car car;
    private Object obj;
    private List list;
    private Set set;
    private Map map;
    private Properties prop;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Users(){}

    public  Users(String name,int id){
        this.name=name;
        this.id=id;
    }
}
