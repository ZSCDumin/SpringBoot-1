package com.zscdumin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @RequestMapping(value = "/all", method = RequestMethod.POST)
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

    @RequestMapping(value = "/allByPage", method = RequestMethod.POST)
    public PageInfo<User> findAllByPage() {
        PageHelper.startPage(1, 3);
        List<User> userList = userRepository.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
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
}
