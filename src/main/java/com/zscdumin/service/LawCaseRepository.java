package com.zscdumin.service;

import com.zscdumin.entity.LawCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawCaseRepository extends JpaRepository<LawCase, Integer> {
//    List<LawCase> findByAnyFiledLike(String anyFiled);
}
