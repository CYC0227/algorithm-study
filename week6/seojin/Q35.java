/*
 * 약 20분
 * 근데 이게 완전 딱 알아서 풀었다기 보다는 빨리 풀려고, 풀면서 그냥 고치면 되겠거니 하고 품
 * 따라서 코딩할 때, 제대로 이해하지 못하고 답이 급급해 약간 막무가내로 품
 *  
 */
import java.util.*;

public class Q35 {
	
	public static int[] arr = new int[1001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 1;//숫자세기
		int result = 1;
		//for(int i=1; i<=n; i++) {//n번째
		while(result!=n+1) {
			if(cnt==1) {
				arr[cnt] = cnt;
				result++;
			}
			else if(cnt%2==0 || cnt%3==0 || cnt%5==0) {
				arr[cnt] = cnt;
				result++;
			}
			System.out.println(arr[cnt]);
			cnt++;
		}
		
		System.out.println(arr[cnt-1]);
		
	}

}
