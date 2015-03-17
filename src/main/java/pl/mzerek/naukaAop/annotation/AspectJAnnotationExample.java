package pl.mzerek.naukaAop.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context3.xml");
		ctx.refresh();
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();

	}

}
