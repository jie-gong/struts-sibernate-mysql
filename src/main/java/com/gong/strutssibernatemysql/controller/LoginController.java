package com.gong.strutssibernatemysql.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong.strutssibernatemysql.mapper.LoginMapper;
import com.gong.strutssibernatemysql.pojo.T_user;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class LoginController {
    @Resource
    private LoginMapper adminService;


    //登陆测试
    @RequestMapping("/user/login")
    public ModelAndView Login(String username,
                              String password,
                              Model model,
                              HttpSession session) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username", username);
        objectObjectHashMap.put("password", password);
        List<T_user> t_users = adminService.selectByMap(objectObjectHashMap);
        ModelAndView mv = new ModelAndView();
        //判断账号密码
        if (t_users.size()==0) {
            //告诉用户登录失败
            model.addAttribute("msg", "用户名或密码错误");
            mv.setViewName("index");
        } else {
            session.setAttribute("LoginUser", username);
            model.addAttribute("username", username);
            mv.addObject("admin", t_users);
            System.out.println("登录成功测试");
            mv.setViewName("redirect:/main.html");
        }
        return mv;
    }
}