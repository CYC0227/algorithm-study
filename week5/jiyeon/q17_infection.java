// part3 - chapter 12 ���� : 17�� ) ������ ����
package dfs_bfs;

import java.util.*;

class Node implements Comparable<Node>{
	private int x;
	private int y;
	private int virus;
	
	public Node(int virus, int x, int y) {
		this.virus = virus;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getVirus() {
		return this.virus;
	}

	@Override
	public int compareTo(Node o) {
		if(this.virus < o.virus)
			return -1;
		
		return 1;
	}
}

public class q17_infection {

	public static int n; // ������� ũ��
	public static int k; // ���̷��� ����
	public static int[][] arr; // ����� �迭
	public static ArrayList<Node> exam = new ArrayList<Node>();
	public static int s; // s�� �ڿ� ���̷��� ���� Ȯ��
	public static int x; // s�� �ڿ� Ȯ�� �� x ��ġ
	public static int y; // s�� �ڿ� Ȯ�� �� y ��ġ
	
	public static void virus() {
		Queue<Node> queue = new LinkedList<Node>();
		
		// queue�� �־��ֱ�
		for(int i=0;i<exam.size();i++) {
			queue.add(exam.get(i));
		}
		
		// 1�ʺ��� s�ʱ��� ���̷��� ������Ű��
		for(int i=1;i<=s;i++) {
			
			// queue�� ���̷����� ���� ������
			while(!queue.isEmpty()) {
				Node now = queue.poll();
				int a = now.getX();
				int b = now.getY();
				int v = now.getVirus();
				// ����� �迭 ���鼭 ���̷��� ������Ű��
					// ��
					if(a-1 > 0) {
						if(arr[a-1][b] == 0) {
							arr[a-1][b] = v;
							exam.add(new Node(v,a-1,b)); // �迭�� �߰��ϰ� arraylist���� �߰����ֱ�
						}
					}
					// ��
					if(a+1 <= n) {
						if(arr[a+1][b] == 0) {
							arr[a+1][b] = v;
							exam.add(new Node(v,a+1,b)); // �迭�� �߰��ϰ� arraylist���� �߰����ֱ�
						}
					}
					// ��
					if(b-1 > 0) {
						if(arr[a][b-1] == 0) {
							arr[a][b-1] = v;
							exam.add(new Node(v,a,b-1)); // �迭�� �߰��ϰ� arraylist���� �߰����ֱ�
						}
					}
					// ��
					if(b+1 <= n) {
						if(arr[a][b+1] == 0) {
							arr[a][b+1] = v;
							exam.add(new Node(v,a,b+1)); // �迭�� �߰��ϰ� arraylist���� �߰����ֱ�
						}
					}
				}
				
				// ���Ӱ� �߰��� virus�� �����ϰ� queue�� �־��ֱ�
				Collections.sort(exam);
				for(int j=0;j<exam.size();j++) {
					queue.add(exam.get(j));
				}
				
			}
		}
	
	public static void main(String[] args) {
		/* �ǽ� �ð�  :87 �� ( 1338 ~ 1503 )
		 * 1. queue�� ���� ���� �� arraylist�� �����;ߵǴµ� queue ����� �����ͼ� �ƹ��͵� �� �־�����... �װſ��� �ð� ���� ��
		 * 2. �ʰ� ���� ������ queue�� ���Ӱ� ����־�� �ϴµ� �� �κ��� �ڱ� while �ȿ� �־ �ڵ尡 �� ������..
		 * 3. arraylist ���� ���� ������ ������� �ʰ�, ���� �ϳ��� ���ϸ鼭 queue�� �������� �ߴµ� ������ŭ ���� �ʾƼ� �ᱹ sort ���
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		k = keyboard.nextInt();
		arr = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = keyboard.nextInt();
				
				// ���̷����� �����ϸ� arraylist�� ���� �־��ֱ�
				if(arr[i][j] != 0) 
					exam.add(new Node(arr[i][j], i,j));
			}
		}
		
		s = keyboard.nextInt(); // s�� �ڿ� ���̷��� ���� Ȯ��
		x = keyboard.nextInt(); // s�� �ڿ� Ȯ�� �� x ��ġ
		y = keyboard.nextInt(); // s�� �ڿ� Ȯ�� �� y ��ġ
		
		Collections.sort(exam); // ���̷��� ��ȣ ũ���� ����
		
		virus();
		
		System.out.println(arr[x][y]);
	}

}
