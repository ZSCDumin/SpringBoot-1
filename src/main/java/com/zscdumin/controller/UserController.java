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

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public List<User> userList() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String userAdd(@RequestBody User user) {
        if (userRepository.save(user) != null) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String userUpdate(@RequestBody User user) {
        if (userRepository.save(user) != null) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String userDelete(@RequestParam(value = "ID", required = false) Integer id) {
        try {
            userRepository.delete(id);
            return "删除成功";
        } catch (Exception e){
            return "删除失败";
        }
    }
}
