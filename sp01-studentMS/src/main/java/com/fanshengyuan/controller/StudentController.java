package com.fanshengyuan.controller;

import com.fanshengyuan.mapper.StudentMapper;
import com.fanshengyuan.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author fanshengyuan
 * @create 2021-11-15 18:07
 * @description
 */
@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/students")
    public String queryStudentList(Model model){
        List<Student> studentList = studentMapper.queryStudentList();
        model.addAttribute(studentList);
        return "student/list";//返回到list页面
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "student/add";//返回到添加学生页面
    }

    @PostMapping("/add")
    public String add(Student student) {
        System.out.println("add: "+student);
        studentMapper.addStudent(student);//添加一个员工
        return "redirect:/students";//重定向到/students,刷新列表,返回到list页面
    }

    //restful风格接收参数
    @RequestMapping("/toEdit/{sno}")
    public String toEdit(@PathVariable("sno") int sno, Model model) {
        //查询指定sno的学生,用于前端接收
        Student student = studentMapper.queryStudentBySno(sno);
        System.out.println("before editing: "+student);
        model.addAttribute("student", student);
        return "student/edit";//返回到编辑学生页面
    }

    @PostMapping("/edit")
    public String edit(Student student) {
        studentMapper.updateStudent(student);
        System.out.println("after editing: "+student);
        return "redirect:/students";//添加完成重定向到/students,刷新列表
    }

    @GetMapping("/delete/{sno}")
    public String delete(@PathVariable("sno") Integer sno) {
        studentMapper.deleteStudent(sno);
        return "redirect:/students";
    }
}
