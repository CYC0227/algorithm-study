import java.util.*;
public class _4_until1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.println("debug");
		int N = sc.nextInt();
		int K = sc.nextInt();
		int value = N;
		int result = 0;
		
		while(true) {
			
			if(value == 1) {
				//System.out.println("the end");
				break;
			}
			//��������� ��, 2��° ���
			if (value % K == 0) {
				value = value/K;
			}
			//1��° ���
			else {
				value = N - 1;
			}
			
			result++;
			
		}
		
		System.out.println(result);
	}

}

//////////����//////////
/*
import java.util.*;

public class _4_until1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N, K�� ������ �������� �����Ͽ� �Է� �ޱ�
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(true) {
			// N�� K�� ������ �������� ���� �� �������� 1�� ����
			int target = (n/k) * k;
			result += (n - target);
			n = target;
			// N�� K���� ���� �� (�� �̻� ���� �� ���� ��) �ݺ��� Ż��
			if(n < k) break;
			// K�� ������
			result += 1;
			n /= k;
		}
		
		// ���������� ���� ���� ���Ͽ� 1�� ����
		result += (n-1);
		System.out.println(result);
	}
	
}
*/