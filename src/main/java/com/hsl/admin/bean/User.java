package com.hsl.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//@TableName("User")  //根据表名
@Data
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;


    private Long id;
    private String name;
    private Integer age;
    private String email;
}

