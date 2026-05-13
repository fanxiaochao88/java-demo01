package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有的部门
     */
    List<Dept> findAll();

    /**
     * 根据id删除部门
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 查询部门
     * @param id
     */
    Dept findById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
