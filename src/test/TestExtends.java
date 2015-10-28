package test;

public class TestExtends {
public static void main(String[] args) {
	Test1 t1=new Test2();
	t1.test1();
	t1.test2();
	System.out.println(t1.i);
	t1=(Test1)t1;
	t1.test2();
}
	
}
