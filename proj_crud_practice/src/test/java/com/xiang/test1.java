package com.xiang;

import com.xiang.mapper.UserMapper;
import com.xiang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test1 {
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mb_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println(user);

    }
}
