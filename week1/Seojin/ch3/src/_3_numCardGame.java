import java.util.*;

public class _3_numCardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//�� �ึ�� ���� ���� �� ã��
		int[] minarr = new int[N];
		int min = 10000;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] < min)
					min = arr[i][j];
			}
			minarr[i] = min;
			min = 10000;
		}
		
		//minarr �߿��� ���� ū �� ã��
		int max = 0;
		
		for(int i=0; i<N; i++) {
			if(minarr[i] > max)
				max = minarr[i];
		}
		
		System.out.println(max);
		
	}

}

//////////����//////////
/*
import java.util.*;

public class _3_numCardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, M�� ������ �������� �����Ͽ� �Է� �ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		//�� �پ� �Է� �޾� Ȯ���ϱ�
		for(int i=0; i<n; i++) {
			//���� �ٿ��� '���� ���� ��' ã��
			int min_value = 10001;
			for(int j=0; j<m; j++) {
				int x = sc.nextInt();
				min_value = Math.min(min_value,x);	
			}
			//'���� ���� ��'�� �߿��� ���� ū �� ã��
			result = Math.max(result, min_value);
		}
		
		System.out.println(result);// ���� ��� ���
	}
}
*/







