import java.util.Scanner;

/*
    걸린시간: 16.30
    문제점:1000001개로 초기화 해야됨, 1000001개 배열 하나만 만들어도 ㄱㅊ
 */
public class Main {
    public static int[] arr1;
    public static int[] arr2;
    public static int[] a1;
    public static int[] a2;

    public static void main(String[] args) {

        int N, M;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr1 = new int[N];

        for(int i = 0 ; i < N; i++){
            arr1[i] = sc.nextInt();
        }

        M = sc.nextInt();
        arr2 = new int[M];

        for(int i = 0 ; i < M; i++){
            arr2[i] = sc.nextInt();
        }


        a1 = new int[1000000];
        a2 = new int[1000000];


        for(int i = 0; i < N; i++){
            a1[arr1[i]] = 1;
        }
        for(int i = 0; i < M; i++){
            a2[arr2[i]] = 1;
        }


        for(int i = 0 ; i < M; i ++){
            if(a1[arr2[i]] == a2[arr2[i]])
                System.out.print("yes ");
            else
                System.out.print("no ");

        }

        //     long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        //  long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //   System.out.println("시간차이(second) : " + secDiffTime);
    }
}