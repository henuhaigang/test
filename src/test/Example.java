package test;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Example {
	String str = "abc";
	char[] ch = { 'a', 'b', 'c' };


	private  final Map<String,String> mymap;
	public Example(){
		Map<String,String> map=new ConcurrentHashMap<>();
		mymap=Collections.unmodifiableMap(map);
		mymap.put("1","23");
	}
	public static void main(String[] args) {
		Example ex = new Example();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
		//System.out.println(mymap.containsValue("23"));
	}

	public void change(String str, char[] ch) {
		str = "test ok";
		ch[0] = 'g';
	}
}
