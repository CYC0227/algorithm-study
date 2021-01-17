// chapter 10 그래프 이론 - 간단한 서로소 집합 알고리즘
import java.util.*;

public class ch10_1_unionFind {
	public static int vertex;
	public static int edge;
	public static int[] parent;
	
	// 각 노드가 속하는 부모 node 찾기
	public static int find(int node) {
		if(parent[node] != node)
			return find(parent[node]);
		
		return node;
		
	}
	
	// 노드 합치기
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 22 분 ( 1049 ~ 1111)*/
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		parent = new int[vertex+1];
		
		for(int i=1;i<=vertex;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			union(a,b);
		}
		
		System.out.print("각 원소가 속한 집합: ");
		for(int i=1;i<=vertex;i++) {
			System.out.print(find(i)+" ");
		}System.out.println();
		
		System.out.print("부모 테이블: ");
		for(int i=1;i<=vertex;i++) {
			System.out.print(parent[i]+" ");
		}

	}

}
