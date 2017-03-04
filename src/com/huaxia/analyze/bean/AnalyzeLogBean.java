/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeLogBean.java
 * Package Name:com.huaxia.analyze.bean
 * Date:2017-2-28上午10:01:53
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
 * ClassName: AnalyzeLogBean <br/>
 * Date: 2017-2-28 上午10:01:53 <br/>
 * Description: 解析数据封装的实体类
 * 
 * @author fangm
 * @version
 * @see
 */
@Entity
@Table(name = "T_ANALYZE")
public class AnalyzeLogBean {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "HOUR")
    private String hour;

    @Column(name = "REQUEST_XML_TIMES")
    private Integer requestXMLTimes;

    @Column(name = "RESPONSE_XML_TIMES")
    private Integer responseXMLTimes;

    @Column(name = "REQUEST_SERVICE_TIMES")
    private Integer requestServiceTimes;

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

    public Integer getRequestXMLTimes() {
        return requestXMLTimes;
    }

    public void setRequestXMLTimes(Integer requestXMLTimes) {
        this.requestXMLTimes = requestXMLTimes;
    }

    public Integer getResponseXMLTimes() {
        return responseXMLTimes;
    }

    public void setResponseXMLTimes(Integer responseXMLTimes) {
        this.responseXMLTimes = responseXMLTimes;
    }

    public Integer getRequestServiceTimes() {
        return requestServiceTimes;
    }

    public void setRequestServiceTimes(Integer requestServiceTimes) {
        this.requestServiceTimes = requestServiceTimes;
    }

}

