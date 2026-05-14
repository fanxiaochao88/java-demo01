package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.autoconfigure.PageHelperProperties;
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
//        // 获取总数
//        Long count = empMapper.count();
//        // 获取分页数据
//        Integer start = (page - 1) * pageSize;
//        List<Emp> list = empMapper.page(start, pageSize);
//        // 封装PageResult并返回
//        return new PageResult<Emp>(count, list);

        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 2. 执行查询
        List<Emp> list = empMapper.page();

        Page<Emp> p = (Page<Emp>) list;

        // 3. 封装PageResult并返回
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
