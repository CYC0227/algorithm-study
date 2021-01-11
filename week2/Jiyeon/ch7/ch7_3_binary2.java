// chapter 7 ����Ž�� - �ݺ������� ����
import java.util.*;

public class ch7_3_binary2 {
	
	public static int binary(int[] arr, int number) {
		int start = 0;
		int end = arr.length -1;
		int mid = (start + end)/2;
		
		while(start<=end) {
			mid = (start + end)/2;
			
			if(arr[mid] == number)
				return mid;
			else if(number < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		// ���Ұ� ������
		return -1;
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 8�� */
		
		 Scanner keyboard = new Scanner(System.in);
		 
		 int size = keyboard.nextInt();
		 int search = keyboard.nextInt();
		 int arr[] = new int[size];
		 
		 for(int i=0;i<size;i++) {
			 arr[i] = keyboard.nextInt();
		 }
		 
		 /* �ڵ� ����ð� ��� */
			long beforeTime = System.currentTimeMillis(); 
			
			int result = binary(arr,search);
			
			if(result == -1)
				System.out.println("���Ұ� �������� �ʽ��ϴ�.");
			else
				System.out.println(result+1);
			
		/* �ڵ� ����ð� ��� */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("����ð�(second) : " + secDiffTime);
	}

}
