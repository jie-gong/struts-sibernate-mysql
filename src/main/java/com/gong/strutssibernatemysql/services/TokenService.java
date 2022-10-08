package com.gong.strutssibernatemysql.services;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.strutssibernatemysql.services.TokenService
 * @Date: 2022年09月24日 10:55
 * @Description:
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * token 下发
 * @Title: TokenService.java
 * @version V1.0
 */
@Service
public class TokenService {

    public String getToken(T_user user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}

