// chapter6 정렬 - 위에서 아래로

import java.util.*;
public class ch6_5 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			int index = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]>arr[index]) {
					int temp = arr[j];
					arr[j] = arr[index];
					arr[index] = temp;

					index = j;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
