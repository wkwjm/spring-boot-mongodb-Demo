package com.wangkang.test.jdbc.jdbc.service;

import com.wangkang.test.jdbc.jdbc.entity.TbUser;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TbUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存用户
     * @param tbUser
     */
    public void save(TbUser tbUser){
        System.out.println("createUser");
        String sql = "insert into tb_user(user_name,pass_word,qq,wei_xin,phone,hobby,create_time,update_time)"+
                "values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,tbUser.getUserName(),tbUser.getPassWord(),tbUser.getQq(),tbUser.getWeiXin(),tbUser.getPhone(),
                tbUser.getHobby(),new Date(),new Date());
        System.out.println("添加用户成功！！");
    }
    
}
