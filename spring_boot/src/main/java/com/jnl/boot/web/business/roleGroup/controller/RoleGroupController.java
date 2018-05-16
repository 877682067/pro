package com.jnl.boot.web.business.roleGroup.controller;

import com.jnl.boot.web.business.roleGroup.service.*;
import com.jnl.boot.web.business.roleGroup.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/roleGroup")
public class RoleGroupController{

    @Autowired
    private IRoleGroupService roleGroupService;

    @RequestMapping("/list")
    public ModelAndView list( RoleGroup  roleGroup){
        ModelAndView view = new ModelAndView();
        List<RoleGroup> roleGroupList =  roleGroupService.list(roleGroup);
        view.addObject("data",roleGroupList);
        view.setViewName("roleGroup/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( RoleGroup param){
        ModelAndView view = new ModelAndView();
        RoleGroup roleGroup = roleGroupService.getRoleGroupById(param.getId());
        view.setViewName("roleGroup/detail");
        view.addObject("roleGroup",roleGroup);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public RoleGroup update( RoleGroup roleGroup){
        roleGroupService.update(roleGroup);
        return roleGroup;
    }

    @RequestMapping("/add")
    @ResponseBody
    public RoleGroup add( RoleGroup roleGroup){
        roleGroupService.insert(roleGroup);
        return roleGroup;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( RoleGroup roleGroup){
        ModelAndView view = new ModelAndView();
        view.setViewName("roleGroup/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( RoleGroup param){
        ModelAndView view = new ModelAndView();
        RoleGroup roleGroup = roleGroupService.getRoleGroupById(param.getId());
        view.setViewName("roleGroup/add");
        view.addObject("roleGroup",roleGroup);
        return view;
    }
}