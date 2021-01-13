// chapter 9 �ִ� ��� - ������ ���ͽ�Ʈ�� �˰���  
import java.util.*;

public class ch9_1_dijkstra {
	public static int INF = 999; // ���� �� ����
	public static boolean[] visited;
	public static int[] dis;
	public static int vertex;
	public static int edge;
	public static int[] from;
	public static int[] to;
	public static int[] value;
	
	// �湮���� ���� ��� �߿��� ���� ª�� �ִܰŸ� ã���ֱ�
	public static int shortest(int now) {
		
		for(int i=0;i<edge;i++) {
			if(from[i] == now && !visited[to[i]]) {
				int temp = dis[now] + value[i];
				if(temp < dis[to[i]]) {
					dis[to[i]] = temp;
				}
			}
		}
		
		int next = 0;
		int min = INF;
		for(int i=1;i<=vertex;i++) {
			if(!visited[i] && dis[i] < min) {
				min = dis[vertex];
				next = i;
			}
		}
		visited[next] = true;
		return next;
	}
	
	// vertex ������ŭ ��带 ���ļ� �ִܰŸ��� ���Ѵ�. 
	public static void dijkstra(int start) {
		int next = start;
		visited[start] = true;                                                                                                                                                                                                                                 
		
		for(int i=0;i<vertex;i++) {
			next = shortest(next);
		}
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 68�� (1010 ~ 1118)
		 * ����� �� : shortest���� next ������ �� �ε��� ������ i�� ����ϴµ� ��� vertex�� �����... 
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt(); // ��� ����
		edge = keyboard.nextInt(); // ���� ����
		int start = keyboard.nextInt(); // ���� ���
		visited = new boolean[vertex+1];
		dis = new int[vertex+1];
		from = new int[edge];
		to = new int[edge];
		value = new int[edge];

		// ���� ���� �Է¹ޱ�
		for(int i=0;i<edge;i++) {
			from[i] = keyboard.nextInt();
			to[i] = keyboard.nextInt();
			value[i] = keyboard.nextInt();
		}
		
		// �湮Ȯ�� �迭 false�� �ʱ�ȭ
		for(int i=1;i<=vertex;i++) {
			visited[i] = false;
		}
		
		// �ִܰŸ� �迭 INF�� �ʱ�ȭ
		for(int i=1;i<=vertex;i++) {
			if(i == start) // �������� 0���� �ʱ�ȭ
				dis[i] = 0;
			else
				dis[i] = INF;
		}
		
	    dijkstra(start);
	    
	    for(int i=1;i<=vertex;i++) {
			System.out.println(dis[i]);
		}
	}

}
