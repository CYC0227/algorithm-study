// chapter 6 정렬 - 성적이 낮은 순서로 학생 출력하기 

import java.util.*;

public class ch6_6 {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		String[][] student = new String[n][n];
		
		// 0번째가 이름, 1번째가 성적
		for(int i=0;i<n;i++) {
			student[i][0] = keyboard.next();
			student[i][1] = keyboard.next();
		}
		
		for(int i=0;i<n;i++) {
			int index = i;
			for(int j=i;j<n;j++) {
				if(Integer.parseInt(student[i][1]) > Integer.parseInt(student[j][1])) {
					index = j;
				}
			}
			
			String temp1 = student[i][0];
			student[i][0] = student[index][0];
			student[index][0] = temp1;
			
			String temp2 = student[i][1];
			student[i][1] = student[index][1];
			student[index][1] = temp2;
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(student[i][0]+" ");
		}
	}

}
