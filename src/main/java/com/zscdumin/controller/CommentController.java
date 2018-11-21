package com.zscdumin.controller;

import com.zscdumin.entity.Comment;
import com.zscdumin.service.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ZSCDumin
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<Comment> commentList() {
        return commentRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int commentAdd(@RequestBody Comment comment) {
        if (commentRepository.save(comment) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int commentUpdate(@RequestBody Comment comment) {
        if (commentRepository.save(comment) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int commentDelete(@RequestParam(value = "id") Integer id) {
        try {
            commentRepository.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

//    @RequestMapping(value = "/findByAnyFiledLike", method = RequestMethod.POST)
//    public int findByAnyFiledLike(@RequestParam(value = "anyFiled") String anyFiled) {
//        try {
//            commentRepository.findByAnyFiledLike(anyFiled);
//            return 1;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return 0;
//        }
//    }
}
