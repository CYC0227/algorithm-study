// chapter 18 �׷��� �̷� ���� - 42�� ) ž�±�
package graph;

import java.util.*;

public class q42_gate {
	
	public static int g; // ž�±� ��
	public static int p; // ����� ��
	public static int[] parent; // �θ���
	
	public static int find(int x) {
		if(x != parent[x])
			return find(parent[x]);
		
		return parent[x];
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] =b;
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : �� ( 1100 ~ 1130 + 1148 ~  )
		 * �� �׳� ���� �� ��
		 * ���� ���� ���ô�� �ڵ�� ���ذ� ��!
		 * �ٵ� �� ���� ������..? ��..? 
		 * */
		Scanner keyboard = new Scanner(System.in);
		g = keyboard.nextInt();
		p = keyboard.nextInt();
		parent = new int[g+1];
		
		for(int i=1;i<=g;i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for(int i=0;i<p;i++) {
			int x = keyboard.nextInt();
			int root = find(x);
			if(root == 0) break;
			union(root,root-1);
			result++;
		}
		
		System.out.println(result);
	}

}
