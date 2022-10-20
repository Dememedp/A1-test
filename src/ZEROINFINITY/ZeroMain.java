package ZEROINFINITY;

import java.util.Scanner;

public class ZeroMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number below 12: ");
        int num = in.nextInt();
        if (num > 12 || num <= 0) {
            System.out.println("Wrong number!");
        } else {
            System.out.println("Your result = " + factorial(num));
        }
    }

    public static double fact(int num){
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

    public static double factorial(int n){
        double tmp = 1/fact(n);
        double result  = tmp;
        for (int i = 2; i <= n; i++){
            tmp *= i;
            result += tmp;

        }
        return result;
    }
}
