// chapter 10 �׷��� �̷� - Ŀ��ŧ�� (�������� ���)

import java.util.*;

public class ch10_6_curriculum {
	public static int n;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // �׷���
	public static int[] indegree; // ��������
	public static int[] result; // ť�� ���� ��� ������� ����
	public static int[] time; // �� ���� �����ϴµ� �ɸ��� �ð�
	
	public static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			int take = time[a]; // �� �����ϴµ� �ɸ��� �ð�
			
			// �� �ð� ��� & ���� ����
			for(int i=0;i<graph.get(a).size();i++) {
				// �ð� ��� - ����� ��忡 ���� ���� ����� �ð� �����ֱ�
				// result[graph.get(a).get(i)] += take; : ���� �� �ڵ�. �̷��� ���� ���� ������ 5�� ���� ���� �� 17�� �ƴ� 7�� �ڲ� ���� �Ф�
				result[graph.get(a).get(i)] = Math.max(result[graph.get(a).get(i)], result[a] + time[graph.get(a).get(i)]);
				
				
				//���� ���� & ���������� 0�̸� ť�� �ֱ�
				indegree[graph.get(a).get(i)]--;
				if(indegree[graph.get(a).get(i)] == 0)
					queue.add(graph.get(a).get(i));
			}			
		}
		
	}
	public static void main(String[] args) {
		/* �ǽ� �ð� : 53�� ( 2210 ~ 2307 )
		 * ���� : �ϴ� �������� ȭ��ǥ ������ �ʹ��ʹ� �򰥸�. & �������� 5�� 3�� ���� �ϴµ�, 3�� 1�� �����ؼ� �� ���ԵǴ� �ð��� �ݿ��ϴ°� �ʹ��ʹ� �������
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		indegree = new int[n+1];
		result = new int[n+1];
		time = new int[n+1];
		
		// �ʱ�ȭ
		for(int i=1;i<=n;i++) {
			indegree[i] = 0;
			time[i] = 0;
		}
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		keyboard.nextLine();
		
		// ���� �ð��� �������� �Է¹ޱ� -> �̰� �ʹ��ʹ� �򰥷���. ����� indegree�� �������Ѿ��ϳ�..
		for(int i=1;i<=n;i++) {
			
			String[] str = keyboard.nextLine().split(" ");
			
			time[i] = Integer.parseInt(str[0]); // ù ��°�� �ð�
			
			if(Integer.parseInt(str[1]) == -1)
				continue;
			
			for(int j=1;j<str.length-1;j++) {
				graph.get(Integer.parseInt(str[j])).add(i); 
				indegree[i]++;
			}			
		}

		/* indegree �°� ���� Ȯ��
		 * for(int i=1;i<=n;i++) {
			System.out.print(indegree[i]+" ");
		} System.out.println();
		*/
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=n;i++) {
			result[i] = time[i]; // result�� time �������ֱ�
		}
		
		topology();
		
		for(int i=1;i<=n;i++) {
			System.out.println(result[i]);
		}
		
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
	}

}
