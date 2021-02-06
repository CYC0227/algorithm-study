// part 3 - chapter 14 ���� : 23�� ) ������
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
			return Integer.compare(other.math, this.math);	// ��������
		
		if(this.kor == other.kor)
			return Integer.compare(this.eng, other.eng); // ��������

		
		return Integer.compare(other.kor, this.kor);	// ��������
	}
}

public class q23_korEngMat {
	
	public static int n; // �����̳� ���� �л� ��
	public static ArrayList<Student> stu = new ArrayList<>();
	
	public static void main(String[] args) {
		/* ����ð� : 13 �� ( 0959 ~ 1012 ) 
		 * compareTo�� �� integer ���ϴ� �� ���� �������
		 * ���������� ��������/������������ ������ �򰥸�
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			String name = keyboard.next();
			int kor = keyboard.nextInt();
			int eng = keyboard.nextInt();
			int math = keyboard.nextInt();
			
			stu.add(new Student(name,kor,eng,math)); // stu arraylist�� 'student' ������ ���� �л����� �ϳ��� �߰��ϱ�
		}
		
		Collections.sort(stu);
		
		for(int i=0;i<n;i++) {
			System.out.println(stu.get(i).getName());
		}

	}

}
