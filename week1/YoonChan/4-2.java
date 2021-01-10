import java.util.Scanner;


/*
    걸린시간: 38분
    이유: 잘못 이해하고 계속 삽질함
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;

        int cnt = 0;

       int a,b, c, d,e,f;

        N = sc.nextInt();

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        for(int i = 0; i < N + 1; i++){
            e = i / 10;
            f = i % 10;
            for(int k = 0; k < 60; k++) {
                a = k / 10;
                b = k % 10;
                for (int j = 0; j < 60; j++) {
                    c = j / 10;
                    d = j % 10;
                    if(e == 3 || f ==3 || a == 3 || b == 3 || c == 3 || d == 3 ){
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);


        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        System.out.println("시간차이(second) : " + secDiffTime);
    }
}