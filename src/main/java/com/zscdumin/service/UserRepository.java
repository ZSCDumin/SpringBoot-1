package com.zscdumin.service;

import com.zscdumin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where name like CONCAT('%',:anyFiled,'%')", nativeQuery = true)
    List<User> findByAnyFiledLike(@Param("anyFiled") String anyFiled);
}
