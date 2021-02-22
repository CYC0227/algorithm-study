// chapter 18 그래프 이론 문제 - 42번 ) 탑승구
package graph;

import java.util.*;

public class q42_gate {
	
	public static int g; // 탑승구 수
	public static int p; // 비행기 수
	public static int[] parent; // 부모노드
	
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
		/* 실습 시간 : 분 ( 1100 ~ 1130 + 1148 ~  )
		 * 나 그냥 이해 안 감
		 * 답지 보고 예시답안 코드는 이해가 감!
		 * 근데 왜 저런 원리로..? 왜..? 
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
