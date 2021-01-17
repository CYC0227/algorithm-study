import java.util.Scanner;

/*
    걸린시간: 21.14
    문제점: 문제풀때 이게 왜 dp인지 모르겠어서 틀림
 */
public class Main {

    public static int [] arr;

    public static void main(String[] args) {

        int N;
        int a1, a2;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr =  new int[N];

        for(int i = 0 ; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int sum1 = 0;
        int sum2 = 0;
        long result;

        if(N % 2 == 0) {
            for (int j = 0; j < N; j = j + 2) {//even
                sum1 += arr[j];
            }

            for (int j = 1; j < N; j = j + 2) {//odd
                sum2 += arr[j];
            }
            result = Math.max(sum1,sum2);
        }
        else{
            for (int j = 0; j < N; j = j + 2) {//even
                sum1 += arr[j];
            }

            for (int j = 1; j < N; j = j + 2) {//odd
                sum2 += arr[j];
            }
            result = Math.max(sum1,sum2);
        }

        System.out.println(result);




        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
          System.out.println("시간차이(second) : " + secDiffTime);
    }
}