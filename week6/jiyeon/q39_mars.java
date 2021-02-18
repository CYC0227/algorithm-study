// chapter 17 �ִ� ��� ���� - 39��) ȭ�� Ž��
package shortestPath;
import java.util.*;

class Mars implements Comparable<Mars>{
	private int x;
	private int y;
	private int dis;
	
	public Mars(int x, int y, int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDis() {
		return this.dis;
	}

	@Override
	public int compareTo(Mars o) {
		// TODO Auto-generated method stub
		if(this.dis < o.dis)
			return -1;
		
		return 1;
	}
	
}

public class q39_mars {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 74�� ( 1050 ~ 1204 )
		 * �ڲ��ڲ� 10�� ���Դ�.
		 * �˰��� INF���� 10���� �����س��� 10���� ū ���� ���ܳ��� ������ 10�� ���õǱ� �����̾��� �ФФ�
		 * INF���� �ִ��� ���� ��ƾ߰ڴ� �����δ�..
		 * && �湮�� ��� ó���� �� �湮ó������ if���� ���� �Ἥ ��� ����
		 * */
		Scanner keyboard = new Scanner(System.in);
		int t = keyboard.nextInt(); // test case ����
		int n; // Ž�� ������ ũ��
		int INF = 100000; // ũ���� �ִ� ����� 9�ϱ� ���Ѵ븦 10���� ���� -> �ߴٰ� ����. �ܼ��� �ִ��� ���� ���� �ִ����� �����ؾ��� ��
		
		// �����¿�� �̵�
		int[] x = {-1,1,0,0};
		int[] y = {0,0,-1,1};
		
		while(t>0) {
			
			n = keyboard.nextInt(); // Ž�� ������ ũ��
			int[][] arr = new int[n][n];
			int[][] d = new int[n][n];
			int[][] visitied = new int[n][n]; // �湮 : 1
			
			PriorityQueue<Mars> q = new PriorityQueue<>();
			
			for(int i=0;i<n;i++) {
				Arrays.fill(d[i],INF);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = keyboard.nextInt();
				}
			}
			
			int a=0,b=0; // ������ġ a,b
			q.offer(new Mars(0,0,arr[0][0]));
			d[0][0] = arr[0][0];
			
			while(!q.isEmpty()) {
				Mars now = q.poll();
				a = now.getX();
				b = now.getY();
				int dist = now.getDis();
				
				// �̹� �湮�� ���� �н��ϱ�
				if(visitied[a][b] == 1) continue;
				
				visitied[0][0] = 1; // ���� ��� �湮ó�� 
				
				// �����¿�� ��
				for(int i=0;i<4;i++) {
					if(a+x[i]<0 || a+x[i]>=n || b+y[i]<0 || b+y[i]>=n) 	continue; // ���� ����� �н�
					
					int cost = dist + arr[a+x[i]][b+y[i]]; // ���� �Ÿ����� ��,��,��,�� �Ÿ��� �� �ϳ� �����ֱ� ( �ٷΰ��� vs  ���İ��� )
					
					// ���İ��� ���� �ٷ� ���� �ͺ��� ������ ������Ʈ
					if(cost < d[a+x[i]][b+y[i]]) {
						d[a+x[i]][b+y[i]] = cost;
						q.offer(new Mars(a+x[i],b+y[i],cost));
					}
				}
			}
			
			System.out.println(d[n-1][n-1]);
			t--;
		}
	}

}
