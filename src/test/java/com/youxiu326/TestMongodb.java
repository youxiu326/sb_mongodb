package com.youxiu326;

import com.youxiu326.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMongodb {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void query(){
        String id = "2";
        //单条
        Query query = new Query(Criteria.where("id").is(2L));//可累加条件
        User user = mongoTemplate.findOne(query, User.class);
        //多条
        Query query2 = new Query(Criteria.where("passWord").regex("aa"));//可累加条件
        List<User> users = mongoTemplate.find(query, User.class);

        System.out.println(user);
        System.out.println("=============");
        System.out.println(users);
    }

    @Test
    public void query2(){

        List<User> all = mongoTemplate.findAll(User.class);
        all.stream().forEach(it-> System.out.println(it));

    }

}