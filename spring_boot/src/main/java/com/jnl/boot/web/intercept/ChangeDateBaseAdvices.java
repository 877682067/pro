package com.jnl.boot.web.intercept;


import com.jnl.boot.utils.ibatis.Ibatis;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*@Component
@Aspect*/
public class ChangeDateBaseAdvices {
    private boolean ischange = false;
    @Before("execution(* com.jnl.boot.web.*.*(..))")
    public void before(JoinPoint jp){
        Object[] args = jp.getArgs();
        for(Object arg:args){
            if(arg instanceof GatherBuildInfo){
                GatherBuildInfo info = (GatherBuildInfo)arg;
                Ibatis.getInstance().changeDataBase(info.getDataBase());
                ischange = true;
                break;
            }
        }
    }

    @After("execution(* com.jnl.boot.web.*.*(..))")
    public void after(JoinPoint jp){
        if(ischange){
            Ibatis.getInstance().reduction();
        }
    }
}
