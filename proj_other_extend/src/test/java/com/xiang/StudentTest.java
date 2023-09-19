package com.xiang;


import com.github.pagehelper.PageHelper;
import com.xiang.mapper.StudentMapper;
import com.xiang.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class StudentTest {

    private SqlSession session;

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mb_config.xml")).openSession();
    }


    @Test
    public void test1() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        PageHelper.startPage(1,2);
        List<Student> students = mapper.queryAll();

        System.out.println(students);
    }


    @AfterEach
    public void clean() {
        session.close();
    }
}

