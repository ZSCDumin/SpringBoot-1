package com.zscdumin.service;

import com.zscdumin.entity.LawCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawCaseRepository extends JpaRepository<LawCase, Integer> {
    @Query(value = "select * from law_case as a where CONCAT(IFNULL(a.case_type,''),IFNULL(a.content_url,''),IFNULL(a.datetime,''),IFNULL(a.id,''),IFNULL(a.img_url,'')) LIKE concat(concat('%', ?1), '%') ORDER BY a.id ASC;", nativeQuery = true)
    List<LawCase> findByAnyFiledLike(String anyFiled);
}
