package com.jnl.boot.web.business.userGroup.controller;

import com.jnl.boot.web.business.userGroup.service.*;
import com.jnl.boot.web.business.userGroup.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/userGroup")
public class UserGroupController{

    @Autowired
    private IUserGroupService userGroupService;

    @RequestMapping("/list")
    public ModelAndView list( UserGroup  userGroup){
        ModelAndView view = new ModelAndView();
        List<UserGroup> userGroupList =  userGroupService.list(userGroup);
        view.addObject("data",userGroupList);
        view.setViewName("userGroup/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( UserGroup param){
        ModelAndView view = new ModelAndView();
        UserGroup userGroup = userGroupService.getUserGroupById(param.getId());
        view.setViewName("userGroup/detail");
        view.addObject("userGroup",userGroup);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public UserGroup update( UserGroup userGroup){
        userGroupService.update(userGroup);
        return userGroup;
    }

    @RequestMapping("/add")
    @ResponseBody
    public UserGroup add( UserGroup userGroup){
        userGroupService.insert(userGroup);
        return userGroup;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( UserGroup userGroup){
        ModelAndView view = new ModelAndView();
        view.setViewName("userGroup/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( UserGroup param){
        ModelAndView view = new ModelAndView();
        UserGroup userGroup = userGroupService.getUserGroupById(param.getId());
        view.setViewName("userGroup/add");
        view.addObject("userGroup",userGroup);
        return view;
    }
}