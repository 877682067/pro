package ${packag}.controller;

import ${packag}.service.*;
import ${packag}.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/${name}")
public class ${name?cap_first}Controller{

    <#assign service = name+"Service"/>
    @Autowired
    private I${name?cap_first}Service ${service};

    @RequestMapping("/list")
    public ModelAndView list( ${name?cap_first}  ${name}){
        ModelAndView view = new ModelAndView();
        List<${name?cap_first}> ${name}List =  ${service}.list(${name});
        view.addObject("data",${name}List);
        view.setViewName("${name}/list");
        return view;
    }

    @RequestMapping("/detail")
    public ModelAndView detail( ${name?cap_first} param){
        ModelAndView view = new ModelAndView();
        ${name?cap_first} ${name} = ${service}.get${name?cap_first}ById(param.getId());
        view.setViewName("${name}/detail");
        view.addObject("${name}",${name});
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ${name?cap_first} update( ${name?cap_first} ${name}){
        ${service}.update(${name});
        return ${name};
    }

    @RequestMapping("/add")
    @ResponseBody
    public ${name?cap_first} add( ${name?cap_first} ${name}){
        ${service}.insert(${name});
        return ${name};
    }

    @RequestMapping("/toadd")
    public ModelAndView toadd( ${name?cap_first} ${name}){
        ModelAndView view = new ModelAndView();
        view.setViewName("${name}/add");
        return view;
    }
    @RequestMapping("/toupdate")
    public ModelAndView toupdate( ${name?cap_first} param){
        ModelAndView view = new ModelAndView();
        ${name?cap_first} ${name} = ${service}.get${name?cap_first}ById(param.getId());
        view.setViewName("${name}/add");
        view.addObject("${name}",${name});
        return view;
    }
}