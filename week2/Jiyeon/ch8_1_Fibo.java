// chapter 8 다이나믹 프로그래밍 - 피보나치 수열 ( 다이나믹 X 비효율적인 방법으로 )
public class ch8_1_Fibo {
	
	/* 재귀적으로 계속 피보나치 함수를 부른다면, n값이 커질 때 심각한 시간 초과가 날 수 있다. 
	 * Fibo(100)을 계산한다면 수백억 년 후에 답을 찾을 수 있다 ㅋ */

	public static int Fibo(int n) {
		
		if(n==1) return 1;
		if(n==2) return 1;
		
		return Fibo(n-2) + Fibo(n-1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(Fibo(4));
	}

}
