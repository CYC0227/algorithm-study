// chapter 8 ���̳��� ���α׷��� - �Ǻ���ġ ���Ҿ� : ������� ���̱�
public class ch8_2_Fibo3 {
	
	public static void main(String[] args) {
		long[] dp = new long[100];
		
		dp[1] = 1;
		dp[2] = 1;
		
		int n = 50;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[n]);

	}

}
