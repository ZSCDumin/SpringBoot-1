package com.zscdumin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
public class Law {
    @Id
    @GeneratedValue
    private int id;
    private String effectLevel;
    private String area;
    private String releasePlace;
    private Date releaseTime;
    private int isWork;
    private String content;
}
