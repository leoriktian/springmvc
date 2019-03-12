package com.tian.object;

import lombok.Data;

import java.util.List;

/**
 * @Author: tyq
 * @Date: 2019/3/12 14:24
 */
@Data
public class UserListForm {

    private List<User> users;

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
