
// �׸��� - �Ž����� ����
public class ch3_1 {

	public static void main(String[] args) {
		int n = 1260; // �� �Ž����� �ݾ�
		int count = 0; // �մ��� ���� ���� ����
		int[] coins = {500,100,50,10}; // ������ ����
		
		// ���� ������ ������ŭ �ݺ��� ���� -> O(N) : N�� ���� ������ ����
		for(int i=0;i<4;i++) {
			count += n / coins[i]; // ���� �Ž������� ����ũ�⸸ŭ ���� ���� count�� �߰�
			n = n % coins[i];	// n�� �� ������������ ��ü			
		}
		
		System.out.println("total change : " + n + "\nchange counts : " + count);
	}

}
