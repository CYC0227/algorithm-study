// part 3 - chapter 15 ���� Ž�� ���� : 27�� ) ���ĵ� �迭���� Ư�� ���� ���� ���ϱ�
package binarySearch;

import java.util.*;

public class q27_sortedArray {
	
	public static int n; // n���� ����
	public static int x; // x�� �����ϴ� Ƚ�� ���ϱ�
	public static int[] arr; // n���� ���Ҹ� �����ϴ� ���� ( ������������ ���ĵǾ� ���� )
	public static int result = 0; // x�� � �������� �����ϴ� ����
	public static int index = -1;
	
	public static void search(int start, int end) {
		if( start > end ) return;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == x) {
			index = mid;
		}
		else if (arr[mid] < x) {
			search(mid+1, end);
		}
		else 
			search(start, mid);
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 21 �� ( 1116 ~ 1137 )
		 * for�� 2�� �Ἥ ����� ����ߴµ�, �ð� �ʰ� �� 
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		x = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		search(0,n-1);
		
		if(index == -1)
			System.out.println("-1");
		
		else {
			 for(int i=index; i>=0; i--) {
				 if(arr[i] == x)
					 result++;
				 else
					 break;
			 }
			 for(int i=index+1;i<n;i++) {
				 if(arr[i] == x)
					 result++;
				 else
					 break;
			 }
			 System.out.println(result);
		}
		

	}

}
