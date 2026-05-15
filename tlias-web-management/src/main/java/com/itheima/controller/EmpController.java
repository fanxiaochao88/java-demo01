package com.itheima.controller;

import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询员工数据，{}，", empQueryParam);
        return Result.success(empService.page(empQueryParam));
    }
}
