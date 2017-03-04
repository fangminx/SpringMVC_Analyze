/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeServiceIml.java
 * Package Name:com.huaxia.analyze.service
 * Date:2017-2-28上午10:52:26
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */

package com.huaxia.analyze.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.analyze.bean.AnalyzeInfo;
import com.huaxia.analyze.bean.AnalyzeLogBean;
import com.huaxia.analyze.dao.AnalyzeDao;
import com.huaxia.analyze.dao.InfoDao;

/**
 * ClassName: AnalyzeServiceIml <br/>
 * Date: 2017-2-28 上午10:52:26 <br/>
 * Description: 日志分析service实现层
 * 
 * @author fangm
 * @version
 * @see
 */
@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Autowired
    private AnalyzeDao analyzeDao;

    @Autowired
    private InfoDao infoDao;

    @Override
    public ArrayList<AnalyzeLogBean> analyze() {
        
        List<AnalyzeInfo> infoList = infoDao.getInfo();
        ArrayList<AnalyzeLogBean> analyzeList = new ArrayList<AnalyzeLogBean>();
        AnalyzeLogBean analyzeLogBean = new AnalyzeLogBean();
        analyzeLogBean.setHour(0+"");
        //设置参数，方便统计
        int c_request = 0;
        int c_response = 0;
        int c_service = 0;
        for (int i=0;i<infoList.size();i++) {
            AnalyzeInfo info = infoList.get(i);
            String h1 = info.getHour();
            String h2 = analyzeLogBean.getHour();
            //附上第一条的日期
            if(null==analyzeLogBean.getDate()){
            	analyzeLogBean.setDate(info.getDate()); 
            }
            int size = infoList.size()-1;
            //这里字符串比较不能用"==",i!=size条件要在前两条加上，否则第三个判断的该条件无效
            if(h1.equals(h2) && "REQUEST".equals(info.getOperate()) && i!=size){
                c_request++;
                c_service++;
            }else if(h1.equals(h2) && "RESPONSE".equals(info.getOperate()) && i!=size){
                c_response++;
                c_service++;
            } else if (i == size || !h1.equals(h2)) {
                analyzeLogBean.setRequestServiceTimes(c_service);
                analyzeLogBean.setResponseXMLTimes(c_response);
                analyzeLogBean.setRequestXMLTimes(c_request);
                analyzeList.add(analyzeLogBean);
                 c_request = 0;
                 c_response = 0;
                 c_service = 0;
                 String h3 = analyzeLogBean.getHour();
                 analyzeLogBean = new AnalyzeLogBean();
                 analyzeLogBean.setHour((Integer.parseInt(h3)+1)+"");
            }
        }
        return analyzeList;
    }

    @Override
    public void save(AnalyzeLogBean analyze) {

        analyzeDao.addAnalyze(analyze);
    }

    @Override
    public void saveAll(List<AnalyzeLogBean> list) {
        for (AnalyzeLogBean analyzeLogBean : list) {
            save(analyzeLogBean);
        }

    }

    @Override
    public AnalyzeLogBean getAnaly(String id) {
        return null;
    }

    @Override
    public List<AnalyzeLogBean> getAllAnalyze() {
        return analyzeDao.getAllAnalyze();
    }

}
