package interview.beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> factorList = getFactors(M);
        solve(factorList,-1,0,N-1);
        System.out.println(result);
    }

    private static void solve(List<Integer> list, int lastNum,int index, int count){
        if(count==0){
            result++;
            result %= 1000000007;
            return;
        }
        for(int i=index;i<list.size();i++){
            if(lastNum==-1||list.get(i)%lastNum==0){
                solve(list,list.get(i), i,count-1);
            }
        }
    }

    private static List<Integer> getFactors(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                list.add(i);
            }
        }
        if(n>1){
            list.add(n);
        }
        return list;
    }
}
