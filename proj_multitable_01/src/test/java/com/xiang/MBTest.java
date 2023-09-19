package com.xiang;

import com.xiang.mapper.CustomerMapper;
import com.xiang.mapper.OrderMapper;
import com.xiang.pojo.Customer;
import com.xiang.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MBTest {

    private SqlSession session;

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mb_config.xml")).openSession();
    }


    @Test
    public void test1() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void test2() {
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println(customers);
    }


    @AfterEach
    public void clean() {
        session.close();
    }
}
