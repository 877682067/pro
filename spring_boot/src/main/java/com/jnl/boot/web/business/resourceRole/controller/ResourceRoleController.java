package com.jnl.boot.web.business.resourceRole.controller;

import com.jnl.boot.web.business.resourceRole.service.*;
import com.jnl.boot.web.business.resourceRole.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/resourceRole")
public class ResourceRoleController{

    @Autowired
    private IResourceRoleService resourceRoleService;

    @RequestMapping("/list")
    public ModelAndView list( ResourceRole  resourceRole){
        ModelAndView view = new ModelAndView();
        List<ResourceRole> resourceRoleList =  resourceRoleService.list(resourceRole);
        view.addObject("data",resourceRoleList);
        view.setViewName("resourceRole/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( ResourceRole param){
        ModelAndView view = new ModelAndView();
        ResourceRole resourceRole = resourceRoleService.getResourceRoleById(param.getId());
        view.setViewName("resourceRole/detail");
        view.addObject("resourceRole",resourceRole);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResourceRole update( ResourceRole resourceRole){
        resourceRoleService.update(resourceRole);
        return resourceRole;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResourceRole add( ResourceRole resourceRole){
        resourceRoleService.insert(resourceRole);
        return resourceRole;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( ResourceRole resourceRole){
        ModelAndView view = new ModelAndView();
        view.setViewName("resourceRole/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( ResourceRole param){
        ModelAndView view = new ModelAndView();
        ResourceRole resourceRole = resourceRoleService.getResourceRoleById(param.getId());
        view.setViewName("resourceRole/add");
        view.addObject("resourceRole",resourceRole);
        return view;
    }
}