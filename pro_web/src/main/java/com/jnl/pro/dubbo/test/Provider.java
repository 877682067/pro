package com.jnl.pro.dubbo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Provider {
    public static void main(String[] args) throws Exception {
      /*  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"classpath:dubbo_provider.xml"});
        context.start();
        System.in.read();*/

      Map<String,String> m = new HashMap<String,String>();
      m.put("A","a");
      m.put("b","a");
      m.put("c","a");
      Iterator<String> iterator = m.keySet().iterator();
      while(iterator.hasNext()) {
          String next = iterator.next();
          if("A".equals(next)){
              iterator.remove();
          }
          System.out.print(next);
      }
    }
}
