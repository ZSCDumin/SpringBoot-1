package com.zscdumin.service;

import com.zscdumin.entity.LawCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawCourseRepository extends JpaRepository<LawCourse, Integer> {

    @Query(value = "select * from law_course as a where CONCAT(IFNULL(a.content,''),IFNULL(a.datetime,''),IFNULL(a.id,''),IFNULL(a.lawyer_id,''),IFNULL(a.title,''),IFNULL(a.video_url,'')) LIKE concat(concat('%', ?1), '%') ORDER BY a.id ASC;", nativeQuery = true)
    List<LawCourse> findByAnyFiledLike(String anyFiled);
}
