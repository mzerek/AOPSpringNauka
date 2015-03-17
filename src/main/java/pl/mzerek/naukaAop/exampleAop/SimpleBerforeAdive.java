package pl.mzerek.naukaAop.exampleAop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBerforeAdive implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object target)
			throws Throwable {
		System.out.println("Before method : " + method.getName());

	}

}
