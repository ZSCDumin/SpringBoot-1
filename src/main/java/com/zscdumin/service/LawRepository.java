package com.zscdumin.service;

import com.zscdumin.entity.Law;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawRepository extends JpaRepository<Law, Integer> {
//    List<Law> findByAnyFiledLike(String anyFiled);
}
