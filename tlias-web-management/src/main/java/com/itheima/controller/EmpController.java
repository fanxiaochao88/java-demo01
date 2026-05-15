package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询员工数据，当前页码：{}，每页记录数：{}, 姓名: {}, 性别: {}, 开始日期: {}, 结束日期: {}",
                page, pageSize, name, gender, begin, end);
        return Result.success(empService.page(page, pageSize, name, gender, begin, end));
    }
}
