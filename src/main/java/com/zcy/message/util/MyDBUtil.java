package com.zcy.message.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyDBUtil {
    public static SqlSession getSqlSession() throws IOException {
        String resource= "mybatis-config.xml";
        //1.通过配置文件获取数据库连接信息
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //Reader reader=Resources.getResourceAsReader(resource);
        //2，通过配置信息构建一个SqlSessionFacory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //3，通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //返回会话
        return sqlSession;
    }
}
