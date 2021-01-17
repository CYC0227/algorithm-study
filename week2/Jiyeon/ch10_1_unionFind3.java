// chapter 10 �׷��� �̷� - ���μ� ������ Ȱ���� ����Ŭ �Ǻ�

import java.util.*;

public class ch10_1_unionFind3 {
	public static int vertex;
	public static int edge;
	public static int[] parent;
	
	public static int find(int x) {
		
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		parent = new int[vertex+1];
		boolean cycle = false;
		
		for(int i=1;i<=vertex;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			if(parent[a] == parent[b]) {
				cycle = true;
				break;
			}
			else
				union(a,b);
		}
		
		if(cycle)
			System.out.println("����Ŭ�� �߻��߽��ϴ�.");
		else
			System.out.println("����Ŭ�� �߻����� �ʾҽ��ϴ�.");
	}

}
