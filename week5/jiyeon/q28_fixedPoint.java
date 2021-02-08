// chapter 15 - ���� Ž�� ���� : 28��) ������ ã��
package binarySearch;

import java.util.*;

public class q28_fixedPoint {
	
	public static int n; // ���δٸ� ���� n��
	public static int[] arr; // ���� ( �������� ���� )
	
	public static int search(int start, int end) {
		if(start > end) return -1; // start�� end���� Ŭ �� : ������ ���� ��
		
		int mid = (start + end) / 2;
		
		// �������� ã�� ���
		if(arr[mid] == mid) 
			return mid;
		
		// �迭 ���� mid������ ���� �� : ������ Ž��
		else if(arr[mid] < mid)
			return search(mid+1,end);
		
		else
			return search(start,mid-1);
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 10�� ( 1033 ~ 1043) 
		 * ������ ��� �ɸ�. ������
		 * ����Ž�� �����淡 ����Ž������ �غô��� �׳� �Ǵ��� �ФФ� 
		 * �� ����Ž���ϰ� ������ Ž���ϸ� �Ǵ°����� �� �𸣰���..
		 * */
		
		Scanner keyboard = new Scanner(System.in);

		n = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		System.out.println(search(0,n-1));

	}

}
