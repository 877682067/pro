package com.jnl.boot.web.business.resourceUser.controller;

import com.jnl.boot.web.business.resourceUser.service.*;
import com.jnl.boot.web.business.resourceUser.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/resourceUser")
public class ResourceUserController{

    @Autowired
    private IResourceUserService resourceUserService;

    @RequestMapping("/list")
    public ModelAndView list( ResourceUser  resourceUser){
        ModelAndView view = new ModelAndView();
        List<ResourceUser> resourceUserList =  resourceUserService.list(resourceUser);
        view.addObject("data",resourceUserList);
        view.setViewName("resourceUser/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( ResourceUser param){
        ModelAndView view = new ModelAndView();
        ResourceUser resourceUser = resourceUserService.getResourceUserById(param.getId());
        view.setViewName("resourceUser/detail");
        view.addObject("resourceUser",resourceUser);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResourceUser update( ResourceUser resourceUser){
        resourceUserService.update(resourceUser);
        return resourceUser;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResourceUser add( ResourceUser resourceUser){
        resourceUserService.insert(resourceUser);
        return resourceUser;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( ResourceUser resourceUser){
        ModelAndView view = new ModelAndView();
        view.setViewName("resourceUser/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( ResourceUser param){
        ModelAndView view = new ModelAndView();
        ResourceUser resourceUser = resourceUserService.getResourceUserById(param.getId());
        view.setViewName("resourceUser/add");
        view.addObject("resourceUser",resourceUser);
        return view;
    }
}