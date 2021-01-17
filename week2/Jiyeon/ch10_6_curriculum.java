// chapter 10 그래프 이론 - 커리큘럼 (위상정렬 사용)

import java.util.*;

public class ch10_6_curriculum {
	public static int n;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프
	public static int[] indegree; // 진입차수
	public static int[] result; // 큐에 들어가는 노드 순서대로 저장
	public static int[] time; // 각 강의 수강하는데 걸리는 시간
	
	public static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			int take = time[a]; // 총 수강하는데 걸리는 시간
			
			// 총 시간 계산 & 연결 해제
			for(int i=0;i<graph.get(a).size();i++) {
				// 시간 계산 - 연결된 노드에 가서 현재 노드의 시간 더해주기
				// result[graph.get(a).get(i)] += take; : 내가 한 코드. 이렇게 했을 때는 마지막 5번 강의 들을 때 17이 아닌 7이 자꾸 나옴 ㅠㅠ
				result[graph.get(a).get(i)] = Math.max(result[graph.get(a).get(i)], result[a] + time[graph.get(a).get(i)]);
				
				
				//연결 해제 & 진입차수가 0이면 큐에 넣기
				indegree[graph.get(a).get(i)]--;
				if(indegree[graph.get(a).get(i)] == 0)
					queue.add(graph.get(a).get(i));
			}			
		}
		
	}
	public static void main(String[] args) {
		/* 실습 시간 : 53분 ( 2210 ~ 2307 )
		 * 이유 : 일단 선수과목 화살표 방향이 너무너무 헷갈림. & 마지막에 5가 3을 들어야 하는데, 3이 1을 들어야해서 그 포함되는 시간을 반영하는게 너무너무 어려웠음
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		indegree = new int[n+1];
		result = new int[n+1];
		time = new int[n+1];
		
		// 초기화
		for(int i=1;i<=n;i++) {
			indegree[i] = 0;
			time[i] = 0;
		}
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		keyboard.nextLine();
		
		// 강의 시간과 선수과목 입력받기 -> 이게 너무너무 헷갈렸음. 어떤것의 indegree를 증가시켜야하나..
		for(int i=1;i<=n;i++) {
			
			String[] str = keyboard.nextLine().split(" ");
			
			time[i] = Integer.parseInt(str[0]); // 첫 번째는 시간
			
			if(Integer.parseInt(str[1]) == -1)
				continue;
			
			for(int j=1;j<str.length-1;j++) {
				graph.get(Integer.parseInt(str[j])).add(i); 
				indegree[i]++;
			}			
		}

		/* indegree 맞게 들어갔나 확인
		 * for(int i=1;i<=n;i++) {
			System.out.print(indegree[i]+" ");
		} System.out.println();
		*/
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=n;i++) {
			result[i] = time[i]; // result에 time 복사해주기
		}
		
		topology();
		
		for(int i=1;i<=n;i++) {
			System.out.println(result[i]);
		}
		
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
	}

}
