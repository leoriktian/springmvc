package com.tian.object;

import lombok.Data;

import java.util.Map;

/**
 * @Author: tyq
 * @Date: 2019/3/12 14:56
 */
@Data
public class UserMapForm {

    private Map<String, User> users;

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }
}
