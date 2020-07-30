package com.brzt.dao;

import com.brzt.entity.Members;

import java.util.List;

/**
 * @author puhome
 * @data 2020/7/29
 */
public interface MembersDao {

    void add(Members members) throws Exception;

    void del(int id) throws Exception;

    void update(Members members) throws Exception;

    Members getById(int id) throws Exception;

    List<Members> getAll() throws Exception;

    int getCount() throws Exception;

    void addAge(int id,int age) throws Exception;

    void subAge(int id,int age) throws Exception;
}
