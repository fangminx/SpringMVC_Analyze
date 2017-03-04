/**
 * Project Name:SpringMVC_Analyze
 * File Name:InfoService.java
 * Package Name:com.huaxia.analyze.service
 * Date:2017-3-1下午12:21:16
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.service;

import java.util.Date;
import java.util.List;

import com.huaxia.analyze.bean.AnalyzeInfo;

/**
 * ClassName: InfoService <br/>
 * Date: 2017-3-1 下午12:21:16 <br/>
 * Description: 日志service层
 * 
 * @author fangm
 * @version
 * @see
 */
public interface InfoService {
    List<AnalyzeInfo> analyze();

    void save(AnalyzeInfo info);

    void saveAll(List<AnalyzeInfo> list);

    AnalyzeInfo getInfo(String id);

    List<AnalyzeInfo> getAllInfo();

    int getTotalRows();

    List<AnalyzeInfo> getInfoByPage(int curnum);

    List<AnalyzeInfo> datetoPage(int curnum, Date start, Date end);
}

