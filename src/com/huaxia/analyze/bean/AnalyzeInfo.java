/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeInfo.java
 * Package Name:com.huaxia.analyze.bean
 * Date:2017-3-1下午12:04:48
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName: AnalyzeInfo <br/>
 * Date: 2017-3-1 下午12:04:48 <br/>
 * Description: 日志信息实体类
 * 
 * @author fangm
 * @version
 * @see
 */
@Entity
@Table(name = "T_INFO")
public class AnalyzeInfo {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "HOUR")
    private String hour;

    @Column(name = "OPERATE")
    private String operate;

    @Column(name = "INTER")
    private String inter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getInter() {
        return inter;
    }

    public void setInter(String inter) {
        this.inter = inter;
    }


}

