package com.wangkang.test.jdbc.jdbc.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "tbUser")
public class TbUser {

    private Integer userId;
    private String userName;
    private String passWord;
    private String weiXin;
    private  String qq;
    private String phone;
    private String hobby;
    private Date createTime;
    private Date updateTime;
}
