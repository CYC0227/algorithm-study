// chapter 10 그래프 이론 - 도시 분할 계획

import java.util.*;

class City implements Comparable<City> {
	private int a;
	private int b;
	private int value;
	
	public City(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getValue() {
		return value;
	}
	
	// 정렬 : cost 순으로 정렬
	@Override
	public int compareTo(City arg0) {
		return getValue() - arg0.getValue();
	}
	
}
public class ch10_4_city {
	public static int n;
	public static int m;
	public static int[] parent;
	public static ArrayList<City> city = new ArrayList<>();
	
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
		/* 실습 시간 : 31 분 ( 1926 ~ 1957 )
		 * 크루스칼 알고리즘이랑 똑같음
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n+1];
		
		int result = 0;
		
		for(int i=0;i<m;i++) {
			city.add(new City(keyboard.nextInt(),keyboard.nextInt(),keyboard.nextInt()));
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		Collections.sort(city);
		
		int max = 0;
		for(int i=0;i<m;i++) {
			int a = city.get(i).getA();
			int b = city.get(i).getB();
			int value = city.get(i).getValue();
			
			if(find(a) != find(b)) {
				union(a,b);
				if(value>max)
					max = value;
				result += value;
			}
		}
		
		// 연결된 edge 중에서 가장 큰 값을 지워 도시를 분할하기
		result -= max;
		
		System.out.println(result);
		
		   /* 코드 실행시간 계산 */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
