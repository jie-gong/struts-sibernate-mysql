package com.gong.strutssibernatemysql.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.gong.strutssibernatemysql.mapper.UserMapper;
import com.gong.strutssibernatemysql.pojo.Student;
//import com.gong.strutssibernatemysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * username：公杰
 * data ：   2022,7
 */
@Controller
public class EmployeeController {
    @Autowired
    public UserMapper userMapper;

    //    @RequestMapping("/emps")
//    public String list(Model model){
//        Collection<Employee> employee = employeeDao.getAll();
//        model.addAttribute("emps",employee);
//        return "emp/list";
//    }

    /**
     * 跳转添加学生页面
     *
     * @return
     */
    @GetMapping("/emp")
    public String toAddPager() {
        /**
         * 添加学生
         * 跳转页面
         */
        return "emp/add";
    }

    /**
     * 添加运功操作  调用底层原理
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp2")
    public String addEmp(Student employee) {
        //添加的操作
        userMapper.insert(employee);//调用底层业务方法 保存员工信息
        //重定向到查询全部数据
        //人话：添加完毕返回查询界面
        return "redirect:/emps";
    }

    /**
     * 测试代码块
     *
     * @return
     */
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello word";
    }

    /**
     * 查询全部学生
     * Wrapper 方法没有条件 null
     *
     * @param model
     * @return
     */
    //查询全部学生
    @RequestMapping("/emps")
    public String allStudent(Model model) {
        List<Student> students = userMapper.selectList(null);
//        students.forEach(System.out::println);
        model.addAttribute("emps", students);
        return "emp/list";
    }

    //删除学生数据
    @GetMapping("/delemp/{id}")
    public String DeleteEmp(@PathVariable("id") int id) {
        userMapper.deleteById(id);
        //重定向回查询界面
        return "redirect:/emps";
    }

    /**
     * 条件查询  通过id查询获取全部内容
     * 通过模板引擎将后端内容全部显示在前端页面
     *
     * @param id
     * @param model
     * @return
     */
    //跳转修改学生数据
    @GetMapping("/emp/{id}")
    public String Lite(@PathVariable("id") int id, Model model) {
        //查询学生数据
        QueryWrapper<Student> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id);
        //能且只能查询一条数据 ，无法查询多个数据 多条数据使用list后者map查询
        Student student = userMapper.selectOne(userQueryWrapper);
        model.addAttribute("emp2", student);
        System.out.println(student);
        return "emp/update";
    }

    //修改学生数据
    @PostMapping("/update")
    public String UpDateStudent(Student student) {
        System.out.println(student);
        int i = userMapper.updateById(student);
        System.out.println(i);
        return "redirect:/emps";
    }
}
