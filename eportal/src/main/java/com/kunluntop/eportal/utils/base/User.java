package com.kunluntop.eportal.utils.base;

/**
 * @author 10919
 * @title: User
 * @projectName platform
 * @description: TODO
 * @date 2019/8/2316:53
 */
public class User {
    private  String id;
    private  String name;

    private  String password;

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
