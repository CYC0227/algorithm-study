import java.util.*;
// 그리디 - 1이 될 때까지

public class ch3_4 {

	public static void main(String[] args) {
		  Scanner keyboard = new Scanner(System.in);
				
				int n = keyboard.nextInt();
				int k = keyboard.nextInt();
				int result = 0;
				
				// n이 k보다 작을 때까지 반복
				while(true) {
					/* N에서 1을 뺀다 : n이 k로 나눠질 수 있는 수까지 n에서 1씩 빼주기 -> 뺀 값만큼 result 추가시키고, 뺀 값으로 n 변경  */
					result = result + ( n % k );
					n = n - ( n % k );
					
					/* N을 K로 나눈다 : n을 k로 나눈 몫으로 n값 변경 & result값 1 증가 */
					n = n / k;
					result++;
					
					/* n을 k로 정상적으로 나눌 수 없다면, 반복문 탈출 */
					if(n<k) break;
				}
				
				/* n이 1이 아니라면 k와의 차이만큼 1씩 빼주고 그만큼 result값 증가 */
				if(n!=1)
					result += k-n;
				
				System.out.println(result);				
	}

}
