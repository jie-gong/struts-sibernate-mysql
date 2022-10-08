package com.gong.strutssibernatemysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class T_user {
    private String id;
    private String username;
    private String password;
}
