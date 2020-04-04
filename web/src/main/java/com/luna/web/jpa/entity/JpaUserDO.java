package com.luna.web.jpa.entity;

import javax.persistence.*;

/**
 * @author Luna@win10
 * @date 2020/4/4 17:45
 */
// JPA 配置
@Entity // 告诉Jpa 这是一个实体类
@Table(name = "tb_user") // 指定关联表 默认为类名小写
public class JpaUserDO {

    @Id // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Integer id;

    @Column(name = "name", length = 50)
    private String  name;

    @Column // 省略 列名就是属性名
    private String  email;

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
}
