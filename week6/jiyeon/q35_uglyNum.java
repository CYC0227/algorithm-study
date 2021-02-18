// chapter 16 ���̳��� ���α׷��� - 35��) ������ ��
package dp;

import java.util.*;

public class q35_uglyNum {
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : �� ( 1233 ~ INF)
		 * ���� �� �Ф�
		 * ���� ���� ��� �� �𸣰ڱ� ��...
		 * ���߿� ���� ������ �� �� �ְ���..?
		 * 
		 * ������ �� 2,3,5�� �⺻���� �ؼ� arr���� ���ʴ�� �� ���ؼ� min���� arr�� �ݿ���
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] arr = new int[n]; // ������ �� �����ϴ� �迭
		
		int i2=0, i3=0, i5=0;
		
		int next2=2, next3=3, next5=5; // �迭�� �� �ĺ��� 3�� ( ���ؼ� min���� �߰��� )
		
		arr[0] = 1; // 1�� ������ ���� ����
		
		for(int l=1;l<n;l++) {
			arr[l] = Math.min(next2, Math.min(next3, next5));
			
			// next2, next3, next5�� ���� 2,3,5�� ����� �̷���� ������
			
			if(arr[l] == next2) {
				i2+=1; // 2�� �ε��� 1 ����
				next2 = arr[i2]*2; // �ε��� ���� �� �� �ڸ� ���� 2�� ���� ���� �迭�� �� �ĺ����� �־��ֱ�
			}
			if(arr[l] == next3) {
				i3+=1;
				next3 = arr[i3]*3;
			}
			if(arr[l] == next5) {
				i5+=1;
				next5 = arr[i5]*5;
			}
		}
		
		System.out.println(arr[n-1]);
		
		

	}

}
