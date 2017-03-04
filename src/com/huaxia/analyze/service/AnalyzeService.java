/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeService.java
 * Package Name:com.huaxia.analyze.service
 * Date:2017-2-28上午10:50:42
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.service;

import java.util.List;

import com.huaxia.analyze.bean.AnalyzeLogBean;

/**
 * ClassName: AnalyzeService <br/>
 * Date: 2017-2-28 上午10:50:42 <br/>
 * Description: 日志分析service层
 * 
 * @author fangm
 * @version
 * @see
 */
public interface AnalyzeService {
    List<AnalyzeLogBean> analyze();

    void save(AnalyzeLogBean logBean);

    void saveAll(List<AnalyzeLogBean> list);

    AnalyzeLogBean getAnaly(String id);

    List<AnalyzeLogBean> getAllAnalyze();

}

