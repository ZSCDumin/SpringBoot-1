package com.zscdumin.controller;

import com.zscdumin.entity.Law;
import com.zscdumin.service.LawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ZSCDumin
 */
@RestController
@RequestMapping(value = "/law")
public class LawController {

    @Autowired
    private LawRepository lawRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Law> lawList() {
        return lawRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int lawAdd(@RequestBody Law law) {
        if (lawRepository.save(law) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int lawUpdate(@RequestBody Law law) {
        if (lawRepository.save(law) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int lawDelete(@RequestParam(value = "id") Integer id) {
        try {
            lawRepository.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    @RequestMapping(value = "/findByAnyFiledLike", method = RequestMethod.POST)
    public List<Law> findByAnyFiledLike(@RequestParam(value = "anyFiled") String anyFiled) {
        try {
            return lawRepository.findByAnyFiledLike(anyFiled);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
