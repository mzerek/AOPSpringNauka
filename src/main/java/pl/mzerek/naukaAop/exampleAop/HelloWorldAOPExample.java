package pl.mzerek.naukaAop.exampleAop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {
	public static void main(String[] args){
		MessageWriter target = new MessageWriter();
		
		MethodInterceptor md = new MessageDecorator();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(md);
		pf.setTarget(target);
		
		
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		
		//target.writeMessage();
		System.out.println();
		proxy.writeMessage();
		
		
		System.out.println("========================");
		
		MethodBeforeAdvice sba = new SimpleBerforeAdive();	
		pf.removeAdvice(md);
		pf.addAdvice(sba);
		//target.writeMessage();
		System.out.println();
		proxy.writeMessage();
		
		
		
	}
}
