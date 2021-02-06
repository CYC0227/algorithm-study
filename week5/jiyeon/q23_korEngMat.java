// part 3 - chapter 14 정렬 : 23번 ) 국영수
package sort;

import java.util.*;

class Student implements Comparable<Student>{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Student other) {
		if(this.kor == other.kor && this.eng == other.eng && this.math == other.math)
			return this.name.compareTo(other.name);
		
		if(this.kor == other.kor && this.eng == other.eng)
			return Integer.compare(other.math, this.math);	// 내림차순
		
		if(this.kor == other.kor)
			return Integer.compare(this.eng, other.eng); // 오름차순

		
		return Integer.compare(other.kor, this.kor);	// 내림차순
	}
}

public class q23_korEngMat {
	
	public static int n; // 도현이네 반의 학생 수
	public static ArrayList<Student> stu = new ArrayList<>();
	
	public static void main(String[] args) {
		/* 실행시간 : 13 분 ( 0959 ~ 1012 ) 
		 * compareTo할 때 integer 비교하는 것 조금 어려웠음
		 * 마찬가지로 오름차순/내림차순에서 순서가 헷갈림
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			String name = keyboard.next();
			int kor = keyboard.nextInt();
			int eng = keyboard.nextInt();
			int math = keyboard.nextInt();
			
			stu.add(new Student(name,kor,eng,math)); // stu arraylist에 'student' 형식을 가진 학생들을 하나씩 추가하기
		}
		
		Collections.sort(stu);
		
		for(int i=0;i<n;i++) {
			System.out.println(stu.get(i).getName());
		}

	}

}
