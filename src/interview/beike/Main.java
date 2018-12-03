package interview.beike;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(;n>0;n--){
            int x = sc.nextInt();
            int a = sc.nextInt();
            int c = sc.nextInt();
            int y = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            long killzhitimes = x%b==0?x/b:x/b+1;
            long killzhitime = (killzhitimes-1)*d;
            long killchuntimes = y%a==0?y/a:y/a+1;
            long killchuntime = (killchuntimes-1)*c;

            if(killzhitime>killchuntime){
                System.out.println("XIAOZHI");
            }else if(killzhitime==killchuntime){
                System.out.println("TIE");
            }else{
                System.out.println("XIAOCHUN");
            }
        }
    }
}
