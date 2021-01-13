// chapter 9 �ִ� ��� - �̷����� ( �÷��̵� ���� ����� )

import java.util.*;

public class ch9_3_city {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 30 �� (1650 ~ 1719)
		 * ��? X�� K�� �ݴ�� �Է¹��� �Ф� �Ұ��� ��Ҷ� ȸ��� �򰥷ȴٴ°���... 
		 * ����~ ������ ��� �Ȱ���~ good~
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		int INF = 999;
		
		int vertex = keyboard.nextInt();
		int edge = keyboard.nextInt();
		int[][] arr = new int[vertex+1][vertex+1];
		int visit; // value of x
		int dest; // value of k
		int result = 0;
		
		// ������ �迭 �ʱ�ȭ ( 0 Ȥ�� INF )
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dest = keyboard.nextInt();
		visit = keyboard.nextInt();

		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		// floyd-Warshall����ؼ� 1���� visit���� �� + visit���� dest���� ���� ���ؼ� ��� ���
		for(int k=1;k<=vertex;k++) {
			for(int i=1;i<=vertex;i++) {
				for(int j=1;j<=vertex;j++) {
					if(k==i || k==j || i==j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		result = arr[1][visit] + arr[visit][dest];
		
		// �� ����� ���� ���
		if(result>=INF) 
			System.out.println("-1");
		else
			System.out.println(result);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis(); 
       long secDiffTime = (afterTime - beforeTime) / 1000; 
       System.out.println("\n����ð�(second) : " + secDiffTime); 

	}

}
