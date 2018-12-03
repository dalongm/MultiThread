package interview;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long k = sc.nextLong();
        Long b = sc.nextLong();
        int n = sc.nextInt();
        Long t = sc.nextLong();
        Long z = 1L;
        int count = 0;
        while (t>z){
            count++;
            z = k*z + b;
        }
        if(count==0){
            System.out.println(n);
        }else{
            count = n-count+1;
            System.out.println(count);
        }

    }
}
