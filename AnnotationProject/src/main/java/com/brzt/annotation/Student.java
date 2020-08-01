package com.brzt.annotation;

@StudentTable("student")
public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    @StudentField(columName = "name",type = "varchar",length = 100)
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @StudentField(columName = "age",type = "int",length = 10)
    public void setAge(int age) {
        this.age = age;
    }
}
