package com.tian.object;

import lombok.Data;

/**
 * @Author: tyq
 * @Date: 2019/3/12 10:32
 */
@Data
public class User {

    private String name;

    private Integer age;


    private ContactInfo contactInfo;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
