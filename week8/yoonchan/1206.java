import java.util.*;

/*
    출처: 삼성 sw Academy
    문제번호: 1206
    걸린시간:  21분 26초
    문제점:    개쉬운데 시간이 왜이리 오래걸렸지...? 아마 테스트케이스 뭔소린지 몰라서 그랬었던듯


 */

public class Main {


    private static int N;
    private static int[] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i< 10; i++) {
            N = sc.nextInt();
            arr = new int[N];

            for(int j = 0; j < N; j++){
                arr[j] = sc.nextInt();
            }

            int min = (int) 1e9;
            int sum = 0;
            for(int j = 2; j < N - 2; j++){
                min = arr[j] -  Math.max(arr[j - 1], Math.max(arr[j - 2], Math.max(arr[j + 1], arr[j + 2])));

                if(min < 0) min = 0;

                sum += min;
            }
            list.add(sum);
        }

        for(int i = 1; i<= 10; i++){
            System.out.println("#" + i + " " + list.get(i - 1));
        }
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}
