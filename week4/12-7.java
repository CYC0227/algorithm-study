import java.util.*;

/*
    걸린시간: 7분 47초
    문제점: 
 */




public class Main {

    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        String[] str = Integer.toString(N).split("");

        int len = str.length;

        int sum1 = 0;
        int sum2 = 0;

        for(int i= 0; i < len / 2; i++){
            sum1 += Integer.parseInt(str[i]);
            sum2 += Integer.parseInt(str[len - 1 - i]);
        }
        String result;

        if(sum1 == sum2)
            result = "LUCKY";
        else
            result = "READY";

        System.out.println(result);


     //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


       // long beforeTime = System.currentTimeMillis();
     //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}