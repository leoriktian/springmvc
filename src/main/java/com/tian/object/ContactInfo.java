package com.tian.object;

import lombok.Data;

/**
 * @Author: tyq
 * @Date: 2019/3/12 10:49
 */
@Data
public class ContactInfo {

    private Integer phone;
    

    private String address;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
