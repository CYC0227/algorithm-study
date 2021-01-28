import java.util.*;

/*
    걸린시간: 9분 54초
    문제점: 그리디로 안풂
 */




public class Main {

    public static int[] arr;
    public static int[] types;

    public static void main(String[] args) {

        int N,M;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        types = new int[M + 1];

        for(int i = 0; i< N; i++){
            int a = sc.nextInt();
            arr[i] =a;
            types[a]++;
        }

        result = N * (N - 1) / 2;

        for(int i =1; i<= M; i++){
            if(types[i] >= 2){
                result -= types[i] * (types[i] - 1) / 2;
            }
        }

        System.out.println(result);





     //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


       // long beforeTime = System.currentTimeMillis();
     //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}