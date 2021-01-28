import java.util.*;

/*
    걸린시간: 7분 59초
    문제점: Arrays.sort(str) 가 생각대로 돌아갈지 고민해서 출력을 한번 해봄.
 */




public class Main {

    public static void main(String[] args) {

        String[] str;
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine().split("");

        Arrays.sort(str);

        int sum = 0;
        for(int i = 0;  i< str.length; i++){
            if(str[i].charAt(0) - '0' < 10)
                sum+=str[i].charAt(0) - '0';
            else
                System.out.print(str[i]);
        }
        System.out.print(sum);


     //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


       // long beforeTime = System.currentTimeMillis();
     //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}