package pl.mzerek.naukaAop.springAopNamespace;

public class MyDependency {
	
	public void foo(int intValue) {
		System.out.println("foo(int): " + intValue);
	}

	public void bar() {
		System.out.println("bar()");
	}
	
}