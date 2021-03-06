package pl.mzerek.naukaAop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	@Pointcut("execution(* pl.mzerek.naukaAop.annotation..foo*(int)) && args(intValue)")
	public void fooExecution(int intValue) {
	}

	@Pointcut("bean(myDependency*)")
	public void inMyDependency() {
	}

	@Before("fooExecution(intValue) && inMyDependency()")
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		if (intValue != 100) {
			System.out.println("Executing: "
					+ joinPoint.getSignature().getDeclaringTypeName() + " "
					+ joinPoint.getSignature().getName() + " argument: "
					+ intValue);
		}
	}

	@Around("fooExecution(intValue) && inMyDependency()")
	public Object simpleAroungAdvice(ProceedingJoinPoint pjp, int intValue)
			throws Throwable {
		System.out.println("Before execution: "
				+ pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName() + " argument: " + intValue);

		Object retVal = pjp.proceed();

		System.out.println("After execution: "
				+ pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName() + " argument: " + intValue);
		return retVal;
	}

}
