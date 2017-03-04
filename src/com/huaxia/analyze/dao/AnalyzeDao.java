/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeDao.java
 * Package Name:com.huaxia.analyze.dao
 * Date:2017-2-28上午10:20:23
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.dao;

import java.util.List;

import com.huaxia.analyze.bean.AnalyzeLogBean;

/**
 * ClassName: AnalyzeDao <br/>
 * Date: 2017-2-28 上午10:20:23 <br/>
 * Description: 日志统计dao层
 * 
 * @author fangm
 * @version
 * @see
 */
public interface AnalyzeDao {
    public AnalyzeLogBean getAnalyze(Integer integer);

    public List<AnalyzeLogBean> getAllAnalyze();

    public void addAnalyze(AnalyzeLogBean analyze);
    
    public boolean delAnalyze(String id);
    
    public boolean updateAnalyze(AnalyzeLogBean analyze);
}

