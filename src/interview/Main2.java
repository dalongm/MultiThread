package interview;


import java.util.Scanner;

public class Main2 {

    public static class LLong {
        private Long num;
        private int first;
        private int end;
        private int length;
        private Long middle;

        public LLong(Long num) {
            this.num = num;
            String nums = String.valueOf(num);
            this.length = nums.length();
            this.first = Integer.valueOf(nums.charAt(0)-'0');
            this.end = Integer.valueOf(nums.charAt(this.length - 1)-'0');
            if(length<=2){
                middle=0L;
            }else{
                middle = Long.valueOf(nums.substring(1,length-1));
            }
        }

        public LLong inclen() {
            num = num * 10 + 1;
            first = 1;
            end = 1;
            length++;
            return this;
        }

        public LLong incfirst() {
            num += (int) Math.pow(length, 10);
            first++;
            return this;
        }

        public LLong incend() {
            num += 1;
            end++;
            return this;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long l = sc.nextLong();
        Long r = sc.nextLong();
        sc.close();

        LLong ll = new LLong(l);
        LLong lr = new LLong(r);

        Long result = 0L;
        if(lr.first==lr.end){
            result++;
        }

        while(ll.length<lr.length){
            result += nextLenCount(ll);
            ll.inclen();
        }

        result += nextLenCount(ll);
        result -= ll.middle;
        result -= nextLenCount(lr);
        result += lr.middle;


        System.out.println(result);
    }


    private static Long nextLenCount(LLong llnum) {
        Long result = 0L;
        while (llnum.first > llnum.end) {
            llnum.incend();
        }
        while (llnum.first < llnum.end) {
            llnum.incfirst();
        }
        result = 10L - llnum.end;
        if(llnum.length>2){
            result = result*Math.round(Math.pow(10,llnum.length-2));
        }
        return result;
    }
}
