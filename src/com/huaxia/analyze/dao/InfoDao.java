/**
 * Project Name:SpringMVC_Analyze
 * File Name:InfoDao.java
 * Package Name:com.huaxia.analyze.dao
 * Date:2017-3-1下午12:09:30
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.dao;

import java.util.Date;
import java.util.List;

import com.huaxia.analyze.bean.AnalyzeInfo;

/**
 * ClassName: InfoDao <br/>
 * Date: 2017-3-1 下午12:09:30 <br/>
 * Description: 日志信息dao
 * 
 * @author fangm
 * @version
 * @see
 */
public interface InfoDao {
    AnalyzeInfo getAnalyzeInfo(Integer integer);

    List<AnalyzeInfo> getInfo();

    void addInfo(AnalyzeInfo Info);

    boolean delInfo(String id);

    boolean updateInfo(AnalyzeInfo Info);

    int getTotalRows();
    
    List<AnalyzeInfo> getInfoByPage(int curnum);

    List<AnalyzeInfo> datetoPage(int curnum, Date start, Date end);
}

