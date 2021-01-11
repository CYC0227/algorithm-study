// chapter 7 ����Ž�� - ��������� ������ ����Ž��

import java.util.*;

public class ch7_2_binary {
	
	public static int index = -1;
	public static int size;
	public static int search;
	
	/* ��������� ����*/
	public static void binary(int start, int end, int number,int[] arr) {
		// ���ĵǾ��ִ� �Լ��̱� ������, �������� �������� �ڿ� �������� search ����
		if(start>end)
			return;
		
		int mid = (start+end)/2; // (start+end / 2) = �߰���
		
		// �߰����� ���� ��� search ����
		if(number == arr[mid]) {
			index = mid;
			return;
		}
		// �߰������� ���� ��� -> ���� Ž��
		else if(number < arr[mid]) {
			binary(start,mid-1,number,arr);
			return;
		}
		// �߰������� ū ��� -> ������ Ž��
		else {
			binary(mid+1,end,number,arr);
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		size = keyboard.nextInt();
		search = keyboard.nextInt();

		int arr[] = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		binary(0,size-1,search,arr);
		
		if(index>=0) 
			System.out.println(index+1);
		else
			System.out.println("���Ұ� �������� �ʽ��ϴ�.");
		
		
		/* �ڵ� ����ð� ��� */
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
        System.out.println("����ð�(second) : " + secDiffTime);
	}
	
	/* 
	 ����
	 
	 import java.util.*;

public class Main {

    // ���� Ž�� �ҽ��ڵ� ����(��� �Լ�)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // ã�� ��� �߰��� �ε��� ��ȯ
        if (arr[mid] == target) return mid;
        // �߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // �߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
        else return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // ������ ����(n)�� ã���� �ϴ� ��(target)�� �Է¹ޱ� 
        int n = sc.nextInt();
        int target = sc.nextInt();

        // ��ü ���� �Է¹ޱ� 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ���� Ž�� ���� ��� ��� 
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("���Ұ� �������� �ʽ��ϴ�.");
        }
        else {
            System.out.println(result + 1);
        }
    }

}
	  */

}
