package com.youxiu326;

import com.youxiu326.entity.User;
import com.youxiu326.repository.UserRepositoryJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbBaseJpaTest {

    @Autowired
    private UserRepositoryJpa userJpa;

    @Test
    public void  test01(){

        Optional<User> user = userJpa.findById(6L);
        if (user.isPresent()){
            System.out.println(user);
        }

        List<User> list = userJpa.findByUserName("Alice");
        list.stream().forEach(it-> System.out.println(it));



    }

} 