package test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class DikaerjiTest {

    //首先假设我们有个list为List<List<String>> 类型的list，现在要对其中的数据进行笛卡儿积实现


    /**
     * 采用递归的方法进行遍历
     * @param dimList
     * @param layer
     * @param curList
     */
    public void diguilist(List<List<String>> dimList,int layer,List<String> curList){
        if(layer<0){
            System.out.println("数组长度不合法");
            return;
        }
        List<String> newList=new ArrayList<>();

        if(0==layer){
            for(String str:dimList.get(layer)){
                newList.add(str);
            }
            diguilist(dimList,layer+1,newList);
        }else if(layer>0&&layer<dimList.size()-1) {
            for(String curStr:curList){
                for(String str:dimList.get(layer)){
                    newList.add(curStr+str);
                }
            }
            diguilist(dimList,layer+1,newList);
        }else {
            for(String curStr:curList){
                for(String str:dimList.get(layer)){
                    newList.add(curStr+str);
                  //  diguilist(dimList,layer+1,sb,newList);
                }
            }
            System.out.println("笛卡儿积的长度为："+newList.size());
            for (String str:newList) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        List<String> lista=new ArrayList<>();
        lista.add("1");
        lista.add("2");
        lista.add("3");
        List<String> listb=new ArrayList<>(lista);
        for(String str:listb){
          //  System.out.println(str);
        }
        List<String> listc=new ArrayList<>();
        listc.add("a");
        listc.add("b");
        List<String> listd=new ArrayList<>();
        listd.add("A");
        listd.add("B");
        listd.add("C");
        List<List<String>> dimvalue=new ArrayList<List<String>>() ;
        dimvalue.add(lista);
        dimvalue.add(listc);
        dimvalue.add(listd);
        new DikaerjiTest().diguilist(dimvalue,0,new ArrayList<>());
    }










}
