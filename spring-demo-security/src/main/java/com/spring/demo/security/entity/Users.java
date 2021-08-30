package com.spring.demo.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户信息 实体类
 * </P>
 *
 * @author Major Tom
 * @since 2021/8/30 10:32
 */
@Data
@TableName(value = "users")
public class Users implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;
}
