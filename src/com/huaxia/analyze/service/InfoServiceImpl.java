/**
 * Project Name:SpringMVC_Analyze
 * File Name:InfoServiceImpl.java
 * Package Name:com.huaxia.analyze.service
 * Date:2017-3-1下午12:23:04
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.analyze.bean.AnalyzeInfo;
import com.huaxia.analyze.dao.InfoDao;

/**
 * ClassName: InfoServiceImpl <br/>
 * Date: 2017-3-1 下午12:23:04 <br/>
 * Description: InfoService实现类
 * 
 * @author fangm
 * @version
 * @see
 */
@Service
public class InfoServiceImpl implements InfoService {
    private static Logger logger = Logger.getLogger(InfoServiceImpl.class);

    @Autowired
    private InfoDao infoDao;

    @Override
    public List<AnalyzeInfo> analyze() {
        try {
            // data目录不能放在根目录下，只有放在WEB-INF下才能部署到Tomcat上
            String path = this.getClass().getClassLoader().getResource("/").getPath();
            String pathnow = path.replace("/classes/", "");
            System.out.println(pathnow);
            BufferedReader br = new BufferedReader(new FileReader(pathnow
                    + "/data/handles.log.2015-12-20"));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String line = null;
            ArrayList<AnalyzeInfo> list = new ArrayList<AnalyzeInfo>();
            AnalyzeInfo an = new AnalyzeInfo();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("INFO")) {
                    String[] split = line.split(" ");
                    String datestr = split[1] + " " + split[2];
                    Date date = df.parse(datestr);
                    int h = date.getHours();// 获取当前小时
                    String operate = split[5].startsWith("REQUEST") ? "REQUEST" : "RESPONSE";
                    String inter = line.substring(
                            line.indexOf("<req_service>") + "<req_service>".length(),
                            line.indexOf("</req_service>"));
                    an.setDate(date);
                    an.setHour(h + "");
                    an.setInter(inter);
                    an.setOperate(operate);
                    list.add(an);
                    an = new AnalyzeInfo();
                    /*
                     * String reqtime = line.substring( line.indexOf("<req_time>") +
                     * "<req_time>".length(), line.indexOf("</req_time>"));
                     */

                    /*
                     * String IP = line.substring(line.lastIndexOf("[") + 1,
                     * line.lastIndexOf("]"));
                     */
                }
            }
            return list;
        } catch (Exception e) {
            logger.error("日期解析出错===================");
        }
        return null;
    }

    @Override
    public void save(AnalyzeInfo info) {
        infoDao.addInfo(info);
    }

    @Override
    public void saveAll(List<AnalyzeInfo> list) {
        for (AnalyzeInfo analyzeInfo : list) {
            save(analyzeInfo);
        }
    }

    @Override
    public AnalyzeInfo getInfo(String id) {
        return null;
    }

    @Override
    public List<AnalyzeInfo> getAllInfo() {
        return null;
    }

    @Override
    public int getTotalRows() {
        return infoDao.getTotalRows();
    }

    @Override
    public List<AnalyzeInfo> getInfoByPage(int curnum) {
        List<AnalyzeInfo> list = infoDao.getInfoByPage(curnum);
        return list;
    }

    @Override
    public List<AnalyzeInfo> datetoPage(int curnum, Date start, Date end) {
        if (start != null && end != null) {
        List<AnalyzeInfo> list = infoDao.datetoPage(curnum, start, end);
            return list;
        }
        return null;
    }

}

