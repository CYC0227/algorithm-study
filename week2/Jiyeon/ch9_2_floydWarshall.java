// chapter 9 �ִ� ��� - �÷��̵� ���� �ִܰ��  

import java.util.*;

public class ch9_2_floydWarshall {
	
	public static int INF = 999;
	
	public static void main(String[] args) {
		/* �ǽ��ð� : 37�� (1603 ~ 1640)
		 * ��? i�� j�� �򰥷���... 
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int vertex = keyboard.nextInt();
		int edge = keyboard.nextInt();
		int[][] arr = new int[vertex+1][vertex+1];
		
		// ó�� ������ �迭 0 Ȥ�� INF�� �ʱ�ȭ�ϱ�
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		// ���� ���� 2���� �迭�� �Է¹ޱ�
		for(int i=0;i<edge;i++) {
			int from = keyboard.nextInt();
			int to = keyboard.nextInt();
			int value = keyboard.nextInt();
			
			arr[from][to] = value;
		}
		
		// for���� vertex ����ŭ ������ k�� �����Ѵ�.
		for(int k=1;k<=vertex;k++) {
			
			// k�� ������ �͵��� ���ո�ŭ min���� ���ؼ� ������Ʈ �Ѵ�.
			for(int i=1;i<=vertex;i++) {
				for(int j=1;j<=vertex;j++) {
					if(i==j || i==k || j==k)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
				
			}
		}
		
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
