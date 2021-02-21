/*
* union-find로 풀 생각을 못해서 계속 헤맸던 문제
* 왜 서로소 집합 알고리즘에 적용할 생각을 못했찡 ㅜ.ㅍ
* 
* 처음에는 한 정점에 1개 이상의 간선이 있어서 ArrayList안에 ArrayList를 집어넣은 그래프를 만들고자 함
* 이것으로 풀 수 있을 것 같은데 실력미흡으로 포기
* ex) 2->3 : 3이 나올 때까지 그래프를 계속 돌고 없으면, NO
* 			  근데 이때 그래프를 계속(찾을 때까지 끝까지         ) 도는 코딩을 짜지 못함
*/


//union-find로 풀려고 한 코드
/*
import java.util.*;

public class Q41 {
	
	public static int n,m;
	public static int[][] arr; //연결 여부 담기
	//public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[]  arr2;
	public static int[] parent = new int[100001];
	
	public static int findParent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<=b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][n];
		arr2 = new int[m];
		
		//그래프 초기화
		//for(int i=0; i<n; i++) {
		//	graph.add(new ArrayList<Integer>());
		//}
		
		//그래프 생성
		//for(int i=1; i<=n; i++) {
		//	for(int j=1; j<=n; j++) {
		//		arr[i][j] = sc.nextInt();
		//		if(arr[i][j] == 1) {
		//			graph.get(i).add(j);//i점에서 j점으로 이동 가능
		//		}
		//	}
		//}
		
		
		//연결 유무 입력 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//여행 계획에 속한 도시의 수 입력 받기
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		//union 실행
		for(int i=0; i<m-1;i++) {
			int a = arr2[i];
			int b = arr2[i+1];
			unionParent(a,b);
		}
		
		//
		for(int i=0; i<m; i++) {
			if(parent[i]!=parent[i+1]) {
				System.out.println("NO");
				break;
			}
		}
	}

}
*/

//그래프로 풀려고 한 코드
/*
import java.util.*;

public class Q41 {
	
	public static int n,m;
	public static int[][] arr; //연결 여부 담기
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[]  arr2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][n];
		arr2 = new int[m];
		//그래프 초기화
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//그래프 생성
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					graph.get(i).add(j);//i점에서 j점으로 이동 가능
				}
			}
		}
		
		//여행 계획에 속한 도시의 수 입력 받기
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		//여행지가 모두 연결되어 있는지만 확인x
		//지정된 정점에 연결된 정점을 통해 원하는 것이 있는지 확인
		
		for(int i=0; i<m; i++) {
			int now = arr2[i];
			//다음 순서 찾을 때까지
			while(true) {
				//arr[i+1]==graph.get(now).get(i)
				for(int j=0;)
			}
		}
		
	}

}
*/