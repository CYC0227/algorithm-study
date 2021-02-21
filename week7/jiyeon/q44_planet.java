// chapter 18 �׷��� �̷� ����
package graph;

import java.util.*;

class Planet implements Comparable<Planet>{
	
	private int a,b,value;
	
	public Planet(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}
	
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Planet o) {
		if(this.value < o.value)
			return -1;
		return 1;
	}
	
}

public class q44_planet {
	public static int n; // �༺ ����
	public static int[] parent; // �θ� ���
	public static String[] info; // �༺ ��ġ (������ ��)�� string �� �ٷ� �ޱ�
	public static ArrayList<Planet> planet = new ArrayList<>();
	
	public static int find(int x) {
		if(x != parent[x]) 
			return find(parent[x]);
			
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
		/* �ǽ� �ð� : 54�� ( 0953 ~ 1047)
		 * ��ǥ �� ������ �޴� �Ͱ�, ���� ���� �߿��� n-1���� ���ؾ��Ѵٴ� �� ��� ����ϰ� �򰥸��°� ¯ ����
		 * ���� ���ϱ� arraylist�� ���Ƽ� ��¦ �� �򰥸��� �� ���� ����
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		parent = new int[n+1];
		info = new String[n];
		keyboard.nextLine();
		
		// �༺ ��ġ���� �ޱ� + �θ��� �ڽ����� �ʱ�ȭ�ϱ�
		for(int i=0;i<n;i++) {
			info[i] = keyboard.nextLine();
			parent[i+1] = i+1;
		}
		
		// ù ��° �༺���� ������ �༺���� ��� ¦�� �̷Ｍ ����� ���Ѵ�.
		for(int i=0;i<n-1;i++) {
			// a �� ���ϱ� ( x��ǥ, y��ǥ, z��ǥ )
			int a[] = new int[3];
			for(int l=0;l<3;l++) {
				String[] temp = info[i].split(" ");
				a[l] = Integer.parseInt(temp[l]);
			}
			
			// b �� ���ϱ� ( x��ǥ, y��ǥ, z��ǥ )
			for(int j=i+1;j<n;j++) {
				int b[] = new int[3];
				for(int s=0;s<3;s++) {
					String[] temp = info[j].split(" ");
					b[s] = Integer.parseInt(temp[s]);
				}
				
				int dis = Math.min(Math.abs(a[0]-b[0]), Math.min(Math.abs(a[1]-b[1]), Math.abs(a[2]-b[2])));
				planet.add(new Planet(i+1,j+1,dis)); // min���� �־��ش�.
			}			
		}
		// �ּҺ�� ���ؾ� �ϴϱ� value�������� ���� ����
		Collections.sort(planet);
		
		int result = 0;
		int time = 0;
		int i = 0;
		
		// n-1��ŭ ������ ���� ���� while��
		while(time < n-1) {
			int a = planet.get(i).getA();
			int b = planet.get(i).getB();
			int val = planet.get(i).getValue();
			
			// cycle�� �Ȼ��� ��츸 �� ��
			if(find(a) != find(b)) {
				result += val;
				union(a,b);
				time++;
			}
			i++;
		}
		
		System.out.println(result);
	}

}
