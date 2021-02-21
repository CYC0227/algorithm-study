/*
 * 내 코드 왜 안돌아감
 * int a = planets.get(i).getNodeA(); 여기에서 0부터 차례대로 돌아가야 하는데 그러지 못함.. 왜..?
 * planets.add(new planet(cost, i, j)); 이렇게 하면 차례대로 잘 들어가는거 아닌가?
 * 너무 화남
 * 졸려 죽겠음
 * 그냥 자야겠슴
 * 너무 화가남
 * 왜 안돌아가는지 모르겠음
 */
import java.util.*;

class EEdge{
	private int x;
	private int y;
	private int z;
	
	public EEdge(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public int getz() {
		return this.z;
	}
	
}

class planet implements Comparable<planet> {
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public planet(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	//클래스 내의 변수는 private로 선언되어야 하기 때문에 getter 이용
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	//Collections의 sort메소드가 정렬을 위한 기준을 찾기 위해서(하지 않으면, 에러)
	//거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(planet other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class Q44 {
	
	public static int n;
	public static int[] parent = new int[100001];
	public static ArrayList<EEdge> edges = new ArrayList<>();
	public static ArrayList<planet> planets = new ArrayList<>();
	public static int result = 0;
	
	public static int solve(int ax, int ay, int az, int bx, int by, int bz) {
		int a = Math.abs(ax-bx);
		int b = Math.abs(ay-bx);
		int c = Math.abs(az-bz);
		
		int result1 = (a<b)?a:b;
		int result2 = (c<result1)?c:result1;
		return result2;
	}
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		//행성의 3차원 좌표
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			edges.add(new EEdge(x,y,z));
		}
		
		int cnt = 1; //4
		for(int i=0; i<n; i++) { //5번
			for(int j=cnt; j<=n-1; j++) { //4번 3번 2번 1번
				int cost = solve(edges.get(i).getx(), edges.get(i).gety(), edges.get(i).getz(), edges.get(j).getx(), edges.get(j).gety(), edges.get(j).getz());
				planets.add(new planet(cost, i, j));
				
			}
			cnt++;
		}
		
		Collections.sort(planets);
		
		//간선 하나씩 확인하며
		for(int i=0; i<planets.size(); i++) {
			//다른 클래스에 있기 때문에 이를 가져오기 위해서?
			int cost = planets.get(i).getDistance();
			int a = planets.get(i).getNodeA();
			int b = planets.get(i).getNodeB();
			//디버깅
			System.out.print(planets.get(i).getNodeA() + " ");
			System.out.println(planets.get(i).getNodeB());
			//사이클 발생 안하는 경우에만 집합에 포함
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
			
		}
		System.out.println(result);
	}

}
