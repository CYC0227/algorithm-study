
import java.util.Scanner;


/*
    걸린시간: x
    이유: 입력받기 답지봄... / 문제 대충읽어서 좌표 + - 이해못함
 */

public class Main {
    static int N;

    public static boolean isAbleToMove(int x, int y){
        if(x == 0 || y == 0 || x == N +1 || y == N + 1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] plans;

        int x = 1,y = 1;

        N = sc.nextInt();
        sc.nextLine();
        plans = sc.nextLine().split(" ");


        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기


        for(int i = 0; i < plans.length; i++){
            if(plans[i].equals("D")){
                if(isAbleToMove(x + 1, y)) {
                    x = x + 1;
                }
            }
            else if(plans[i].equals("U")){
                if(isAbleToMove(x - 1, y)) {
                    x = x - 1;
                }
            }
            else if(plans[i].equals("R")){
                if(isAbleToMove(x, y + 1)) {
                    y = y + 1;
                }
            }
            else if(plans[i].equals("L")){
                if(isAbleToMove(x, y - 1)) {
                    y = y - 1;
                }
            }
        }

        System.out.println(x+ " " + y);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        System.out.println("시간차이(second) : " + secDiffTime);
    }
}