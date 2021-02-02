// part3 - chapter 12 구현 : 17번 ) 경쟁적 전염
package dfs_bfs;

import java.util.*;

class Node implements Comparable<Node>{
	private int x;
	private int y;
	private int virus;
	
	public Node(int virus, int x, int y) {
		this.virus = virus;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getVirus() {
		return this.virus;
	}

	@Override
	public int compareTo(Node o) {
		if(this.virus < o.virus)
			return -1;
		
		return 1;
	}
}

public class q17_infection {

	public static int n; // 시험관의 크기
	public static int k; // 바이러스 종류
	public static int[][] arr; // 시험관 배열
	public static ArrayList<Node> exam = new ArrayList<Node>();
	public static int s; // s초 뒤에 바이러스 정보 확인
	public static int x; // s초 뒤에 확인 할 x 위치
	public static int y; // s초 뒤에 확인 할 y 위치
	
	public static void virus() {
		Queue<Node> queue = new LinkedList<Node>();
		
		// queue에 넣어주기
		for(int i=0;i<exam.size();i++) {
			queue.add(exam.get(i));
		}
		
		// 1초부터 s초까지 바이러스 전염시키기
		for(int i=1;i<=s;i++) {
			
			// queue에 바이러스가 없을 때까지
			while(!queue.isEmpty()) {
				Node now = queue.poll();
				int a = now.getX();
				int b = now.getY();
				int v = now.getVirus();
				// 시험관 배열 돌면서 바이러스 감염시키기
					// 상
					if(a-1 > 0) {
						if(arr[a-1][b] == 0) {
							arr[a-1][b] = v;
							exam.add(new Node(v,a-1,b)); // 배열에 추가하고 arraylist에도 추가해주기
						}
					}
					// 하
					if(a+1 <= n) {
						if(arr[a+1][b] == 0) {
							arr[a+1][b] = v;
							exam.add(new Node(v,a+1,b)); // 배열에 추가하고 arraylist에도 추가해주기
						}
					}
					// 좌
					if(b-1 > 0) {
						if(arr[a][b-1] == 0) {
							arr[a][b-1] = v;
							exam.add(new Node(v,a,b-1)); // 배열에 추가하고 arraylist에도 추가해주기
						}
					}
					// 우
					if(b+1 <= n) {
						if(arr[a][b+1] == 0) {
							arr[a][b+1] = v;
							exam.add(new Node(v,a,b+1)); // 배열에 추가하고 arraylist에도 추가해주기
						}
					}
				}
				
				// 새롭게 추가된 virus들 정렬하고 queue에 넣어주기
				Collections.sort(exam);
				for(int j=0;j<exam.size();j++) {
					queue.add(exam.get(j));
				}
				
			}
		}
	
	public static void main(String[] args) {
		/* 실습 시간  :87 분 ( 1338 ~ 1503 )
		 * 1. queue에 집어 넣을 때 arraylist를 가져와야되는데 queue 사이즈를 가져와서 아무것도 안 넣어졌다... 그거에서 시간 많이 씀
		 * 2. 초가 지날 때마다 queue에 새롭게 집어넣어야 하는데 그 부분을 자구 while 안에 넣어서 코드가 안 끝났다..
		 * 3. arraylist 만들 때도 정렬을 사용하지 않고, 수를 하나씩 비교하면서 queue에 넣으려고 했는데 생각만큼 되지 않아서 결국 sort 사용
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		k = keyboard.nextInt();
		arr = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = keyboard.nextInt();
				
				// 바이러스가 존재하면 arraylist에 정보 넣어주기
				if(arr[i][j] != 0) 
					exam.add(new Node(arr[i][j], i,j));
			}
		}
		
		s = keyboard.nextInt(); // s초 뒤에 바이러스 정보 확인
		x = keyboard.nextInt(); // s초 뒤에 확인 할 x 위치
		y = keyboard.nextInt(); // s초 뒤에 확인 할 y 위치
		
		Collections.sort(exam); // 바이러스 번호 크기대로 정렬
		
		virus();
		
		System.out.println(arr[x][y]);
	}

}
