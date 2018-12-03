package interview.beike;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Long result = 0l;
        String[] adds = str.split("\\+");
        for(String s:adds){
            String[] subs = s.split("\\-");
            result += parseInt(subs[0]);
            for(int i=1;i<subs.length;i++){
                result -= parseInt(subs[i]);
            }
        }
        System.out.println(result);
    }

    private static long parseInt(String s){
        if(s.startsWith("0x")){
            return Long.valueOf(s.substring(2),16);
        }else if(s.startsWith("0")){
            return Long.valueOf(s,8);
        }else{
            return Long.valueOf(s);
        }
    }
}
