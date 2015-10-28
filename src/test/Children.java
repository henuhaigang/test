package test;

public class Children extends Parent {
	public Children(){}
	public Children(String a,String b){
		super(a,b);
	}
	public void print(){
		System.out.println(one + "to"+two);
	//	shili();
	}
	public void diaoyong(){
		shili();
	}
	public static void main(String[] args) {
		Parent p=new Parent("south","north");
		Parent t=new Children("east","west");
		p.print();
		t.print();
		Children c=new Children();
		c.diaoyong();
	}
}
