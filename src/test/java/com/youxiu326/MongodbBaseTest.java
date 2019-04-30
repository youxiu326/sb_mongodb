package com.youxiu326;

import com.youxiu326.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 基本增删改查
 * Created by lihui on 2019/04/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbBaseTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询
     */
    @Test
    public void testFind(){
        List<User> list = mongoTemplate.findAll(User.class);
        list.stream().forEach(it-> System.out.println(it));

        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("小明"));
        List<User> users = mongoTemplate.find(query, User.class);
        User user = mongoTemplate.findOne(query, User.class);
        users.stream().forEach(it-> System.out.println(it));
        System.out.println(users.size());
        System.out.println("======================");
        System.out.println(user);
    }

    @Test
    public void testFindUseRegex(){

        //寻找名称以A开头的所有用户
        Query startQuery = new Query();
        startQuery.addCriteria(Criteria.where("userName").regex("^A"));
        List<User> users1 = mongoTemplate.find(startQuery,User.class);

        //查找名称以c结尾的所有用户
        Query endQuery = new Query();
        endQuery.addCriteria(Criteria.where("userName").regex("c$"));
        List<User> users2 = mongoTemplate.find(endQuery, User.class);

        System.out.println(users1);
        System.out.println(users2);

        //寻找年龄在20岁到50岁之间的所有用户

        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(50).gt(17));
        List<User> users = mongoTemplate.find(query,User.class);
        System.out.println(users);
    }

    /**
     * 排序
     */
    @Test
    public void testSort(){
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "age"));
        List<User> users = mongoTemplate.find(query,User.class);
        users.stream().forEach(it-> System.out.println(it));
    }

    /**
     * 分页
     */
    @Test
    public void testPage(){
        final Pageable pageableRequest = new PageRequest(0, 2);
        Query query = new Query();
        query.with(pageableRequest);
        List<User> users = mongoTemplate.find(query,User.class);
        users.stream().forEach(it-> System.out.println(it));
    }


    /**
     * 新增or修改
     */
    @Test
    public void testUpdate(){

    }

} 