import java.util.Scanner;
public class _2_bignumRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, M, K;
		int[] arr = new int[999];
		Scanner sc = new Scanner(System.in);
		//�Է�
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//ū �� ã�� && 2��° ū �� ã��
		int max = 0;
		int max2 = 0;
		for(int j=0; j<N; j++) {
			if(arr[j]>=max) {
				max2 = max;
				max = arr[j];
			}
		}
		
		//ū �� ���ϱ�
		int sum = 0;
		for(int i=0; i<M/K; i++) {
			
			for(int j=0; j<K; j++) {
				sum += max;
			}
		
		}
		
		//���� M��ŭ 2��°�� ū �� ���ϱ�
		for(int i=0; i<M%K; i++) {
			sum += max2;
		}
		
		//���
		System.out.println(sum);
	}

}

//////////����//////////
/*
import java.util.*;

public class _2_bignumRule {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K�� ������ �������� �����Ͽ� �Է� �ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N���� ���� ������ �������� �����Ͽ� �Է� �ޱ�
		int[] arr = new int[n];
		for(int i=0; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		arrays.sort(arr);// �Է� ���� ���� �����ϱ�
		int first = arr[n-1];// ���� ū ��
		int second = arr[n-2];// �� ��°�� ū ��
		
		// ���� ū ���� �������� Ƚ�� ���
		int cnt = (m / (k+1)) * k;
		cnt += m % (k+1);
		
		int result = 0;
		result += cnt * first; // ���� ū �� ���ϱ�
		result += (m - cnt) * second;// �� ��°�� ū �� ���ϱ�
		
		System.out.println(result);
		
	}
}
*/












