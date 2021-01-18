import java.util.*;

public class ch8_2 {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {// 1로 만들어야 하기 때문에 i가 2부터 시작
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;// 1 더하는 것은 횟수를 구하기 위해 -> 횟수 구한 것을 각 DP테이블에 저장!
            //1을 먼저 더한 것을 다른 것과 차례대로 비교!
            
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
            	System.out.print(d[i] + " , " + (d[i/2]+1) + " -> ");
                d[i] = Math.min(d[i], d[i / 2] + 1);
                System.out.println(d[i]);
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
            	System.out.print(d[i] + " , " + (d[i/3]+1) + " -> ");
            	d[i] = Math.min(d[i], d[i / 3] + 1);
            	System.out.println(d[i]);
            }
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
            	System.out.print(d[i] + " , " + (d[i/5]+1) + " -> ");
            	d[i] = Math.min(d[i], d[i / 5] + 1);
            	System.out.println(d[i]);
            }
        }

        System.out.println(d[x]);
    }
}
