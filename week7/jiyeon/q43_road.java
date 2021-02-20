// chapter 18 �׷��� �̷� ���� - 43��) ��ο� ��
package graph;

import java.util.*;
class Road implements Comparable<Road>{
	private int x,y,value;
	
	public Road(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Road o) {
		if(this.value < o.value) return -1;
		
		return 1;
	}
	
}
public class q43_road {
	
	public static int n; // ���� ��
	public static int m; // ���� ��
	public static int[] parent; // �θ� ���
	public static ArrayList<Road> list = new ArrayList<>();
	
	public static int find(int x) {
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		// ���� ���� �θ���
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;	
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 20 �� ( 1033 ~ 1053 )
		 * 41�� ������ �����. union-find ���
		 * �׸��� ����Ŭ ������� �ƴ����� �Ǵ��ؼ� �ʿ� ���� �� ã�� ( ũ�罺Į �˰��� )
		 * ��ġ�� ������ �׷��� �̷� �κп� �������� �� ������ ����...
		 * �׸��� ���� ��� �κ� : ����Ŭ �� ����� �κе� ���� ���ؼ� ����� ����ߴ¤���.. ��ü���� �� ���� ���̾��� �Ф� �װɷ� ���� ���..
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n];
		int total = 0; // ���ε� ��� �� �ݾ�
		
		// ó���� �ڱ� �ڽ��� �θ���
		for(int i=0;i<n;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			int a,b,c;
			a = keyboard.nextInt();
			b = keyboard.nextInt();
			c = keyboard.nextInt();
			total += c;
			
			list.add(new Road(a,b,c));
		}
		
		Collections.sort(list);
		
		int save = 0; // ��Ȱ��ȭ �� �� ���ε� ( �ݵ�� ������ �ϴ� ���ε� )
		
		for(int i=0;i<m;i++) {
			int a = list.get(i).getX();
			int b = list.get(i).getY();
			
			// ����Ŭ �� ����� save�� �߰��� ( ����Ŭ�� ����� �� �� ���� �ٸ� ��� �� �� �ִ� ����� �ִٴ� ��! ��Ȱ��ȭ�ؼ� ���� ���� )
			if(find(a) != find(b)) {
				save += list.get(i).getValue();
				union(a,b); // ���� �� ���� ������ ����Ŭ �Ǻ��� ���� �θ� �����ش�
			}
		}
		
		System.out.println(total - save);
	}

}
