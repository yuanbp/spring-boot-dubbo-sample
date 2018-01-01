package com.sbtdubbo.api.domain;

import java.io.Serializable;

/**
 * Created by Richard on 2017/10/26 0026.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5029777869979848060L;

    private String name;
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
