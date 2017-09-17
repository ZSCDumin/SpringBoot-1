package com.wzy.controller;

import com.wzy.entity.Student;
import com.wzy.service.StudentProperies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentProperies studentProperies;

    @RequestMapping("/show")
    public List<Student> studentList(){
        return studentProperies.findAll();
    }

    @RequestMapping("/add")
    public Integer studentAdd(@RequestParam(value = "name",required=false) String name,
                              @RequestParam(value = "age",required = false) Integer age,
                              @RequestParam(value = "address",required = false) String address,
                              @RequestParam(value = "school",required = false) String school,
                              @RequestParam(value = "studentID",required = false) Integer studentID){
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        student.setSchool(school);
        student.setStudentID(studentID);
        if (studentProperies.save(student)!=null){
            return 1;
        }else {
            return 0;
        }

    }

//    @RequestMapping("/select")
//    public Student studentFindOne(@PathVariable("")){
//
//    }

    @RequestMapping("/update")
    public Integer studentUpdate(@RequestParam(value = "ID",required = false) Integer id,
                                 @RequestParam(value = "name",required=false) String name,
                                 @RequestParam(value = "age",required = false) Integer age,
                                 @RequestParam(value = "address",required = false) String address,
                                 @RequestParam(value = "school",required = false) String school,
                                 @RequestParam(value = "studentID",required = false) Integer studentID){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        student.setSchool(school);
        student.setStudentID(studentID);
        if (studentProperies.save(student)!=null){
            return 1;
        }else{
            return 0;
        }
    }
    @RequestMapping("/delete")
    public Integer studentDelete(@RequestParam(value = "ID",required = false) Integer id){
        try{
            studentProperies.delete(id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
