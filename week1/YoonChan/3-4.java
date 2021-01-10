import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*
    걸린시간: 5분 48초
    문제점: 문제 조건 변했을때 시간 효율성 고려하기
     */
        int result = 0;
        int N,K;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        while(true){
            if(N == 1)
                break;
            result++;

            if(N % K == 0) {
                N = N / K;
            }
            else
                N = N - 1;

        }

        System.out.println(result);
        
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(second) : "+secDiffTime);
    }
}