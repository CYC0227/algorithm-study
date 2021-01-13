import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
    걸린시간: 10.45
    문제점: 틀렸음. 두번째 배열 원소가 첫번째보다 작은경우 생각 안함
 */
public class Main {

    public static Integer[] arr1;
    public static Integer[] arr2;

    public static void main(String[] args) {

        int N,K;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr1 = new Integer[N];
        arr2 = new Integer[N];

        for(int i = 0 ; i< N; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0 ; i< N; i++){
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2 , Collections.reverseOrder());

        for(int i = 0; i < K; i++){
            arr1[i] = arr2[i];
        }

        for(int i = 0 ; i< N; i++){
            sum += arr1[i];
        }

        System.out.println(sum);





        //     long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        //  long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //   System.out.println("시간차이(second) : " + secDiffTime);
    }
}