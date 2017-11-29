

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DacymalProxyFactory implements InvocationHandler {

	private Object target = null;
	
	public Object createProxy(Object target)
	{
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object reObj = method.invoke(target, args);
		System.out.println("chuli");
		return reObj;
	}
	
	public static void main(String[] args)
	{
		
		Person zhangsan = new Person("张三", "16");
		DacymalProxyFactory proxyFactory = new DacymalProxyFactory();
		Biology ps = (Biology) proxyFactory.createProxy(zhangsan);
		System.out.println(ps.getName());
	}
}
