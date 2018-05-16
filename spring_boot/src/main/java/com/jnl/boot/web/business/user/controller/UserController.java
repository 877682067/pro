package com.jnl.boot.web.business.user.controller;

import com.jnl.boot.web.business.user.service.*;
import com.jnl.boot.web.business.user.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public ModelAndView list( User  user){
        ModelAndView view = new ModelAndView();
        List<User> userList =  userService.list(user);
        view.addObject("data",userList);
        view.setViewName("user/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( User param){
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(param.getId());
        view.setViewName("user/detail");
        view.addObject("user",user);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public User update( User user){
        userService.update(user);
        return user;
    }

    @RequestMapping("/add")
    @ResponseBody
    public User add( User user){
        userService.insert(user);
        return user;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( User user){
        ModelAndView view = new ModelAndView();
        view.setViewName("user/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( User param){
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(param.getId());
        view.setViewName("user/add");
        view.addObject("user",user);
        return view;
    }
}