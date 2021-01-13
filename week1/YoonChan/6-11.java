/*
    걸린시간: 13.22
    이유:
 */


import java.util.*;

class Student implements Comparable<Student>{

    private String name;
    private int score;

    Student(String name, int score){
        this.name=  name;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }

    @Override
    public int compareTo(Student s) {
        if(this.score < s.score)
            return - 1;
        else
            return 1;
    }
}

public class Main {


    public static void main(String[] args) {

        int N;
        Student[] students;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        sc.nextLine();
        students = new Student[N];

        for(int i = 0 ; i < N; i++){
            String[] str= sc.nextLine().split(" ");
            String name = str[0];
            int score = Integer.parseInt(str[1]);

            students[i] = new Student(name,score );
        }

        Arrays.sort(students);

        for(int i = 0 ; i < N; i ++){
            System.out.print(students[i].getName() + " ");
        }

        //     long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        //  long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //   System.out.println("시간차이(second) : " + secDiffTime);
    }
}