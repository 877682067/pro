package com.jnl.boot.web.business.role.controller;

import com.jnl.boot.web.business.role.service.*;
import com.jnl.boot.web.business.role.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController{

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list( Role  role){
        ModelAndView view = new ModelAndView();
        List<Role> roleList =  roleService.list(role);
        view.addObject("data",roleList);
        view.setViewName("role/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( Role param){
        ModelAndView view = new ModelAndView();
        Role role = roleService.getRoleById(param.getId());
        view.setViewName("role/detail");
        view.addObject("role",role);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Role update( Role role){
        roleService.update(role);
        return role;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Role add( Role role){
        roleService.insert(role);
        return role;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( Role role){
        ModelAndView view = new ModelAndView();
        view.setViewName("role/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( Role param){
        ModelAndView view = new ModelAndView();
        Role role = roleService.getRoleById(param.getId());
        view.setViewName("role/add");
        view.addObject("role",role);
        return view;
    }
}