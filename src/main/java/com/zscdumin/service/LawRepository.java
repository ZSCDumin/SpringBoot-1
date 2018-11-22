package com.zscdumin.service;

import com.zscdumin.entity.Law;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawRepository extends JpaRepository<Law, Integer> {
    @Query(value = "select * from law as a where CONCAT(IFNULL(a.area,''),IFNULL(a.content,''),IFNULL(a.effect_level,''),IFNULL(a.id,''),IFNULL(a.is_work,''),IFNULL(a.release_place,''),IFNULL(a.release_time,'')) LIKE concat(concat('%', ?1), '%') ORDER BY a.id ASC;", nativeQuery = true)
    List<Law> findByAnyFiledLike(String anyFiled);
}
