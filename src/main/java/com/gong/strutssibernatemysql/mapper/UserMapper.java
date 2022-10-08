package com.gong.strutssibernatemysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.strutssibernatemysql.pojo.Student;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository//持久层框架
//在对应的Mapper上继承基本的类baseMapper
public interface UserMapper extends BaseMapper<Student> {
    T_user findByUsername(String username);

    T_user findUserById(String id);
}
