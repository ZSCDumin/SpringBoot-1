package com.zscdumin.controller;

import com.zscdumin.entity.LawCourse;
import com.zscdumin.service.LawCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ZSCDumin
 */
@RestController
@RequestMapping(value = "/lawCourse")
public class LawCourseController {

    @Autowired
    private LawCourseRepository lawCourseRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<LawCourse> lawCourseList() {
        return lawCourseRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int lawCourseAdd(@RequestBody LawCourse lawCourse) {
        if (lawCourseRepository.save(lawCourse) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int lawCourseUpdate(@RequestBody LawCourse lawCourse) {
        if (lawCourseRepository.save(lawCourse) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int lawCourseDelete(@RequestParam(value = "id") Integer id) {
        try {
            lawCourseRepository.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    @RequestMapping(value = "/findByAnyFiledLike", method = RequestMethod.POST)
    public List<LawCourse> findByAnyFiledLike(@RequestParam(value = "anyFiled") String anyFiled) {
        try {
            return lawCourseRepository.findByAnyFiledLike(anyFiled);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
