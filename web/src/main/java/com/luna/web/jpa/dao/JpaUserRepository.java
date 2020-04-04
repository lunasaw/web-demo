package com.luna.web.jpa.dao;

import com.luna.web.jpa.entity.JpaUserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Luna@win10
 * @date 2020/4/4 17:50
 * 继承JpaRepository 完成对数据库操作
 */
public interface JpaUserRepository extends JpaRepository<JpaUserDO,Integer> {
}
