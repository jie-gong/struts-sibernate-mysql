package com.gong.strutssibernatemysql.services;

import com.gong.strutssibernatemysql.mapper.UserMapper;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.strutssibernatemysql.services.T_userService
 * @Date: 2022年09月24日 10:53
 * @Description:
 */
@Service
public class T_userService {
    @Autowired
    private UserMapper userMapper;
    public T_user findByUsername(T_user user){
        return userMapper.findByUsername(user.getUsername());
    }
    public T_user findUserById(String userId) {
        return userMapper.findUserById(userId);
    }
}

