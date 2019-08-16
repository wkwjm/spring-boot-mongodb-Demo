package com.wangkang.test.jdbc.jdbc.controller;

import com.wangkang.test.jdbc.jdbc.entity.TbUser;
import com.wangkang.test.jdbc.jdbc.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String index(){
        System.out.println(123123123);
        return "user";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser){
        tbUserService.save(tbUser);
        return "success";
    }
}
