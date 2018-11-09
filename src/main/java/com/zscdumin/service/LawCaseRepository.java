package com.zscdumin.service;

import com.zscdumin.entity.LawCase;
import com.zscdumin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawCaseRepository extends JpaRepository<LawCase, Integer> {
}
