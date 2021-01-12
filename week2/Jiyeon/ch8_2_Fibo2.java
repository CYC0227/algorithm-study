// chapter 8 다이나믹 프로그래밍 - 메모이제이션으로 잘 구현한 피보나치 수열 (탑다운 - 재귀)
public class ch8_2_Fibo2 {
	
	public static long[] dp = new long[100];
	
	// 탑다운으로 구현 - 재귀 : 99로 테스트하면 overflow나서 50으로 테스트
	public static long fibo(int n) {
		if(n==1 || n==2)
			return 1;
		
		if(dp[n] != 0)
			return dp[n];
		
		dp[n] = fibo(n-1) + fibo(n-2);
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println(fibo(50));
		
	}

}
