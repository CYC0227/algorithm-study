// chapter 8 ���̳��� ���α׷��� - �޸������̼����� �� ������ �Ǻ���ġ ���� (ž�ٿ� - ���)
public class ch8_2_Fibo2 {
	
	public static long[] dp = new long[100];
	
	// ž�ٿ����� ���� - ��� : 99�� �׽�Ʈ�ϸ� overflow���� 50���� �׽�Ʈ
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
