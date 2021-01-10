import java.util.Scanner;


/*
    걸린시간: 19분 55초
    이유: x 
 */

public class Main {

    public static boolean isAbleToMove(int m, int n){
        if(m <= 0 || n <= 0 || m >= 9 || n >= 9)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input;
        int m = 0,n = 0;

        int cnt = 0;

        input = sc.nextLine().split("");
        
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기



        if(input[0].equals("a"))
            m = 1;
        else if(input[0].equals("b"))
            m = 2;
        else if(input[0].equals("c"))
            m = 3;
        else if(input[0].equals("d"))
            m = 4;
        else if(input[0].equals("e"))
            m = 5;
        else if(input[0].equals("f"))
            m = 6;
        else if(input[0].equals("g"))
            m = 7;
        else if(input[0].equals("h"))
            m = 8;

        n = Integer.parseInt(input[1]);

        if(isAbleToMove(m - 1,n - 2))
            cnt++;
        if(isAbleToMove(m - 2,n - 1))
            cnt++;
        if(isAbleToMove(m - 2,n + 1))
            cnt++;
        if(isAbleToMove(m - 1 ,n + 2))
            cnt++;
        if(isAbleToMove(m + 1,n + 2))
            cnt++;
        if(isAbleToMove(m + 2,n + 1))
            cnt++;
        if(isAbleToMove(m + 2,n - 1))
            cnt++;
        if(isAbleToMove(m + 1,n - 2))
            cnt++;

        System.out.println(cnt);



        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        System.out.println("시간차이(second) : " + secDiffTime);
    }
}