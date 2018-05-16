package com.jnl.boot.web.business.roleUser.controller;

import com.jnl.boot.web.business.roleUser.service.*;
import com.jnl.boot.web.business.roleUser.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/roleUser")
public class RoleUserController{

    @Autowired
    private IRoleUserService roleUserService;

    @RequestMapping("/list")
    public ModelAndView list( RoleUser  roleUser){
        ModelAndView view = new ModelAndView();
        List<RoleUser> roleUserList =  roleUserService.list(roleUser);
        view.addObject("data",roleUserList);
        view.setViewName("roleUser/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( RoleUser param){
        ModelAndView view = new ModelAndView();
        RoleUser roleUser = roleUserService.getRoleUserById(param.getId());
        view.setViewName("roleUser/detail");
        view.addObject("roleUser",roleUser);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public RoleUser update( RoleUser roleUser){
        roleUserService.update(roleUser);
        return roleUser;
    }

    @RequestMapping("/add")
    @ResponseBody
    public RoleUser add( RoleUser roleUser){
        roleUserService.insert(roleUser);
        return roleUser;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( RoleUser roleUser){
        ModelAndView view = new ModelAndView();
        view.setViewName("roleUser/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( RoleUser param){
        ModelAndView view = new ModelAndView();
        RoleUser roleUser = roleUserService.getRoleUserById(param.getId());
        view.setViewName("roleUser/add");
        view.addObject("roleUser",roleUser);
        return view;
    }
}