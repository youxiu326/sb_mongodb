package com.youxiu326;

import com.youxiu326.entity.User;
import com.youxiu326.utils.MongoDBPageModel;
import com.youxiu326.utils.SpringbootMongoDBPageable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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


    //分页查询
    @Test
    public void PageQuery(){
        //利用工具类拼装分页信息
        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();
        pm.setPagesize(3);
        pm.setPagenumber(1);
        List<Order> orders = new ArrayList<>();  //排序信息
        orders.add(new Order(Direction.DESC, "age"));
        Sort sort = new Sort(orders);
        pm.setSort(sort);
        pageable.setPage(pm);
        //拼装查询信息
        Query query = new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.where("age").gte(6).lte(18));//检索6-18岁的
        query.addCriteria(criteria.where("name").regex("文"));//模糊查询名字
        Long count = mongoTemplate.count(query, User.class);//查询总记录数
        List<User> list = mongoTemplate.find(query.with(pageable), User.class);
    }

}