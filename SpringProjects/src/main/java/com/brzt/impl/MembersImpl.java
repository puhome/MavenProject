package com.brzt.impl;

import com.brzt.dao.MembersDao;
import com.brzt.entity.Members;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author puhome
 * @data 2020/7/29
 */
public class MembersImpl implements MembersDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Members members)  throws Exception{
        String sql="insert into Members values(null,?,?)";
        jdbcTemplate.update(sql,members.getName(),members.getAge());
    }

    @Override
    public void del(int id)  throws Exception{
        String sql="delete from Members where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Members members)  throws Exception{
        String sql="update members set name=?,age=? where id=?";
        jdbcTemplate.update(sql,members.getName(),members.getAge(),members.getId());
    }

    @Override
    public Members getById(int id)  throws Exception{
        Members members;
        String sql = "select * from members where id=?";
        members = jdbcTemplate.queryForObject(sql, new RowMapper<Members>() {
            @Override
            public Members mapRow(ResultSet resultSet, int i) throws SQLException {
                Members members1 = new Members();
                members1.setId(resultSet.getInt("id"));
                members1.setName(resultSet.getString("name"));
                members1.setAge(resultSet.getInt("age"));
                return members1;
            }
        });
        return members;
    }

    @Override
    public List<Members> getAll()  throws Exception{
        List list = null;
        String sql = "select * from Members";
        list = jdbcTemplate.query(sql, new RowMapper<Members>() {
            @Override
            public Members mapRow(ResultSet resultSet, int i) throws SQLException {
                Members members = new Members();
                members.setId(resultSet.getInt("id"));
                members.setName(resultSet.getString("name"));
                members.setAge(resultSet.getInt("aget"));
                return members;
            }
        });
        return list;
    }

    @Override
    public int getCount()  throws Exception{
        String sql="select count(*) from Members";
        return  jdbcTemplate.queryForObject(sql,int.class);
    }

    public JdbcTemplate getJdbcTemplate()  throws Exception{
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)  throws Exception{
        this.jdbcTemplate = jdbcTemplate;
    }
}
