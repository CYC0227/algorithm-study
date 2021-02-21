// chapter 18 그래프 이론 문제
package graph;

import java.util.*;

class Planet implements Comparable<Planet>{
	
	private int a,b,value;
	
	public Planet(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}
	
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Planet o) {
		if(this.value < o.value)
			return -1;
		return 1;
	}
	
}

public class q44_planet {
	public static int n; // 행성 개수
	public static int[] parent; // 부모 노드
	public static String[] info; // 행성 위치 (세가지 점)를 string 한 줄로 받기
	public static ArrayList<Planet> planet = new ArrayList<>();
	
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
			parent[a] = b;
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 54분 ( 0953 ~ 1047)
		 * 좌표 세 가지를 받는 것과, 많은 간선 중에서 n-1개만 구해야한다는 것 등등 사소하게 헷갈리는게 짱 많음
		 * 답지 보니까 arraylist가 많아서 살짝 더 헷갈리는 것 같음 ㅋㅋ
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		parent = new int[n+1];
		info = new String[n];
		keyboard.nextLine();
		
		// 행성 위치정보 받기 + 부모노드 자신으로 초기화하기
		for(int i=0;i<n;i++) {
			info[i] = keyboard.nextLine();
			parent[i+1] = i+1;
		}
		
		// 첫 번째 행성부터 마지막 행성까지 모두 짝을 이뤄서 비용을 구한다.
		for(int i=0;i<n-1;i++) {
			// a 값 구하기 ( x좌표, y좌표, z좌표 )
			int a[] = new int[3];
			for(int l=0;l<3;l++) {
				String[] temp = info[i].split(" ");
				a[l] = Integer.parseInt(temp[l]);
			}
			
			// b 값 구하기 ( x좌표, y좌표, z좌표 )
			for(int j=i+1;j<n;j++) {
				int b[] = new int[3];
				for(int s=0;s<3;s++) {
					String[] temp = info[j].split(" ");
					b[s] = Integer.parseInt(temp[s]);
				}
				
				int dis = Math.min(Math.abs(a[0]-b[0]), Math.min(Math.abs(a[1]-b[1]), Math.abs(a[2]-b[2])));
				planet.add(new Planet(i+1,j+1,dis)); // min값을 넣어준다.
			}			
		}
		// 최소비용 구해야 하니까 value기준으로 정렬 해줌
		Collections.sort(planet);
		
		int result = 0;
		int time = 0;
		int i = 0;
		
		// n-1만큼 간선을 세기 위해 while문
		while(time < n-1) {
			int a = planet.get(i).getA();
			int b = planet.get(i).getB();
			int val = planet.get(i).getValue();
			
			// cycle이 안생길 경우만 포 함
			if(find(a) != find(b)) {
				result += val;
				union(a,b);
				time++;
			}
			i++;
		}
		
		System.out.println(result);
	}

}
