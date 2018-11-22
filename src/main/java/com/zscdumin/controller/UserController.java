package com.zscdumin.controller;

import com.zscdumin.entity.User;
import com.zscdumin.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ZSCDumin
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> userList() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int userAdd(@RequestBody User user) {
        if (userRepository.save(user) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int userUpdate(@RequestBody User user) {
        if (userRepository.save(user) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int userDelete(@RequestParam(value = "id") Integer id) {
        try {
            userRepository.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @RequestMapping(value = "/findByAnyFiledLike", method = RequestMethod.POST)
    public List<User> findByAnyFiledLike(@RequestParam(value = "anyFiled") String anyFiled) {
        try {
            return userRepository.findByAnyFiledLike(anyFiled);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
