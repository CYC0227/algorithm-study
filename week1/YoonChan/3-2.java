import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*
    걸린시간: 25분
    이유: 컬렉션 이해부족
     */

        int N,M,K;
        int sum = 0;
        List<Integer> lst = new ArrayList<Integer>();;

        Scanner sc=  new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < N; i++)
            lst.add(sc.nextInt());

        Collections.sort(lst);
        Collections.reverse(lst);

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기


        for(int i = 0; i < M / K + M % K; i++){
            if(i / 2 == 0){
                sum += lst.get(0)*K;
            }
            else{
                sum += lst.get(1);
            }
        }


        System.out.println(sum);


        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}