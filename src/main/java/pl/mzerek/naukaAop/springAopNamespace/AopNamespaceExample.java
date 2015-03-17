package pl.mzerek.naukaAop.springAopNamespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context2.xml");
		ctx.refresh();
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();

	}

}
