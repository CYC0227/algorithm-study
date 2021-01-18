import java.util.Scanner;

/*
    걸린시간: 12: 51
    문제점: 틀림- 첫번째 숫자 특이케이스 생각못함
 */

public class Main {

    public static void main(String[] args) {

        String [] str;
        int result;
        int cnt1 = 0;
        int cnt2 = 0;

        Scanner sc = new Scanner(System.in);

        str = sc.nextLine().split("");

        for(int i = 0; i< str.length - 1; i++){//0
            if(str[i].equals("0") && str[i + 1].equals("1")){
                cnt1++;
            }
        }

        for(int i = 0; i< str.length -1; i++){//1
            if(str[i].equals("1") && str[i + 1].equals("0")){
                cnt2++;
            }
        }

        result = Math.min(cnt1,cnt2);

        System.out.println(result);





        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}