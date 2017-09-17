package com.wzy.view;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;



@Controller
public class StudentView {

    @RequestMapping(value = "/",method = GET)
    public String findAll(){
        return "success";
    }
}
