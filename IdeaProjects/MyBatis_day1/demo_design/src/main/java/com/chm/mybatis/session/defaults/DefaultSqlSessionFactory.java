package com.chm.mybatis.session.defaults;

import com.chm.mybatis.cfg.Configuration;
import com.chm.mybatis.session.SqlSession;
import com.chm.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
