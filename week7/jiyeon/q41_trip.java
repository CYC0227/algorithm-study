// chapter 18 �׷��� �̷� ���� - 41�� ) ���� ��ȹ
package graph;

import java.util.*;

public class q41_trip {
	public static int n; // ������ ��
	public static int m; // ���� ��
	public static int[] parent; // union-find �� ����
	
	// �θ� ã�� ( ã�� ������ ��������� )
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// �� ���� ���� �θ� �ȴ�.
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 30�� ( 0958 ~ 1028) 
		 * å �ٷ� ���� ���� ���μ� ������ �ֱ淡 ���μ� �������� �ϴ� �غ�! �¾Ҵ�
		 * & ���� �׳� ���� ��ȹ ���õ��� �θ� ������ �Ǵ� �ɷ� �ߴµ�,
		 * ������ �װ� �ƴ϶� ��Ʈ�� ���������� Ȯ���Ѵ�. ( �� ���� å�� �׽�Ʈ ���̽��� ���� �� �Ф� )
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n+1];
		
		// �ʱ� ���� �θ� �迭 : �ڱ� �ڽ��� �θ���
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int temp = keyboard.nextInt();
				
				if(temp == 1) {
					union(i+1,j+1);
				}
			}
		}
		
		int[] plan = new int[m];
		for(int i=0;i<m;i++) {
			plan[i] = keyboard.nextInt();
		}
		
		int result = 1;
		
		for(int i=2;i<=n;i++) {
			if(parent[i-1] != parent[i])
				result = 0;
		}
		
		if(result == 1) System.out.println("YES");
		else System.out.println("NO");
	}

}
