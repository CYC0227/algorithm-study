/*
 35��_ (�ڵ� © ��)���� ���� ���°� �ణ �򰥸�.
  	   (�ڵ� �Ǽ�)sum ������ 0���� �ʱ�ȭ���� ���� ���·� ��� while�� ���� �� + if�� ���� �߸�����
 */
import java.util.*;

public class ch7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[]arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int start = 0;
		int end = arr[n-1];
		// ���� Ž��
		while(start <= end) {
			int mid = (start + end) / 2;
			int[] cut = new int[n];
			// �ڸ� �� ,�� ���ϱ�
			int sum = 0 ;
			for(int i=0; i<n; i++) {
				cut[i] = arr[i] - mid;
				if(cut[i]<0) cut[i] = 0;
				//System.out.println(cut[i]);
				sum += cut[i];
			}
			// m���� ū ���
			if(sum == m) { 
				System.out.println(mid);
				break;
			}
			else if(sum < m) end = mid - 1;
			else start = mid + 1;
		}
	
	}

}
