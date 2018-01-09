package com.jnl.pro.dubbo.impl;

import com.jnl.pro.dubbo.DemoService;

public class DemoServiceImpl implements DemoService {
    String [] enums = new String[1];
    @Override
    public String sayHello(String name) {

        return "Hello,"+name+enums[1];
    }
}
