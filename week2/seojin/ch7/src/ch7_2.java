/*
14분_ 내가 원하지 않는 곳에서 no 출력이 자꾸 나와서
 */
import java.util.*;

public class ch7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int m = sc. nextInt();
		int[] list = new int[m];
		for(int i=0; i<m; i++) {
			list[i] = sc.nextInt();
		}
		
		// 하나씩 비교하기
		
		for(int i=0; i<m; i++) {
			int check = 0;
			for(int j=0; j<n; j++) {
				if(arr[j] == list[i]) {
					System.out.print("yes ");
					check = 1;
				}
			}
			if(check == 0) {
				System.out.print("no ");
			}
		}
		
	}

}
