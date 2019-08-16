package com.wangkang.test.jdbc.jdbc.controller;

import com.wangkang.test.jdbc.jdbc.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MongoDBController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**表名*/
    private static final String collectionName = "tbUser";

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public void save(@ModelAttribute TbUser tbUser) throws Exception {
        this.mongoTemplate.save(tbUser);
        System.out.println(123);
    }

    @RequestMapping("/delete")
    @ResponseBody
     public void delete(@RequestParam("userId") Integer userId) throws Exception {
                Query query = Query.query(Criteria.where("userId").is(userId));
                 this.mongoTemplate.remove(query,collectionName);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void update(@ModelAttribute TbUser tbUser) throws Exception {
        Query query = Query.query(Criteria.where("userId").is(tbUser.getUserId()));
        Update update = new Update();
        update.set("userName", tbUser.getUserName());
        update.set("phone", tbUser.getPhone());
        update.set("qq", tbUser.getQq());
        update.set("weiXin", tbUser.getWeiXin());
        update.set("hobby", tbUser.getHobby());
        update.set("createTime", tbUser.getCreateTime());
        update.set("updateTime", tbUser.getUpdateTime());
        this.mongoTemplate.updateFirst(query,update,collectionName);
    }


     @RequestMapping("/query")
     public String query(Model model) throws Exception {
         Query query = Query.query(Criteria.where("userId").is(18));
         List<TbUser> users = this.mongoTemplate.find(query, TbUser.class);
         model.addAttribute("users",users);
         return "mongo";
     }
}
