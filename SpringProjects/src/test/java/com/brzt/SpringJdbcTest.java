package com.brzt;

import com.brzt.dao.MembersDao;
import com.brzt.entity.Members;
import com.brzt.impl.MembersImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author puhome
 * @data 2020/7/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
public class SpringJdbcTest {

    @Autowired(required = false)
    @Qualifier("membersImpl")
    private MembersDao membersDao=null;

    @Test
    public void jdbcTest() throws PropertyVetoException {
        //准备连接池
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://47.96.145.149:3306/springTest?useSSL=false&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //创建连接池
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //执行sql
        String sql="insert into Members values(null,'王先生',23)";
        jdbcTemplate.update(sql);
    }

    @Test
    public void  jdbcTemplateTest() throws Exception {

        Members members = new Members();
        members.setName("李李");
        members.setAge(20);
        membersDao.add(members);
    }
}
