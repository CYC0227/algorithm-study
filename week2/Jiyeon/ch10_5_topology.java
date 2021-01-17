// chapter 10 그래프 이론 - 위상정렬

import java.util.*;

public class ch10_5_topology {
	public static int vertex;
	public static int edge;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프
	public static int[] indegree; // 진입차수
	public static int[] result; // 큐에 삽입된 노드 저장
	
	public static void topology() {
		Queue<Integer> queue = new LinkedList<>(); // 진입차수가 0인 노드 저장할 큐
		
		for(int i=1;i<=vertex;i++) {
			if(indegree[i] == 0)
				queue.add(i); // 첨에 진입차수가 0이면 큐에 일단 넣기
		}
		
		int index = 0;
		while(!queue.isEmpty()) {
			int a = queue.poll(); // 큐에 있는 첫 번째 값 가져오면서 삭제하기
			
			// 큐에서 나온 값을 결과 배열에 넣어주기
			result[index] = a;
			index++;
			
			for(int i=0;i<graph.get(a).size();i++) {
				indegree[graph.get(a).get(i)]--; // a가 가르키고 있는 노드의 진입차수를 1 삭제한다. ( 연결 끊어주기 )
				
				// -1 한 후에 진입차수가 0이 되면 큐에 넣어주기
				if(indegree[graph.get(a).get(i)] == 0)
					queue.add(graph.get(a).get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 31 분 ( 2138 ~ 2209)*/
		
		Scanner keyboard = new Scanner(System.in);
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		indegree = new int[vertex+1];
		result = new int[vertex];
		
		// 초기화
		for(int i=1;i<=vertex;i++) {
			indegree[i] = 0;
		}
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			graph.get(a).add(b);	// a가 가르키는 것이 b
			
			indegree[b]++; // 가르킴 당하는 것의 진입차수 1 증가 ( 진입차수 : 들어오는 간선의 개수 )
		}
		
		topology();
		
		for(int i=0;i<vertex;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
