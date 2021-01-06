
// 그리디 - 거스름돈 문제
public class ch3_1 {

	public static void main(String[] args) {
		int n = 1260; // 총 거스름돈 금액
		int count = 0; // 손님이 받을 동전 개수
		int[] coins = {500,100,50,10}; // 동전의 종류
		
		// 동전 종류의 개수만큼 반복문 실행 -> O(N) : N은 동전 종류의 개수
		for(int i=0;i<4;i++) {
			count += n / coins[i]; // 남은 거스름돈을 동전크기만큼 나눈 몫을 count에 추가
			n = n % coins[i];	// n은 그 나머지값으로 대체			
		}
		
		System.out.println("total change : " + n + "\nchange counts : " + count);
	}

}
