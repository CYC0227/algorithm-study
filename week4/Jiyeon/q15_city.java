// part 3 chapter 12 dfs/bfs - 15�� ) Ư�� �Ÿ��� ���� ã�� : bfs �̿�

package dfs_bfs;

import java.util.*;

public class q15_city {
	
	public static int n; // ���� ����
	public static int m; // ���� ����
	public static int k; // �Ÿ� ����
	public static int x; // ��� ���� ��ȣ
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // ���� ���� �׷���
	public static int[] dis; // �� ������ �ִܰŸ�
	
	public static void bfs() {
		dis[x] = 0; // ��� ���ô� �ִܰŸ� 0
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			for(int i=0;i<graph.get(a).size();i++) {
				if(dis[graph.get(a).get(i)] == -1) { // ���� node a�� ����� ��尡 -1�̸� ( �湮 x�� )
					dis[graph.get(a).get(i)] = dis[a] + 1; // ���� node a�� �ִܰŸ� +1�� ���ش�.
					queue.offer(graph.get(a).get(i)); // a�� ����Ǿ��ִ� ��� �ϳ��� queue�� �־��ش�.
				}
			}
		}
		
		boolean flag = false;
		for(int i=1;i<=n;i++) {
			if( dis[i] == k ) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if(!flag)
			System.out.println("-1");
	}
	
	public static void main(String[] args) {
		/* ���� �ð� : 19�� ( 1147 ~ 1208 ) */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		k = keyboard.nextInt();
		x = keyboard.nextInt();
		dis = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			dis[i] = -1; // �湮 ���� ��� üũ
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			graph.get(a).add(b); // a���� b�� �� �� ����
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis();

		bfs();
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
