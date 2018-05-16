package com.jnl.boot.web.business.resource.controller;

import com.jnl.boot.web.business.resource.service.*;
import com.jnl.boot.web.business.resource.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController{

    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/list")
    public ModelAndView list( Resource  resource){
        ModelAndView view = new ModelAndView();
        List<Resource> resourceList =  resourceService.list(resource);
        view.addObject("data",resourceList);
        view.setViewName("resource/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( Resource param){
        ModelAndView view = new ModelAndView();
        Resource resource = resourceService.getResourceById(param.getId());
        view.setViewName("resource/detail");
        view.addObject("resource",resource);
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Resource update( Resource resource){
        resourceService.update(resource);
        return resource;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Resource add( Resource resource){
        resourceService.insert(resource);
        return resource;
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( Resource resource){
        ModelAndView view = new ModelAndView();
        view.setViewName("resource/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( Resource param){
        ModelAndView view = new ModelAndView();
        Resource resource = resourceService.getResourceById(param.getId());
        view.setViewName("resource/add");
        view.addObject("resource",resource);
        return view;
    }
}