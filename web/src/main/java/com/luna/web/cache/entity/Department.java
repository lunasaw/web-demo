package com.luna.web.cache.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author luna
 * @since 2020-04-07 20:37:20
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 945490203973815738L;
    
    private Integer id;
    
    private String name;


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

}