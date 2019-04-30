package com.youxiu326.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;

    private String userName;

    private String passWord;

    private Integer age;

}
