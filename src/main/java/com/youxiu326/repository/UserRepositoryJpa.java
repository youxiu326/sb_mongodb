package com.youxiu326.repository;

import com.youxiu326.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepositoryJpa extends MongoRepository<User, Long>/*, QuerydslPredicateExecutor<User> */{

    List<User> findByUserName(String userName);

    /**
     * 以什么开头
     * @param userName
     * @return
     */
    List<User> findByUserNameStartingWith(String userName);

    List<User> findByUserNameEndingWith(String userName);

    /**
     * Between
     * @param ageGT 大于
     * @param ageLT 小于
     * @return
     */
    List<User> findByAgeBetween(int ageGT, int ageLT);



    /**
     *  查找名称中包含字母A的所有用户，我们也将按年龄顺序排列结果
     * @param userName
     * @return
     */
    List<User> findByUserNameLikeOrderByAgeAsc(String userName);


    /********************************我是分割线 JSON查询方法 ******************************/

    @Query("{ 'userName' : ?0 }")
    List<User> findUsersByUserName(String userName);

    @Query("{ 'userName' : { $regex: ?0 } }")
    List<User> findUsersByRegexpName(String regexp);
}