// part 3 - chapter 14 ���Ĺ���  : 24��) ���׳�
package sort;

import java.util.*;

public class q24_antenna {
	
	public static int n; // ���� ��
	public static int[] arr; // �� �迭
	
	public static void sort() {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 17 ��  ( 1014 ~ 1032) 
		 * �߰� ���� �ּҰ��̶�� ���� �𸣰�, �ϳ��� �˴� ���� ���غ��ٰ� n�� �����ȵǰ� ū ���� �߰�...
		 * �׸��� ���� sort�� ������µ�, �ڹٿ��� ���� sort ������� ������
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt(); // ���� �� n
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt(); // �� ��ġ
		}
		
		sort(); // ������������ ����
		
		// �߰� ���� ���� ���� �ּҷ� �ϴ� �����̴�
		if(n%2 == 0) // ¦���� ��� �� �� ù ��° ��
			System.out.println(arr[n/2 -1]); // n/2��° ���̴ϱ� arr�󿡼��� -1�� ���� ( arr�� 0���� ������ )
		else // Ȧ���� ���
			System.out.println(arr[(n+1) / 2]);
	}

}
