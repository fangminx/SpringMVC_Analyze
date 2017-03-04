/**
 * Project Name:SpringMVC_Analyze
 * File Name:InfoController.java
 * Package Name:com.huaxia.analyze.controller
 * Date:2017-3-1下午12:33:28
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huaxia.analyze.bean.AnalyzeInfo;
import com.huaxia.analyze.service.InfoService;

/**
 * ClassName: InfoController <br/>
 * Date: 2017-3-1 下午12:33:28 <br/>
 * Description: 日志信息控制层
 * 
 * @author fangm
 * @version
 * @see
 */
@Controller
@RequestMapping("/info")
public class InfoController {
    private static Logger logger = Logger.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @RequestMapping("/infoToData")
    public String analyzeToDatabase(HttpServletRequest request) {
        List<AnalyzeInfo> list = infoService.analyze();
        infoService.saveAll(list);
        return "/list";
    }

    @RequestMapping("/infoByPage")
    public String getInfoByPage(HttpServletRequest request) {
        String cur = request.getParameter("page");
        int page = 1;
        int curnum;
        if (cur != null) {
            page = Integer.parseInt(cur);
            curnum = Integer.parseInt(cur);
        } else {
            curnum = 1;
        }
        request.setAttribute("pagenow", page);

        request.setAttribute("InfoList", infoService.getInfoByPage(curnum));
        return "/list";

    }

    @RequestMapping("/dateToPage")
    public String dateToPage(HttpServletRequest request) {
        String cur = request.getParameter("page");
        int page = 1;
        int curnum;
        if (cur != null) {
            page = Integer.parseInt(cur);
            curnum = Integer.parseInt(cur);
        } else {
            curnum = 1;
        }
        request.setAttribute("pagenow", page);
        String startstr = request.getParameter("start");
        String endstr = request.getParameter("end");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        Date end = null;
        try {
            start = df.parse(startstr);
            end = df.parse(endstr);
        } catch (ParseException e) {
            logger.error("日期解析出错===================");
        }
        request.setAttribute("DateList", infoService.datetoPage(curnum, start, end));
        return "/list";
    }
}

