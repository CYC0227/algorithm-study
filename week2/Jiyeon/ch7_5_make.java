// chapter 7 ����Ž�� - ������ �� �����(����Ž��x)
import java.util.*;

public class ch7_5_make {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 26�� (1352~1418) */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt(); // ���� ����
		int m = keyboard.nextInt(); // ���� ����
		int arr[] = new int[n];

		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		// �� ���� �迭 ����
		Arrays.sort(arr);
		
		int result = 0;
		
		// ������ ������ �ִ� ���� ���� �� �ִ� �� -1 ���� 0���� ���鼭 Ȯ���Ѵ�.
		for(int i = arr[n-1]-1; i>=0;i--) {
			int sum = 0;
			
			for(int j=0;j<arr.length;j++) {
				if(arr[j] > i)
					sum += arr[j] - i;
			}
			
			if(sum >= m) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
		

	}

}
