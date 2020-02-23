package test;

import java.util.concurrent.ArrayBlockingQueue;

public class FindSecondMaxTest {
    public static int find(int[] array) {
        int max, sec_max;
        max = sec_max = array[0];
        int n=0;
        for (int i = 1; i < array.length; i++) {
            n++;
            if (array[i] > max) {
                sec_max = max;
                max = array[i];
            }

        }
        System.out.println("++"+n+"-----");
        return sec_max;
    }

    public static void main(String[] args) {
        int[] arr={2,4,6,1,7,8,4,9,10};
        int a=find(arr);
        System.out.println(a);
    }
}
