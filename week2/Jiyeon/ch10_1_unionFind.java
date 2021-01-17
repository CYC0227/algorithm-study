// chapter 10 �׷��� �̷� - ������ ���μ� ���� �˰���
import java.util.*;

public class ch10_1_unionFind {
	public static int vertex;
	public static int edge;
	public static int[] parent;
	
	// �� ��尡 ���ϴ� �θ� node ã��
	public static int find(int node) {
		if(parent[node] != node)
			return find(parent[node]);
		
		return node;
		
	}
	
	// ��� ��ġ��
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
		
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 22 �� ( 1049 ~ 1111)*/
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		parent = new int[vertex+1];
		
		for(int i=1;i<=vertex;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			union(a,b);
		}
		
		System.out.print("�� ���Ұ� ���� ����: ");
		for(int i=1;i<=vertex;i++) {
			System.out.print(find(i)+" ");
		}System.out.println();
		
		System.out.print("�θ� ���̺�: ");
		for(int i=1;i<=vertex;i++) {
			System.out.print(parent[i]+" ");
		}

	}

}
