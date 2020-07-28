package com.brzt.entity;

import javafx.beans.NamedArg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
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
    private String driver;
    private BMW bmw;
    private Benchi benchi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * SqEL表达式
     * @param name
     */
    @Value("#{person.getName()}")
    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    /**
     * 默认true，如没有bean则异常
     * false,没有bean也不报异常
     * @param car
     */
    @Autowired(required = false)
    /**
     * 当匹配多个的时候，无法自动匹配 就需要指定bean的名称
     */
    @Qualifier("car")
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

    public String getDriver() {
        return driver;
    }

    /**
     * EL表达式
     * @param driver
     */
    @Value("${jdbc.driverClass}")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public BMW getBmw() {
        return bmw;
    }

    /**
     * JSR-250标准的方法(还有个JSR-330标准)
     * 提供了公共的方法，Spring也支持
     * @Resource，相当于Spring中的@Autowired
     * @ManagedBean，相当于Spring中的@Component
     * @param bmw
     */
//    @Resource
    public void setBmw(BMW bmw) {
        this.bmw = bmw;
    }

    public Benchi getBenchi() {
        return benchi;
    }

    public void setBenchi(Benchi benchi) {
        this.benchi = benchi;
    }
}
