// part 3 - chapter 14 ���� ���� : 26�� ) ī�� �����ϱ�
package sort;

import java.util.*;

public class q26_card {
	
	public static void main(String[] args) {
		/* �ǽ��ð� : 9 �� ( 1044 ~ 1053 ) 
		 * ������������ �����ؼ� �տ������� ���ϴ� ���� ���� ���� ������̶�� ������.
		 * ���÷� ���� �׽�Ʈ���̽����� �� �´µ�, ��� ���̽��� �´� �������� �� �𸣰���
		 * */
		
		Scanner keyboard = new Scanner(System.in);

		int n; // ����ī�� n��
		ArrayList<Integer> card = new ArrayList<>();
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			int a = keyboard.nextInt();
			card.add(a);
		}
		
		Collections.sort(card); // ������������ ī�� ���� �����ϱ�
		
		int sum = card.get(0) + card.get(1); // ù��° ���� ����� arraylist�� ù ��°�� �� ��° ��ģ ��
		int now = sum;
		
		for(int i=2;i<n;i++) {
			now += card.get(i); // ��������� ��� ���� i��° ���� �����ش�.
			sum += now; // ���Ѹ�ŭ�� ��ü ����� ���ؼ� ����Ѵ�.
		}
		
		System.out.println(sum);
	}

}
