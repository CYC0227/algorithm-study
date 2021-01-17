import java.util.Scanner;

/*
    걸린시간: 못풀고 답지봄
    문제점: 자바 배열 초기화 시 0으로 자동 초기화됨
 */
public class Main {

    public static int[] d = new int[30001];

    public static void main(String[] args) {

        int X;

        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();

        for(int i = 2;i <= X; i++){

            d[i] = d[i - 1] + 1;

            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }

        System.out.println(d[X]);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
          System.out.println("시간차이(second) : " + secDiffTime);
    }
}