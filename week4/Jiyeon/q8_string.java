// part3 - chapter 12 ���� : 8��) ���ڿ� ������

package greedy;

import java.util.*;

public class q8_string {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 26�� ( 1302 ~ 1328 )
		 * ��� �ؾ� �� �����ϴ°��� ���� �ʹ��ʹ� �������.. ��������
		 * �� : ���ο� ���list�� ������ �ʰ�, �켱 �Է� ���� �迭�� ���� -> ���ڴ� ��� ������ ��.
		 * -> ���ĺ� �����ϴ� index���� ������ ����ϰ�, ���ڵ��� �� ���ϱ�
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis();
		
		char[] chars = str.toCharArray();
		
		Arrays.sort(chars);
		
		int sum = 0;
		int index = 0;
		
		for(int i=0;i<chars.length;i++) {
			if(chars[i]>=65 && chars[i]<=90) {
				index = i;
				break;
			}
			else
				sum += Character.getNumericValue(chars[i]);
		}
		
		for(int i=index;i<chars.length;i++) {
			System.out.print(chars[i]);
		}
		System.out.println(sum);

		/* �ڵ� ����ð� ��� */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n����ð�(second) : " + secDiffTime);
	}

}
