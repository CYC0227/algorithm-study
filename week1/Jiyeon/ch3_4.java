import java.util.*;
// �׸��� - 1�� �� ������

public class ch3_4 {

	public static void main(String[] args) {
		  Scanner keyboard = new Scanner(System.in);
				
				int n = keyboard.nextInt();
				int k = keyboard.nextInt();
				int result = 0;
				
				// n�� k���� ���� ������ �ݺ�
				while(true) {
					/* N���� 1�� ���� : n�� k�� ������ �� �ִ� ������ n���� 1�� ���ֱ� -> �� ����ŭ result �߰���Ű��, �� ������ n ����  */
					result = result + ( n % k );
					n = n - ( n % k );
					
					/* N�� K�� ������ : n�� k�� ���� ������ n�� ���� & result�� 1 ���� */
					n = n / k;
					result++;
					
					/* n�� k�� ���������� ���� �� ���ٸ�, �ݺ��� Ż�� */
					if(n<k) break;
				}
				
				/* n�� 1�� �ƴ϶�� k���� ���̸�ŭ 1�� ���ְ� �׸�ŭ result�� ���� */
				if(n!=1)
					result += k-n;
				
				System.out.println(result);				
	}

}
