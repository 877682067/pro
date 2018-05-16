package com.jnl.boot.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jnl.boot.run.Application;

import junit.framework.Assert;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration*/
public class Test {
	
	@Autowired 
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	private static Subject subject;
	
	@Before
	public void setupMockMvc()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	//@org.junit.Test
	public void  test() {
		
		load("classpath:shiro.ini");
		login("zhang", "123");
		printList(subject.hasRoles(Arrays.asList("role2","role1")));
	/*	printList(subject.isPermitted("user:create","user:update"));*/
		subject.checkPermission("user:delete"); 
	}
	
	private static void printList(boolean[] hasRoles) {
		for(int i = 0;i<hasRoles.length;i++) {
			System.out.println(hasRoles[i]);
		}
		
	}
	public static void printList(Collection array) {
		Iterator iterator = array.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
	public static void load(String realmPath) {
		Factory<org.apache.shiro.mgt.SecurityManager> managerFactory = new IniSecurityManagerFactory(realmPath);
		SecurityManager manager = managerFactory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		subject = SecurityUtils.getSubject();
	}
	
	public static void login(String username,String password) {
		UsernamePasswordToken  token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
		}catch(AuthenticationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public  static void main(String[] args) {
		boolean[]  bol = {true,true};
		printList(bol);
	}
}
