// chapter 7 ����Ž�� - ��ǰã�� (�������)

import java.util.Arrays;
import java.util.Scanner;

public class ch7_4_findParts2 {

	// ������� �̿� : ���԰� ������ �ִ� ��ǰ�� index�� 1�� �ء���.
		
		public static void main(String[] args) {
			/* �ǽ� �ð� : 6�� (2143 ~ 2149) 
			 * ����� �� : X
			 * */
			
			Scanner keyboard = new Scanner(System.in);
			
			// ���� ���
			int n = keyboard.nextInt();
			int[] store = new int[1000000]; // ������Ŀ� �̿��� �迭
			for(int i=0;i<n;i++) {
				int check = keyboard.nextInt();
				store[check] = 1; // ���԰� ������ �ִ� ��ǰ�� array�� 1�� �ٲ��ش�.
			}
			
			// �մ� ��û
			int m = keyboard.nextInt();
			int[] customer = new int[m];
			for(int i=0;i<m;i++) {
				customer[i] = keyboard.nextInt();
			}
			
			
			// �մ��� ��û�� ��ǰ �ִ��� Ȯ�� & ���
			for(int i=0;i<m;i++) {
				if(store[customer[i]] == 1)
					System.out.print("yes ");
				else
					System.out.print("no ");
			}
		}
}
