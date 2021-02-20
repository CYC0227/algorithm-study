// chapter 18 그래프 이론 문제 - 43번) 어두운 길
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
	
	public static int n; // 집의 수
	public static int m; // 도로 수
	public static int[] parent; // 부모 노드
	public static ArrayList<Road> list = new ArrayList<>();
	
	public static int find(int x) {
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		// 작은 값이 부모노드
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;	
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 20 분 ( 1033 ~ 1053 )
		 * 41번 문제랑 비슷함. union-find 사용
		 * 그리고 사이클 생기는지 아닌지를 판단해서 필요 없는 길 찾음 ( 크루스칼 알고리즘 )
		 * 그치만 솔직히 그래프 이론 부분에 없었으면 난 몰랐을 것임...
		 * 그리고 조금 헤멘 부분 : 사이클 안 생기는 부분들 값을 더해서 결과로 출력했는ㄴ데.. 전체에서 뺀 값이 답이었음 ㅠㅠ 그걸로 조금 헤멤..
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n];
		int total = 0; // 가로등 비용 총 금액
		
		// 처음은 자기 자신이 부모임
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
		
		int save = 0; // 비활성화 안 된 도로들 ( 반드시 켜져야 하는 도로들 )
		
		for(int i=0;i<m;i++) {
			int a = list.get(i).getX();
			int b = list.get(i).getY();
			
			// 사이클 안 생기면 save에 추가함 ( 사이클이 생기면 그 길 말고도 다른 길로 갈 수 있는 방법이 있다는 것! 비활성화해서 절약 가능 )
			if(find(a) != find(b)) {
				save += list.get(i).getValue();
				union(a,b); // 이제 이 둘을 지나는 사이클 판별을 위해 부모를 합쳐준다
			}
		}
		
		System.out.println(total - save);
	}

}
