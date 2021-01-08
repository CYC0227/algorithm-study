// DFS - ����� ��� �Ա�

import java.util.*;
public class ch5_3 {

	public static int n;
	public static int m;
	public static int[][] graph = new int[1000][1000]; // �׷��� �����ϴ� �迭
	
	// dfs�Լ�
	public static boolean dfs(int x,int y) {
		
		/* �迭 ���� ���� ���� ���� ���ܽ��Ѿ� ��*/
		if(x < 0 || x >= n || y < 0 || y >= m)
			return false;
		
		/* ���� ��尡 �湮 �� �� ���¶�� ( 0�̶�� )*/
		if(graph[x][y] == 0) {
			// �湮ó�� ����
			graph[x][y]=1;
			
			/* �� �� �����¿��� ��带 ��������� �湮�ϸ鼭 0�� ���� �ִٸ� �湮ó���� ���� -> �� ����� ���� �۾� */
			dfs(x-1,y); // ��
			dfs(x+1,y); // ��
			dfs(x,y-1); // ��
			dfs(x,y+1); // ��
			
			/* main���� ȣ��� dfs�Լ��� ��������, ���ʿ� 0�̾����� ���� ������ ���� ������ ���ֵȴ�.
			     ���� ���� 4���� dfs�� false�� ��ȯ�ȴٸ�, �װ��� ���� ������¥�� ��� �� �� �̴�. 
			     �׷��Ƿ� �� if���� ���Դٸ� true�� ��ȯ�ϸ� �ȴ�!
			     �׷��� ���� ���� false�� ��ȯ�ؼ� ī��Ʈ ���� ���ϰ� �Ѵ�.
			 */
			return true;
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		keyboard.nextLine(); // ���� �ٺ��� �� �پ� �޾ƿ��� ���� ���� ����
		
		int result = 0; // ���� ����� ����
		
		/* �׷��� ���� �б� */
		for(int i=0;i<n;i++) {
			String str = keyboard.nextLine();
			for(int j=0;j<m;j++) {
				graph[i][j] = Character.getNumericValue(str.charAt(j));  // char to int
			}
		}
		
		/* ���� ��� �� ������ Ȯ�� : �迭 ���� ��ܺ��� ������ �ϴܱ��� ���鼭, dfs�Լ� ���� -> true���̸� ���� �� ��� ���� ��. */
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				/* graph[i][j]�� ���� 0�̶�� dfs�� �ϳ��� ��������� ����� �� �������� 1�� �ٲ� �� true�� ��ȯ�Ѵ�. 
				 * ����  graph[i][j]�� 1�̶�� �̹� ���� ����� ���ֵǾ��ų�, ĭ������ ���� ������ dfs�� �ٷ� false�� ��ȯ�ϱ� ������ ī��Ʈ���� �ʴ´�.*/
				if(dfs(i,j))
					result++;					
			}
		}
		
		System.out.println(result);
		
	}

}
