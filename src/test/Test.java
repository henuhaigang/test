package test;

public class Test {
	
	void test(int i){
		System.out.println("i am int");
	}
	void test(String s){
		System.out.println("i am string");
	}
	public static void main(String[] args) {
//		System.out.println("ok");
		Test t=new Test();
		char ch='y';
		t.test(ch);
	}

}
