package com.gong.strutssibernatemysql.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//员工表
public class Student {
    //主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer gender;//0,女 1,男
    private String department;
    private String birth;
    private String email;

}
