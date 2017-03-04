/**
 * Project Name:SpringMVC_Analyze
 * File Name:AnalyzeDaoImpl.java
 * Package Name:com.huaxia.analyze.dao
 * Date:2017-2-28上午10:25:23
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huaxia.analyze.bean.AnalyzeLogBean;

/**
 * ClassName: AnalyzeDaoImpl <br/>
 * Date: 2017-2-28 上午10:25:23 <br/>
 * Description: 日志统计dao实现类
 * 
 * @author fangm
 * @version
 * @see
 */

@Repository
public class AnalyzeDaoImpl implements AnalyzeDao {

    // 注入已在spring-common.xml中配制好的sessionFactory
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public AnalyzeLogBean getAnalyze(Integer id) {
        String hql = "from AnalyzeLogBean a where a.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setLong(0, id);
        return (AnalyzeLogBean) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnalyzeLogBean> getAllAnalyze() {
        String hql = "from AnalyzeLogBean";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addAnalyze(AnalyzeLogBean analyze) {
        sessionFactory.getCurrentSession().save(analyze);

    }

    @Override
    public boolean delAnalyze(String id) {
        String hql = "delete AnalyzeLogBean a where a.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateAnalyze(AnalyzeLogBean analyze) {
        String hql = "update AnalyzeLogBean a set a.id = ?,a.date = ?,a.hour = ?,a.requestXMLTimes = ?,a.responseXMLTimes = ?,a.requestServiceTimes = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setLong(0, analyze.getId());
        query.setDate(1, analyze.getDate());
        query.setString(2, analyze.getHour());
        query.setLong(3, analyze.getRequestXMLTimes());
        query.setLong(4, analyze.getResponseXMLTimes());
        query.setLong(5, analyze.getRequestServiceTimes());
        return (query.executeUpdate() > 0);
    }

}

