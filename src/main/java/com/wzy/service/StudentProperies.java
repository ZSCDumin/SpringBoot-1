package com.wzy.service;

import com.wzy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProperies extends JpaRepository<Student,Integer> {
}
