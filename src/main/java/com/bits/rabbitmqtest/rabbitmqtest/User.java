package com.bits.rabbitmqtest.rabbitmqtest;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "Id ='" + id + '\'' +
                ", Name ='" + name + '\'' +
                '}';
    }
}
