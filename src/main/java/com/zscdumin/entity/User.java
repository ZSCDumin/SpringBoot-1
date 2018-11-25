package com.zscdumin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 说明:
 * <br>
 *
 * @author ZSCDumin
 * <br>
 * 邮箱: 2712220318@qq.com
 * <br>
 * 日期: 2018/11/8
 * <br>
 * 版本: 1.0
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String account;
    private String password;
    private String name;
    private Integer age;
    private boolean sex;
    private String phone;
    private String email;
    private String certificateNumber;
    private String lawFirm;
    private String address;
    private Integer role;
    private String icon;
}
