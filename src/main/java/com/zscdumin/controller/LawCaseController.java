package com.zscdumin.controller;

import com.zscdumin.entity.LawCase;
import com.zscdumin.service.LawCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ZSCDumin
 */
@RestController
@RequestMapping(value = "/lawCase")
public class LawCaseController {

    @Autowired
    private LawCaseRepository lawCaseRepository;

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<LawCase> lawCaseList() {
        return lawCaseRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int lawCaseAdd(@RequestBody LawCase lawCase) {
        if (lawCaseRepository.save(lawCase) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int lawCaseUpdate(@RequestBody LawCase lawCase) {
        if (lawCaseRepository.save(lawCase) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int lawCaseDelete(@RequestParam(value = "id") Integer id) {
        try {
            lawCaseRepository.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
//    @RequestMapping(value = "/findByAnyFiledLike", method = RequestMethod.POST)
//    public int findByAnyFiledLike(@RequestParam(value = "anyFiled") String anyFiled) {
//        try {
//            lawCaseRepository.findByAnyFiledLike(anyFiled);
//            return 1;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return 0;
//        }
//    }
}
