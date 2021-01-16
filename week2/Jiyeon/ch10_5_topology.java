// chapter 10 �׷��� �̷� - ��������

import java.util.*;

public class ch10_5_topology {
	public static int vertex;
	public static int edge;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // �׷���
	public static int[] indegree; // ��������
	public static int[] result; // ť�� ���Ե� ��� ����
	
	public static void topology() {
		Queue<Integer> queue = new LinkedList<>(); // ���������� 0�� ��� ������ ť
		
		for(int i=1;i<=vertex;i++) {
			if(indegree[i] == 0)
				queue.add(i); // ÷�� ���������� 0�̸� ť�� �ϴ� �ֱ�
		}
		
		int index = 0;
		while(!queue.isEmpty()) {
			int a = queue.poll(); // ť�� �ִ� ù ��° �� �������鼭 �����ϱ�
			
			// ť���� ���� ���� ��� �迭�� �־��ֱ�
			result[index] = a;
			index++;
			
			for(int i=0;i<graph.get(a).size();i++) {
				indegree[graph.get(a).get(i)]--; // a�� ����Ű�� �ִ� ����� ���������� 1 �����Ѵ�. ( ���� �����ֱ� )
				
				// -1 �� �Ŀ� ���������� 0�� �Ǹ� ť�� �־��ֱ�
				if(indegree[graph.get(a).get(i)] == 0)
					queue.add(graph.get(a).get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 31 �� ( 2138 ~ 2209)*/
		
		Scanner keyboard = new Scanner(System.in);
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		indegree = new int[vertex+1];
		result = new int[vertex];
		
		// �ʱ�ȭ
		for(int i=1;i<=vertex;i++) {
			indegree[i] = 0;
		}
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			graph.get(a).add(b);	// a�� ����Ű�� ���� b
			
			indegree[b]++; // ����Ŵ ���ϴ� ���� �������� 1 ���� ( �������� : ������ ������ ���� )
		}
		
		topology();
		
		for(int i=0;i<vertex;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
