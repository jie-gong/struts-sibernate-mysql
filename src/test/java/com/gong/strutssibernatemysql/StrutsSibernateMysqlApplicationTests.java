package com.gong.strutssibernatemysql;

import com.gong.strutssibernatemysql.mapper.LoginMapper;
import com.gong.strutssibernatemysql.mapper.UserMapper;
import com.gong.strutssibernatemysql.pojo.Student;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class StrutsSibernateMysqlApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private LoginMapper loginMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void select(){
        List<Student> students = userMapper.selectList(null);
        students.forEach(System.out::println);

    }
    @Test
    public void select2(){
        List<T_user> t_users = loginMapper.selectList(null);
        t_users.forEach(System.out::println);
    }
    @Test
    public void PL(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username","gong");
        List<T_user> t_users = loginMapper.selectByMap(objectObjectHashMap);
        t_users.forEach(System.out::println);

    }


}
