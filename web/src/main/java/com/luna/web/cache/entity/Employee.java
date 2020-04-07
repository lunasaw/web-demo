package com.luna.web.cache.entity;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author luna
 * @since 2020-04-07 20:35:55
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -30294923257499126L;
    
    private Integer id;
    
    private String name;
    
    private String email;
    
    private String gender;
    
    private Integer did;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

}