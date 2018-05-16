package com.jnl.boot.web.business.login;

import com.jnl.boot.web.exception.NotAuthenticationAccountException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView toLogin(Boolean error,String errorMsg){
        ModelAndView mov = new ModelAndView("/login/login");

        return mov;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mov = new ModelAndView("/login/index");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);
        if( !subject.isAuthenticated() ){
            subject.login(token);
        }

        return mov;
    }

    @RequestMapping("/loginOut")
    public ModelAndView loginOut(){
        ModelAndView mov = new ModelAndView("login");
        return mov;
    }
    @RequestMapping("/error")
    public ModelAndView erro(HttpServletRequest request){
        ModelAndView mov = new ModelAndView("/login/erro");
        String exceptionClass = (String)request.getAttribute("shiroLoginFailure");
        String errorMsg = null;
        if(UnknownAccountException.class.getName().equals(exceptionClass)){
            mov.setViewName("/");
            errorMsg = "用户名/密码错误";
        }else if(LockedAccountException.class.getName().equals(exceptionClass)){
            mov.setViewName("/");
            errorMsg = "账户已被锁定，请稍后再试！";
        }else if(NotAuthenticationAccountException.class.getName().equals(exceptionClass)){
            errorMsg = "未验证！";
            mov.setViewName("/auth");
        }
        mov.addObject("errorMsg",errorMsg);
        mov.addObject("error",errorMsg);
        return mov;
    }
}
