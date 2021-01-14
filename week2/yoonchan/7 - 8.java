import java.util.Scanner;

/*
    걸린시간: 못풀고 답지봄
    문제점: 32줄: 괄호쓰기, 33줄 long
 */
public class Main {
    public static int[] arr_cake;

    public static void main(String[] args) {

        int N,M;
        int result = 0;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr_cake = new int[N];

        for(int i = 0; i < N; i++){
            arr_cake[i] = sc.nextInt();
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        int start=  0;
        int end = 100000000;

        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0 ; i< N; i++){
                if(arr_cake[i] > mid)
                    sum += arr_cake[i] - mid;
            }

            if(sum < M) end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
          System.out.println("시간차이(second) : " + secDiffTime);
    }
}