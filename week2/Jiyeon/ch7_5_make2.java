// chapter 7 ����Ž�� - ������ �� ����� (����Ž��o)
import java.util.*;

		public class ch7_5_make2 {
	
			public static void main(String[] args) {
				/* �ǽ� �ð� : 12�� (1427~1439) */
				
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
				
				int start = 0;
				int end = arr[n-1];
				
				int result = 0;
				
				while(start <= end) {
					int mid = (start + end) / 2;
					int sum = 0;
					
					for(int i=0;i<n;i++) {
						if(arr[i] > mid)
							sum += arr[i] - mid;
					}
					
					// ���� m���� Ŭ �� (�հ�) -> ������ search
					if(sum >= m) {
						result = mid;	// ���� �� ���� �ִ밪�� �ִ��� Ȯ���Ϸ� ���� ����, ���� mid�� ����.(�� ���� �ּ��ϱ��)
						start = mid + 1; // ������ search
					}
					
					// ���� ���� m���� ���� �� -> ������ �� ���缭 ���� �ڸ� �� �ְ� �Ѵ� (���� search)
					else {
						end = mid - 1;
					}
				}
				
				System.out.println(result);
				
			   /* �ڵ� ����ð� ��� */
		       long afterTime = System.currentTimeMillis();
		       long secDiffTime = (afterTime - beforeTime) / 1000;
		       System.out.println("\n����ð�(second) : " + secDiffTime);
				


	}
}
