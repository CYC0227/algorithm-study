//25분 _ 멍청하게 이상한데서 헷갈림ㅜ.ㅜ 
//(예시) 그룹이 하나가 추가되고 바로 +1부터 다시 세야하는데 이때 이것을 뭘로 구분해줘야 하는지 헷갈림 
import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// int Integer
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 내림차순 정렬
		Arrays.sort(arr, Collections.reverseOrder());
		
		/*
		int cnt = arr[0];
		int sub = n;
		while(cnt!=n) {
			sub = sub - cnt;
		}
		*/
		
		int cnt = 1;
		int check = arr[0];
		int result = 0;
		for(int i=0; i<n; i++) {
			if(cnt != check) {
				cnt++;
				continue;
			}
			else {
				result++;
				check = arr[cnt-1];
				cnt = 1;
			}	
		}
		
		System.out.println(result);
	}

}
