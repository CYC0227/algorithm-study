// chapter 10 �׷��� �̷� - ���� ���� ��ȹ

import java.util.*;

class City implements Comparable<City> {
	private int a;
	private int b;
	private int value;
	
	public City(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getValue() {
		return value;
	}
	
	// ���� : cost ������ ����
	@Override
	public int compareTo(City arg0) {
		return getValue() - arg0.getValue();
	}
	
}
public class ch10_4_city {
	public static int n;
	public static int m;
	public static int[] parent;
	public static ArrayList<City> city = new ArrayList<>();
	
	public static int find(int x) {
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void main(String[] args) {
		/* �ǽ� �ð� : 31 �� ( 1926 ~ 1957 )
		 * ũ�罺Į �˰����̶� �Ȱ���
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		parent = new int[n+1];
		
		int result = 0;
		
		for(int i=0;i<m;i++) {
			city.add(new City(keyboard.nextInt(),keyboard.nextInt(),keyboard.nextInt()));
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		Collections.sort(city);
		
		int max = 0;
		for(int i=0;i<m;i++) {
			int a = city.get(i).getA();
			int b = city.get(i).getB();
			int value = city.get(i).getValue();
			
			if(find(a) != find(b)) {
				union(a,b);
				if(value>max)
					max = value;
				result += value;
			}
		}
		
		// ����� edge �߿��� ���� ū ���� ���� ���ø� �����ϱ�
		result -= max;
		
		System.out.println(result);
		
		   /* �ڵ� ����ð� ��� */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
