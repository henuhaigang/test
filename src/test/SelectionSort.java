package test;

/**
 * 选择排序
 * 选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：初始时在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *注意选择排序与冒泡排序的区别：冒泡排序通过依次交换相邻两个顺序不合法的元素位置，
 * 从而将当前最小（大）元素放到合适的位置；而选择排序每遍历一次都记住了当前最小（大）元素的位置，
 * 最后仅需一次交换操作即可将其放到合适的位置。
 */
public class SelectionSort {

    private int size;

    public int[] sort(int[] arr){
        //重要思想，得找出最大或者做小元素，并且缓存最新的数组（已经排好序的数组）
        int  size= arr.length;
        for(int i=0;i<size-1;i++){

           //最小的下标
            int minpos=i;
            for(int j=i+1;j<size;j++){
                if(arr[i]>arr[j]){
                    minpos=j;         //换取最小的元素
                }
            }

            int temp;
            if(i!=minpos){
              temp=arr[i];
              arr[i]=arr[minpos];
              arr[minpos]=temp;
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr={1,4,2,6,9,2};
        int[] arr2=new SelectionSort().sort(arr);
        for(int a:arr2){
            System.out.println(a);
        }
    }
}
