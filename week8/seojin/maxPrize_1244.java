import java.util.*;
public class maxPrize_1244 {
	
	public static int[] arr;
	public static int move, result, prize;
	
	public static void dfs(int k, int cnt) {
		if(cnt == move) {//교체 기회 다 썼을 때
			result = Math.max(result, prize);
			return;
		}
		
		//뒤의 값들과 차례차례 바꿔 나가며, 모든 경우 조사
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				//swap
				prize = arr[i];
				arr[i] = arr[j];
				arr[j] = prize;
				dfs(i, cnt+1);
				//원래 자리로 돌려놓기
				prize = arr[i];
				arr[i] = arr[j];
				arr[j] = prize;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		//arr = new int[testcase];
		
		for(int i=0; i<testcase; i++) {
			//하나씩 비교
			//arr[i] = sc.nextInt();
			//숫자 문자로 받기
			String num = sc.next();
			move = sc.nextInt();
			
			//num 한자리씩 쪼개기
			//String[] arr = new String[num.length()];
			
			//num 한자리씩 자르기
			String[] num2 = num.split("");
			arr = new int[num.length()];
			for(int j=0; j<num.length(); j++) {
				//System.out.println(num2[j]);
				arr[j] = Integer.parseInt(num2[j]);
								
			}
		
			result = 0;
			dfs(0,0);
			System.out.println("#" + (i+1) + " " + result);
		/* 
		 * 디버깅
		for(int i=0; i<testcase; i++) {
			System.out.println(arr[i] + " " + move);
		}
		*/
		}
	}

}
