// �׸��� - ū ���� ��Ģ
import java.util.*;

public class ch3_2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		int k = keyboard.nextInt();
		int[] arr = new int[n];
		int result = 0;
		
		/* �迭�� ���� n�� �Է� �ޱ� */
		for(int i=0;i<n;i++) {
			arr[i]=keyboard.nextInt();
		}
		
		/* �迭�� ������������ ���� */
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		/* ���� ū ���� �� ��°�� ū �� ���� */
		int max1=arr[0];
		int max2=arr[1];
		
		/* m�� ���� ���ϱ� */
		
		int count = m / (k+1); // count : max1�� �������� Ƚ��
		count = count*k + m%(k+1); // => max1�� k��ŭ, max2�� 1��ŭ �������� ���� �ϳ��� �׷��̱� ������, (m�� k+1�� ���� �� * k) + (m�� k+1�� ���� ������) ��ŭ max1�� ���Ѵ�.
		
		result+=count*max1;
		result+=(m-count)*max2; // max2�� m���� count�� �� ����ŭ ���Ѵ�.
		
		System.out.println("\n"+result);
		
	}

}
