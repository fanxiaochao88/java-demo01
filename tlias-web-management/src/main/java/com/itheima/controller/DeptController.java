package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts") // 统一的接口前缀
@RequiredArgsConstructor
@RestController
public class DeptController {

    private final DeptService deptService;

    // @RequestMapping(value = "/deps", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        System.out.println("查询全部的部门数据-controller");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        Integer id = Integer.parseInt(idStr);
//        System.out.println("删除部门数据-controller: " + id);
//        return Result.success();
//    }
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer id) { // 参数默认必传
//        System.out.println("删除部门数据-controller--: " + id);
//        return Result.success();
//    }
    @DeleteMapping
    public Result delete(Integer id) { // 参数相同直接接收, 前端传递的参数名和服务端名字一样, ?查询字符串传递进来的
        System.out.println("删除部门数据-controller--: " + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) { // 请求体传递进来的数据
        System.out.println("保存部门数据-controller--: " + dept);
        deptService.add(dept);
        return Result.success();
    }

    // 根据id获取部门
    @GetMapping("/{id}") // 标识id是路径参数
    public Result getById(@PathVariable Integer id) { // 路径参数传递进来的数据
        System.out.println("根据id获取部门数据-controller--: " + id);
        return Result.success(deptService.findById(id));
    }

    // 修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门数据-controller--: " + dept);
        deptService.update(dept);
        return Result.success();
    }
}
