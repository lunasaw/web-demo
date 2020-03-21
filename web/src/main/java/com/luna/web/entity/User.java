package com.luna.web.entity;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author Luna@win10
 * @date 2020/3/21 14:42
 */
public class User {

    private String name;
    private int    id;
    private int    gender;
    private Date birth;

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
