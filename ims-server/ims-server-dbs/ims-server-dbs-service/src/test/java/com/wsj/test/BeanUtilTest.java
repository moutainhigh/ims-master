package com.wsj.test;

import com.yianju.ims.entity.Result;
import com.yianju.ims.util.BeanPropertyValidateUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.List;

public class BeanUtilTest {

    public static void main(String[] args) {
        Result username = BeanPropertyValidateUtil.getEmptyFields(new MyMyUser(), "username","pwd","aaa");
        System.out.println(username);
    }
}

@Data
class User {
    private String id;
}

@Data
class MyUser extends User{
    private String username;
    private String password;
}

@Data
class MyMyUser extends MyUser{
    private int age;
}