package com.jnl.boot.web.build.controller;

import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.service.BuildService;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BuildController {

    @Autowired
    BuildService buildService;

    @RequestMapping("/")
    public ModelAndView toGatherInfo(HttpServletRequest request){
        //创建实体 Mapper  Mapper xml  增删改查页面
        return  new ModelAndView("input");
    }

    @RequestMapping("/build")
    public ModelAndView createInfo(GatherBuildInfo info, HttpServletRequest request){
        Table build = buildService.build(info);
        ModelAndView view = new ModelAndView("columnInput");
        view.addObject("table",build);
        return view;
    }
}
