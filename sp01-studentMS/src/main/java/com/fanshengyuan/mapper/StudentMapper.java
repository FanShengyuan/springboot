package com.fanshengyuan.mapper;

import com.fanshengyuan.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fanshengyuan
 * @create 2021-11-15 21:03
 * @description
 */
@Mapper
@Repository//Dao层
public interface StudentMapper {
    // 获取所有Student信息
    List<Student> queryStudentList();

    // 通过sno获得Student信息
    Student queryStudentBySno(Integer sno);

    // 新增一个Student
    int addStudent(Student student);

    // 通过sno删除Student
    int deleteStudent(Integer sno);

    //更新Student信息
    int updateStudent(Student student);
}
