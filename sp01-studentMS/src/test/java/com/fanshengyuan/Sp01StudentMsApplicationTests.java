package com.fanshengyuan;

import com.fanshengyuan.mapper.AccountMapper;
import com.fanshengyuan.mapper.StudentMapper;
import com.fanshengyuan.pojo.Account;
import com.fanshengyuan.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Sp01StudentMsApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    StudentMapper studentMapper;

    @Test//测试DataSource
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test//测试mybatis
    void  testMybatis(){
        List<Account> accountList = accountMapper.queryAccountList();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    void testStudent(){
        List<Student> studentList = studentMapper.queryStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
