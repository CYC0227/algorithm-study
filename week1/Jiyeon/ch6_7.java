// chapter7 ���� - �� �迭�� ���� ��ü

import java.util.*;

public class ch6_7 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int k = keyboard.nextInt();
		
		int[] a = new int[n];
		int[] b= new int[n];
		
		// �迭�� �Է� �ޱ�
		for(int i=0;i<n;i++) {
			a[i] = keyboard.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i] = keyboard.nextInt();
		}
		
		// k�� �ݺ�
		for(int i=0;i<k;i++) {
			
			int min_index = 0;
			int max_index = 0;
			
			// a�� �ּҰ��� b�� �ִ밪 ã��
			for(int j=0;j<n;j++) {
				
				if(a[j] < a[min_index]) {
					min_index= j;
				}
				
				if(b[j]>b[max_index]) {
					max_index=j;
				}
				
			}
			
			// a�� �ּҰ����� b�� �ִ밪�� ũ�ٸ� ��ü
			if(a[min_index] < b[max_index]) {
				 int temp = a[min_index];
				 a[min_index] = b[max_index];
				 b[max_index] = temp;
			}
			
			// ���̻�  �迭�� a���� ū �� ������ ��ü ����
			else break;
			
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			result+=a[i];
		}
		
		System.out.println(result); 

	}

}
