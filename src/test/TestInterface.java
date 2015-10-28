package test;

public class TestInterface implements ITestInterface {

	public   static int b=0;
	
	@Override
	public void myInterface() {
	//	a=a+1;
		System.out.println(a);
		b=b+1;
		System.out.println(b);
	}

	public static void main(String[] args) {
		new TestInterface().myInterface();
	}
}
