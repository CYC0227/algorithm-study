// �׸��� - ���� ī�� ����

import java.util.*;
public class ch3_3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		int result = 0; // �ּҰ� �� �ִ밪�� ������ ����
		
		for(int i=0; i<n; i++) {
			int min = 101;	// �� ���� �ּҰ�
			
			/* �� �࿡�� �ּҰ��� ã�´� */
			for(int j=0; j<m; j++) {
				int a = keyboard.nextInt();
				if( a < min )
					min = a;
			}
			
			/* ã�� �ּҰ��� result�� ���Ͽ� �� ū ���� result�� ���� */
			if( min > result )
				result = min;
		}
		
		System.out.println(result);
		
	}
}
