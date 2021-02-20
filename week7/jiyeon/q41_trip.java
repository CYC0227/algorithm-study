// chapter 18 그래프 이론 문제 - 41번 ) 여행 계획
package graph;

import java.util.*;

public class q41_trip {
	public static int n; // 여행지 수
	public static int m; // 도시 수
	public static int[] parent; // union-find 쓸 것임
	
	// 부모 찾기 ( 찾을 때까지 재귀적으로 )
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 더 작은 값이 부모가 된다.
		if(a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 30분 ( 0958 ~ 1028) 
		 * 책 바로 왼쪽 위에 서로소 집합이 있길래 서로소 집합으로 일단 해봄! 맞았당
		 * & 나는 그냥 여행 계획 도시들의 부모가 같으면 되는 걸로 했는데,
		 * 답지는 그게 아니라 루트가 동일한지를 확인한다. ( 내 답은 책의 테스트 케이스만 맞은 듯 ㅠㅠ )
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n+1];
		
		// 초기 상태 부모 배열 : 자기 자신이 부모임
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
