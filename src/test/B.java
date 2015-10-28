package test;

public class B extends A {
//	void m() {
//		super.m();
//	}

	B(){
		System.out.println("b consturct");
	}
	void show(){
		System.out.println("I¡¡£ì£ï£ö£å¡¡£ã£«£«");
	}
	public static void main(String[] args) {
//	A a= new A();
//	B b=new B();
	//a.show();
//	b.show();
	A c= new B();
	c.show();
//		A a = new B();
//		a.m();
	}
}
