//25�� _ ��û�ϰ� �̻��ѵ��� �򰥸���.�� 
//(����) �׷��� �ϳ��� �߰��ǰ� �ٷ� +1���� �ٽ� �����ϴµ� �̶� �̰��� ���� ��������� �ϴ��� �򰥸� 
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
		
		// �������� ����
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
