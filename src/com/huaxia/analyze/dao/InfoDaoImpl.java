/**
 * Project Name:SpringMVC_Analyze
 * File Name:InfoDaoImpl.java
 * Package Name:com.huaxia.analyze.dao
 * Date:2017-3-1下午12:11:59
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia.analyze.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huaxia.analyze.bean.AnalyzeInfo;

/**
 * ClassName: InfoDaoImpl <br/>
 * Date: 2017-3-1 下午12:11:59 <br/>
 * Description: 日志信息dao实现类
 * 
 * @author fangm
 * @version
 * @see
 */
@Repository
public class InfoDaoImpl implements InfoDao {
    // 注入已在spring-common.xml中配制好的sessionFactory
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public AnalyzeInfo getAnalyzeInfo(Integer id) {
        String hql = "from getAnalyzeInfo a where a.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setLong(0, id);
        return (AnalyzeInfo) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnalyzeInfo> getInfo() {
        String hql = "from AnalyzeInfo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addInfo(AnalyzeInfo Info) {
        sessionFactory.getCurrentSession().save(Info);

    }

    @Override
    public boolean delInfo(String id) {
        String hql = "delete AnalyzeInfo a where a.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateInfo(AnalyzeInfo Info) {
        String hql = "update AnalyzeInfo a set a.id = ?,a.date = ?,a.hour = ?,a.operate = ?,a.inter = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setLong(0, Info.getId());
        query.setDate(1, Info.getDate());
        query.setString(2, Info.getHour());
        query.setString(3, Info.getOperate());
        query.setString(4, Info.getInter());
        return (query.executeUpdate() > 0);
    }

    @Override
    public int getTotalRows() {
        String hql = "select count(*) from AnalyzeInfo a";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return ((Number) query.uniqueResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnalyzeInfo> getInfoByPage(int curnum) {
        String hql = "from AnalyzeInfo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((curnum - 1) * 10);
        query.setMaxResults(10); // 每页显示10条
        List<AnalyzeInfo> list = (List<AnalyzeInfo>) query.list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnalyzeInfo> datetoPage(int curnum, Date start, Date end) {
        String hql = "from AnalyzeInfo a where a.date >= ? and a.date <= ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setDate(0, start);
        query.setDate(1, end);
        
        query.setFirstResult((curnum - 1) * 10);
        query.setMaxResults(10); // 每页显示10条
        List<AnalyzeInfo> list = (List<AnalyzeInfo>) query.list();
        return list;
    }

}

