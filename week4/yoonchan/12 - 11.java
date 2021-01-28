import java.util.*;

/*
    걸린시간:
    문제점:
 */


public class Main {

    public static int[][] map;
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {

        int N;
        int K;
        int L;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N+2][N+2];

        for(int i = 0; i < K; i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            map[a][b] = 3;//apple = 3
        }
        L = sc.nextInt();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = 1;
            }
        }


        int cnt = 0;
        map[1][1] = 1;
        int dir = 1;
        int x = 1;
        int y = 1;
        int tailX = 1;
        int tailY = 1;
        int snakeLen=  1;
        boolean done = false;

        while(true){
          int a = sc.nextInt();
          char b = sc.next().charAt(0);

          for(int i =0; i < a; i++){
              int nx = x + dx[dir];
              int ny = y + dy[dir];

              if(map[nx][ny] == 3){//apple
                snakeLen++;
                map[nx][ny] = 1;
                cnt++;
              }
              else if(map[nx][ny] == 0){//map
                for(int j = 0; j < snakeLen; j++){
                    map[nx][ny] = 1;
                    map[tailX][tailY] = 0;
                }

                cnt++;
              }
              else if(map[nx][ny] == 1){
                  cnt++;
                  done = true;
                  break;
              }
          }
          if(done)
              break;;
        }

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}