package com.gong.strutssibernatemysql.util;

//import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.strutssibernatemysql.util.TokenUtil
 * @Date: 2022年09月24日 10:49
 * @Description:
 */

public class TokenUtil {

//    public static String getTokenUserId() {
//        String token = getRequest().getHeader("token");// 从 http 请求头中取出 token
//        String userId = JWT.decode(token).getAudience().get(0);
//        return userId;
//    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}

