package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 1. 补全部门的创建时间和更新时间
        dept.setCreateTime(java.time.LocalDateTime.now());
        dept.setUpdateTime(java.time.LocalDateTime.now());
        // 2. 调用mapper接口新增部门数据
        deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return  deptMapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        // 1. 补全部门的更新时间
        dept.setUpdateTime(java.time.LocalDateTime.now());
        // 2. 调用mapper接口修改部门数据
        deptMapper.update(dept);
    }
}
