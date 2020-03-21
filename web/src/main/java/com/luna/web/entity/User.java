package com.luna.web.entity;

/**
 * @author Luna@win10
 * @date 2020/3/21 14:42
 */
public class User {

    private String name;
    private int    age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
