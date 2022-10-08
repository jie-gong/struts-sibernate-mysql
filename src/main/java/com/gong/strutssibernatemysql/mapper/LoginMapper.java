package com.gong.strutssibernatemysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository//持久层框架
//在对应的Mapper上继承基本的类baseMapper
public interface LoginMapper extends BaseMapper<T_user> {
//    T_user admin(String username, String password);
}
