/*
* union-find�� Ǯ ������ ���ؼ� ��� ��̴� ����
* �� ���μ� ���� �˰��� ������ ������ ������ ��.��
* 
* ó������ �� ������ 1�� �̻��� ������ �־ ArrayList�ȿ� ArrayList�� ������� �׷����� ������� ��
* �̰����� Ǯ �� ���� �� ������ �Ƿ¹������� ����
* ex) 2->3 : 3�� ���� ������ �׷����� ��� ���� ������, NO
* 			  �ٵ� �̶� �׷����� ���(ã�� ������ ������         ) ���� �ڵ��� ¥�� ����
*/


//union-find�� Ǯ���� �� �ڵ�
/*
import java.util.*;

public class Q41 {
	
	public static int n,m;
	public static int[][] arr; //���� ���� ���
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
		
		//�׷��� �ʱ�ȭ
		//for(int i=0; i<n; i++) {
		//	graph.add(new ArrayList<Integer>());
		//}
		
		//�׷��� ����
		//for(int i=1; i<=n; i++) {
		//	for(int j=1; j<=n; j++) {
		//		arr[i][j] = sc.nextInt();
		//		if(arr[i][j] == 1) {
		//			graph.get(i).add(j);//i������ j������ �̵� ����
		//		}
		//	}
		//}
		
		
		//���� ���� �Է� �ޱ�
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//���� ��ȹ�� ���� ������ �� �Է� �ޱ�
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		//union ����
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

//�׷����� Ǯ���� �� �ڵ�
/*
import java.util.*;

public class Q41 {
	
	public static int n,m;
	public static int[][] arr; //���� ���� ���
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[]  arr2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][n];
		arr2 = new int[m];
		//�׷��� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//�׷��� ����
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					graph.get(i).add(j);//i������ j������ �̵� ����
				}
			}
		}
		
		//���� ��ȹ�� ���� ������ �� �Է� �ޱ�
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		//�������� ��� ����Ǿ� �ִ����� Ȯ��x
		//������ ������ ����� ������ ���� ���ϴ� ���� �ִ��� Ȯ��
		
		for(int i=0; i<m; i++) {
			int now = arr2[i];
			//���� ���� ã�� ������
			while(true) {
				//arr[i+1]==graph.get(now).get(i)
				for(int j=0;)
			}
		}
		
	}

}
*/