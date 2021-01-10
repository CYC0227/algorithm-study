import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*
    걸린시간: 20분
    이유: 라이브러리 이해부족
     */

        int N,M;
        int [][] arr;
        int result;

        int curMin = 0;
        List<Integer> curMinList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        for(int i = 0; i < N; i++){
            curMin = arr[i][0];
            for(int j = 0; j < M; j++){
                if(curMin >= arr[i][j])
                    curMin = arr[i][j];
            }
            curMinList.add(curMin);
        }

        Collections.sort(curMinList);

        System.out.println(curMinList.get(N - 1));


        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(second) : "+secDiffTime);
    }
}