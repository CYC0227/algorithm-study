import java.util.*;

/*
    걸린시간:   10분 42초
    문제점:    


 */

public class Main {

    public static int n;
    public static int[][] dt;
    public static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        dt = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dt[0][0] = arr[0][0];

        int left, up;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                if(j == 0){
                    left = 0;
                    up = dt[i - 1][j];
                }
                else if(j == i){
                    left = dt[i - 1][j - 1];
                    up = 0;
                }
                else{
                    left = dt[i - 1][j - 1];
                    up = dt[i - 1][j];
                }

                dt[i][j] = arr[i][j] + Math.max(up,left);
            }
        }

        int result = -1;
        for(int i = 0; i < n; i++){
            result = Math.max(result, dt[n - 1][i]);
        }


        System.out.println(result);
        
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}
