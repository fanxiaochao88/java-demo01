package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    /**
     * 总记录数
     */
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    public Long count();

    /**
     * 分页查询
     */
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id" +
//            " order by emp.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * pageHelper分页
     */
    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id" +
            " order by emp.update_time desc")
    public List<Emp> page();
}
