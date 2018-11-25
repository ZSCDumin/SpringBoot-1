package com.zscdumin.service;

import com.zscdumin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tuser as u \n" +
            "WHERE\n" +
            "\tCONCAT(\n" +
            "\tIFNULL( u.id, '' ),\n" +
            "\tIFNULL( u.account, '' ),\n" +
            "\tIFNULL( u.address, '' ),\n" +
            "\tIFNULL( u.age, '' ),\n" +
            "\tIFNULL( u.certificate_number, '' ),\n" +
            "\tIFNULL( u.email, '' ),\n" +
            "\tIFNULL( u.law_firm, '' ),\n" +
            "\tIFNULL( u.`name`, '' ),\n" +
            "\tIFNULL( u.`password`, '' ),\n" +
            "\tIFNULL( u.phone, '' ),\n" +
            "\tIFNULL( u.role, '' ),\n" +
            "\tIFNULL( u.sex, '' ) \n" +
            "\tIFNULL( u.icon, '' ) \n" +
            "\t) LIKE concat( concat( '%', ?1), '%' ) \n" +
            "ORDER BY\n" +
            "\tu.id ASC;", nativeQuery = true)
    List<User> findByAnyFiledLike(@Param("anyFiled") String anyFiled);
}
