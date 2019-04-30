package com.youxiu326;

import com.youxiu326.entity.User;
import com.youxiu326.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbMongodbApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(9l);
        user.setUserName("黑怕");
        user.setPassWord("迪士尼");
        user.setAge(13);
        userRepository.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        User user= userRepository.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userRepository.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userRepository.deleteUserById(1l);
    }



/*

  //定义一个泛型集合，类型为 Criteria
List<Criteria> criteriaList = new ArrayList<>();
//定义一个无长度的数组，类型为 Criteria
Criteria[] criteriaArray = {};
//往集合里面添加条件对象
if(你的逻辑){
    //大于方法
    Criteria gt = Criteria.where("你MongoDB中的key").gt("你的条件");
    //小于方法
    Criteria lt = Criteria.where("你MongoDB中的key").lt("你的条件");
    if(gt!=null && lt!=null){
        criteriaList.add(gt);
        criteriaList.add(lt);
    }else if(gt!=null){
        query.addCriteria(gt);
    }else if(lt!=null){
        query.addCriteria(lt);
    }
}
//是否有条件
if(criteriaList.size()>0){
    //把无长度的数组实例出来，长度就位集合的个数
    criteriaArray = new Criteria[criteriaList.size()];
    for(int i = 0 ; i < criteriaList.size() ; i++){
        //把集合中的条件对象全部存入数组中
        criteriaArray[i] = criteriaList.get(i);
    }
}
//最后把数组入参到 andOperator() 方法中
query.addCriteria(new Criteria().andOperator(criteriaArray));

*/

}
