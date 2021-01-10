import java.util.*;
public class _4_until1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.println("debug");
		int N = sc.nextInt();
		int K = sc.nextInt();
		int value = N;
		int result = 0;
		
		while(true) {
			
			if(value == 1) {
				//System.out.println("the end");
				break;
			}
			//나누어떨어질 때, 2번째 방법
			if (value % K == 0) {
				value = value/K;
			}
			//1번째 방법
			else {
				value = N - 1;
			}
			
			result++;
			
		}
		
		System.out.println(result);
	}

}

//////////답지//////////
/*
import java.util.*;

public class _4_until1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N, K를 공백을 기준으로 구분하여 입력 받기
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(true) {
			// N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
			int target = (n/k) * k;
			result += (n - target);
			n = target;
			// N이 K보다 직을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
			if(n < k) break;
			// K로 나누기
			result += 1;
			n /= k;
		}
		
		// 마지막으로 남은 수에 대하여 1씩 빼기
		result += (n-1);
		System.out.println(result);
	}
	
}
*/