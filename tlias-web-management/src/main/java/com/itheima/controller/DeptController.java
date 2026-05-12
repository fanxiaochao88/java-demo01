package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DeptController {

    private final DeptService deptService;

    // @RequestMapping(value = "/deps", method = RequestMethod.GET)
    @GetMapping("/deps")
    public Result list() {
        System.out.println("查询全部的部门数据-controller");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
