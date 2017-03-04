/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeController.java
 * Package Name:com.huaxia.analyze.controller
 * Date:2017-2-28下午4:42:33
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huaxia.analyze.bean.AnalyzeLogBean;
import com.huaxia.analyze.service.AnalyzeService;

/**
 * ClassName: AnalyzeController <br/>
 * Date: 2017-2-28 下午4:42:33 <br/>
 * Description: 分析记录的控制层
 * 
 * @author fangm
 * @version
 * @see
 */
@Controller
@RequestMapping("/analyze")
public class AnalyzeController {
    @Autowired
    private AnalyzeService analyzeservice;

    @RequestMapping("/listcount")
    public String getAllAnalyze(HttpServletRequest request) {
        request.setAttribute("ListCount", analyzeservice.getAllAnalyze());
        return "/listcount";
    }

    @RequestMapping("/analyze")
    public String analyzeToDatabase(HttpServletRequest request) {
        List<AnalyzeLogBean> list = analyzeservice.analyze();
        analyzeservice.saveAll(list);
        request.setAttribute("ListCount", analyzeservice.getAllAnalyze());
        return "/listcount";
    }

}

