package com.zscdumin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明:
 * <br>
 *
 * @author ZSCDumin
 * <br>
 * 邮箱: 2712220318@qq.com
 * <br>
 * 日期: 2018/11/7
 * <br>
 * 版本: 1.0
 */

@Controller
public class UserView {

    @RequestMapping(value = "/user")
    public String showAllUserInfo(){
        return "success";
    }
}
