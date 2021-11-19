package com.fanshengyuan.mapper;

import com.fanshengyuan.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fanshengyuan
 * @create 2021-11-15 15:47
 * @description
 */
//@Mapper : 表示本类是MyBatis的一个Mapper；直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解
// 也可以在Sp01StudentMsApplication.java添加@MapperScan("com.jiyu.mapper"),可以指定要扫描的Mapper类的包的路径
// 使用@MapperScan注解多个包：@MapperScan({"com.jiyu.demo","com.jiyu.mapper"})
@Mapper
@Repository//Dao层
public interface AccountMapper {
    // 获取所有Account信息
    List<Account> queryAccountList();

    // 通过id获得Account信息
    Account queryAccountById(Integer id);

    //通过username获得Account信息
    Account queryAccountByUsername(String username);

    // 新增一个Account
    int addAccount(Account account);

    // 通过id删除Account
    int deleteAccount(Integer id);

    //更新Account信息
    int updateAccount(Account account);
}
