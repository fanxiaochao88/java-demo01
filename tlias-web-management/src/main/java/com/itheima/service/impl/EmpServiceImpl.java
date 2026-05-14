package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 获取总数
        Long count = empMapper.count();
        // 获取分页数据
        Integer start = (page - 1) * pageSize;
        List<Emp> list = empMapper.page(start, pageSize);
        // 封装PageResult并返回
        return new PageResult<Emp>(count, list);
    }
}
