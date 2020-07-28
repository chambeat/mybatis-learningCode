package com.chm.mybatis.session;

import com.chm.mybatis.cfg.Configuration;
import com.chm.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.chm.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
