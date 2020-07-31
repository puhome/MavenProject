package com.brzt.springjavaconfig.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author puhome
 * @data 2020/7/31
 */
@Component
public class Teacher {

    private String driverClass;

    public String getDriverClass() {
        return driverClass;
    }

    @Value("${jdbc.driverClass}")
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
