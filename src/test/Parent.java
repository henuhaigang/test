package test;

public class Parent {
String one,two;
public Parent(){}
public Parent(String a,String b){
	one=a;
	two=b;
}
public void print(){
	System.out.println(one);
}
public void shili(){
	System.out.println("调用了超类的方法");
}
}
