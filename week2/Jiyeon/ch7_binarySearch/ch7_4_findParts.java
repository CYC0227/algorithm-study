// chapter 7 ����Ž�� - ��ǰ ã��(����Ž�� )

import java.util.*;

public class ch7_4_findParts {
	
	// ��������� �ۼ�
	public static String search(int start, int end, int number, int arr[]) {

		if(start > end) return "no";
		
		int mid = (start + end) / 2;
		
		if(number == arr[mid])
			return "yes";
		else if(number < arr[mid])
			return search(start,mid-1,number,arr);
		else
			return search(mid+1,end,number,arr);
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 26�� 
		 * ����� �� : ����Ž���� ��������� �����ϴ� �Ͱ� �ݺ������� �����ϴ� ���� �򰥸�.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] store = new int[n];
		for(int i=0;i<n;i++) {
			store[i] = keyboard.nextInt();
		}

		int m = keyboard.nextInt();
		int[] customer = new int[m];
		for(int i=0;i<m;i++) {
			customer[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		
		// ������ �ִ� ��ǰ ��ȣ ������������ ����
		Arrays.sort(store);
		
		// �մ��� ��û�� ��ǰ �ִ��� Ȯ�� & ���
		for(int i=0;i<m;i++) {
			System.out.print(search(0,n-1,customer[i],store)+" ");
		}
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
	}

	
	/* ���� - �ݺ������� ����
	
public class Main {

    // ���� Ž�� �ҽ��ڵ� ����(�ݺ���)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // ã�� ��� �߰��� �ε��� ��ȯ
            if (arr[mid] == target) return mid;
            // �߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
            else if (arr[mid] > target) end = mid - 1;
            // �߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
            else start = mid + 1; 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N(������ ��ǰ ����)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // ���� Ž���� �����ϱ� ���� ������ ���� ����
        Arrays.sort(arr);

        // M(�մ��� Ȯ�� ��û�� ��ǰ ����)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // �մ��� Ȯ�� ��û�� ��ǰ ��ȣ�� �ϳ��� Ȯ��
        for (int i = 0; i < m; i++) {
            // �ش� ��ǰ�� �����ϴ��� Ȯ��
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
    */
}
