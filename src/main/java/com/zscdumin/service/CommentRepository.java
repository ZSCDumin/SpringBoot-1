package com.zscdumin.service;

import com.zscdumin.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select * from comment as a where CONCAT(IFNULL(a.id,''),IFNULL(a.content,''),IFNULL(a.commenter,''),IFNULL(a.datetime,''),IFNULL(a.comment_object_type,''),IFNULL(a.comment_object_id,'')) LIKE concat(concat('%', ?1), '%') ORDER BY a.id ASC;", nativeQuery = true)
    List<Comment> findByAnyFiledLike(String anyFiled);
}
