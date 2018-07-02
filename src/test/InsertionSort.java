package test;


/**
 * 插入排序
 * 插入排序是一种简单直观的排序算法。它的工作原理非常类似于我们抓扑克牌
 * 　　对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。
 *
 * 　　插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 　　具体算法描述如下：
 *
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置后
 * 重复步骤2~5
 */
public class InsertionSort {


    //假设事从小到大进行排序
    public int[] sort(int[] array){

        //首先应该假设第一个元素已经排序，然后再已经排序的地方进行进行比较
        int size=array.length;
        for(int i=1;i<size;i++) {

            //小范围重新排序
            for (int j = 0; j < i; j++) {
                int temp;
                if (array[j] > array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
         /*   int temp;
            if(array[i]>array[i+1]){
                temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }*/
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr={1,4,2,9,6,2};
        int[] arr2=new InsertionSort().sort(arr);
        for(int a:arr2){
            System.out.println(a);
        }
    }
}
