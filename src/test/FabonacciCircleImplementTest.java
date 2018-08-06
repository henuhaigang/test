package test;

/**
 * Created by dell on 2015/10/5.
 */
public class FabonacciCircleImplementTest {
    public static void main(String[] args) {
        System.out.println(FabonacciCircleImplement.fabonacci(4));
        System.out.println(FabonacciCircleImplement.fabonacci(5));
    }
}

class FabonacciCircleImplement{
    public static long fabonacci(final int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int currentNum = 1;
        int preNum = 0;
        for (int i = 0; i < n - 1; ++i){
            int temp = currentNum;
            currentNum = currentNum + preNum;
            preNum = temp;
        }

        return currentNum;
    }
}