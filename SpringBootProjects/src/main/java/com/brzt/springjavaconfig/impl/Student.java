package com.brzt.springjavaconfig.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author puhome
 * @data 2020/7/31
 */

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
