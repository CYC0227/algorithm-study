import java.util.*;
public class _3_grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] name = new String[N];
		int[] grade = new int[N];
		
		
		for(int i=0; i<N; i++) {
			name[i] = sc.next();
			grade[i] = sc.nextInt();
		}
		
		for (int i =0; i <N ; i++ ){  
			for (int j = i+1; j <N ; j++ ){
				if (grade[j] > grade[i]){
					int temp = grade[i];
					grade[i] = grade[j];
					grade[j] = temp;

					String str = name[i];
					name[i] = name[j];
					name[j] = str;

				}
			}
		}

		for (int i=0; i<N ; i++){
			System.out.println(name[i]+ " " + grade[i] + " ");
		}

	
	}

}

/*
import java.util.*;

class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // ���� ������ '������ ���� ����'
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N�� �Է¹ޱ�
        int n = sc.nextInt();

        // N���� �л� ������ �Է¹޾� ����Ʈ�� ����
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
 */