package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理controller
 */
@RequiredArgsConstructor
@RequestMapping("/emps")
@RestController
@Slf4j
public class EmpController {

    private final EmpService empService;

    /**
     * 员工列表
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询员工数据，当前页码：{}，每页记录数：{}", page, pageSize);
        return Result.success(empService.page(page, pageSize));
    }
}
