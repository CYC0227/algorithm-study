// chapter 10 그래프 이론 - 팀  결성 ( 서로소 집합 자료구조 이용 )

import java.util.*;

public class ch10_3_team {
	public static int n;
	public static int m;
	public static int[] team;
	
	public static int find(int x) {
		if(team[x] != x)
			team[x] = find(team[x]);
		
		return x;
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b)
			team[b] = a;
		else
			team[a] = b;
		
	}
	public static void main(String[] args) {
		/* 실습 시간 : 9 분 ( 1909 ~ 1918 ) */
		
		Scanner keyboard = new Scanner(System.in);
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		team = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			team[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			int check = keyboard.nextInt();
			
			if(check == 0) {
				union(keyboard.nextInt(),keyboard.nextInt());
			}
			else {
				if(find(keyboard.nextInt()) == find(keyboard.nextInt()))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		

	}

}
