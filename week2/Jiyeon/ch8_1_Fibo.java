// chapter 8 ���̳��� ���α׷��� - �Ǻ���ġ ���� ( ���̳��� X ��ȿ������ ������� )
public class ch8_1_Fibo {
	
	/* ��������� ��� �Ǻ���ġ �Լ��� �θ��ٸ�, n���� Ŀ�� �� �ɰ��� �ð� �ʰ��� �� �� �ִ�. 
	 * Fibo(100)�� ����Ѵٸ� ����� �� �Ŀ� ���� ã�� �� �ִ� �� */

	public static int Fibo(int n) {
		
		if(n==1) return 1;
		if(n==2) return 1;
		
		return Fibo(n-2) + Fibo(n-1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(Fibo(4));
	}

}
