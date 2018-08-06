package test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 笛卡尔积的实现
 */
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

   //使用非递归的方法
   public List<String> otherDikaer(List<List<String>> dimvalue){

        //获取维度长度，方便循环
        int dimSize=dimvalue.size();
        List<String> curList=new ArrayList<>();

        List<String> tempList=new ArrayList<>();

        for(int i=0;i<dimSize;i++){
            if(i==0){
               // result.add(dimvalue.get(i))
                for(String str:dimvalue.get(i)){
                    curList.add(str);
                }
            }if(i>0&&i<dimSize-1){
                for(String str:curList){
                    for(String strq:dimvalue.get(i)){
                        tempList.add(str+strq);
                    }
                }
                curList.clear();
                curList.addAll(tempList);
                tempList.clear();
            }else if(i==dimSize-1){
                for(String str:curList){
                    for(String strq:dimvalue.get(i)){
                        tempList.add(str+strq);
                    }
                }
                curList.clear();
                curList.addAll(tempList);
                tempList.clear();
            }
       }


       return curList;






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
       // new DikaerjiTest().diguilist(dimvalue,0,new ArrayList<>());

      List<String> result=  new DikaerjiTest().otherDikaer(dimvalue);
        System.out.println("非递归得到的长度为："+result.size());
        for(String sr:result){
            System.out.println(sr);
        }
    }










}
