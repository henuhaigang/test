package test;

import java.util.HashMap;
import java.util.Map;

public class ReferenceTest {
    public static void main(String[] args) {
        String[] arr={"1","2","3"};
        String str=arr[1];
        arr[1]=null;
        System.out.println(str);
        new ReferenceTest().testMap();

    }
    public void testMap(){
        Map<String,String> map=new HashMap<>(2);
        map.put("3","a");
        map.put("7","b");
        map.put("5","c");
        map.put("6","d");
    }
}
