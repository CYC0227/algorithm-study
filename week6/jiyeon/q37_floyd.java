// chapter 17 �ִܰ�ι��� - 37�� ) �÷��̵�
package shortestPath;
import java.util.*;

public class q37_floyd {
	public static int n; // ���� ���� n
	public static int m; // ���� ���� m
	public static int[][]arr; 
	public static final int INF = 100000;
	
	public static void main(String[] args) {
		/* �ǽ��ð� : 12 �� ( 1026 ~ 1038 ) 
		 * �÷��̵� ���� ������ ��.��.��
		 * k�Ἥ ij�� �ٷ� �� ���� k ���ļ� ik+kj�� �� ���� ���ؼ� ���� �� ���
		 * �ǽ� ���������� �� ���� ��������, '������ �� ���� ���� 0�� ����Ѵ�'��� ���� ���� ����. INF�� ��쿡 0���� �ٲ��ִ� �۾����� �ؾ� ������!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		arr = new int[n+1][n+1]; // ���ð�����ŭ 2���� �迭. ���ð��� �Ÿ��� ��Ÿ���� ����
		
		// �켱 ��� ���ð��� �Ÿ��� INF
		for(int i=0;i<=n;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		// �ڱ� �ڽ����� ���� ���� 0 ( ���� )
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					arr[i][j] = 0;
			}
		}
		
		// ���� ���� m����ŭ ���ð��� �Ÿ� ������ update���ش�
		for(int i=0;i<m;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			int c = keyboard.nextInt();
			
			// ������ �ִ� �迭����, ���� ���� �Ÿ� c���� ���ؼ� ���� ������ �־���
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		/* floyd-warshall ���
		 * �տ����� ������� ����, �� ���ú��� ���� ���� ���� ����̴�.
		 * �Ʒ��� for���� ���� �����ؼ� ���� �� �ִܰŸ��� ������� floyd-warshall�� �Ǵ� ����
		 * k�� �����ؼ� arr[i][j]���� arr[i][k] + arr[k][j]��
		 * */
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][j] , arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
