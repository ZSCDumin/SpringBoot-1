package com.zscdumin.service;

import com.zscdumin.entity.LawCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawCourseRepository extends JpaRepository<LawCourse, Integer> {
//    @Query(value = "select * from law_course where content like CONCAT('%',:anyFiled,'%')")
//    List<LawCourse> findByAnyFiledLike(String anyFiled);
}
