package com.jnl.boot.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * 自定义shiro realm
 * @author lijianan
 *
 */
public class ShiroTestRealm implements Realm {

	public String getName() {
		return "testRealm";
	}
	/**
	 * 判断是否支持token类型的身份认证
	 */
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//用户名
		String username = token.getPrincipal().toString();
		//密码
		String passWord = new String((char[])token.getCredentials());
		return new SimpleAuthenticationInfo(username, passWord, getName());
	}

}
