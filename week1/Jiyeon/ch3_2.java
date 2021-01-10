// 그리디 - 큰 수의 법칙
import java.util.*;

public class ch3_2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		int k = keyboard.nextInt();
		int[] arr = new int[n];
		int result = 0;
		
		/* 배열에 숫자 n개 입력 받기 */
		for(int i=0;i<n;i++) {
			arr[i]=keyboard.nextInt();
		}
		
		/* 배열을 내림차순으로 정리 */
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		/* 가장 큰 값과 두 번째로 큰 값 저장 */
		int max1=arr[0];
		int max2=arr[1];
		
		/* m번 숫자 더하기 */
		
		int count = m / (k+1); // count : max1이 더해지는 횟수
		count = count*k + m%(k+1); // => max1이 k만큼, max2가 1만큼 더해지는 것이 하나의 그룹이기 때문에, (m을 k+1로 나눈 몫 * k) + (m을 k+1로 나눈 나머지) 만큼 max1을 더한다.
		
		result+=count*max1;
		result+=(m-count)*max2; // max2는 m에서 count를 뺀 수만큼 더한다.
		
		System.out.println("\n"+result);
		
	}

}
