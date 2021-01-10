
import java.util.Scanner;


/*
    걸린시간: 못품 망함
    이유: 하...
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        int a, b, c;//status
        int [][] map;
        int cnt = 0;


        N = sc.nextInt();
        M = sc.nextInt();

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        map = new int[N][M];

        for(int i = 0 ; i < N; i++ ){
            for(int j = 0 ; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        map[a][b] = 3;

        int strike = 0;

       while(true){
           if(strike == 4){
               if(c == 0)
                   b = b + 1;
               else if(c == 1)
                   a = a - 1;
               else if(c == 2)
                   b = b - 1;
               else if(c == 3)
                   a = a + 1;
               strike = 0;
               if(map[a][b] == 3)
                   break;
           }

           c = c - 1;
           if(c == - 1)
               c = 3;


           if(c == 0){
               if(map[a - 1][b] == 0){
                   a = a - 1;
                   map[a][b] = 3;
                   cnt++;
               }
               else if(map[a - 1][b] == 1){
                   strike++;
                   continue;
             }
               else if(map[a - 1][b] == 3){//been there
                   strike++;
                   continue;
               }
           }
           else if(c == 1){
               if(map[a][b + 1] == 0){
                   b = b + 1;
                   map[a][b] = 3;
                   cnt++;
               }
               else if(map[a][b + 1] == 1){
                   strike++;
                   continue;
               }
               else if(map[a][b + 1] == 3){//been there
                   strike++;
                   continue;
               }
           }
           else if(c == 2){
               if(map[a + 1][b] == 0){
                   a = a + 1;
                   map[a][b] = 3;
                   cnt++;
               }
               else if(map[a + 1][b] == 1){
                   strike++;
                   continue;
               }
               else if(map[a + 1][b] == 3){//been there
                   strike++;
                   continue;
               }
           }
           else if(c == 3){
               if(map[a][b - 1] == 0){
                   b = b - 1;
                   map[a][b] = 3;
                   cnt++;
               }
               else if(map[a][b - 1] == 1){
                   strike++;
                   continue;
               }
               else if(map[a][b - 1] == 3){//been there
                   strike++;
                   continue;
               }
           }
       }

        for(int i = 0 ; i < N; i++ ){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 3) cnt++;
            }
        }

        System.out.println(cnt);






   //     long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

      //  long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
     //   System.out.println("시간차이(second) : " + secDiffTime);
    }
}