
import java.util.*;

/*
    걸린시간: 22분 57초
    문제점: 충분히 고민 안하고 compareTo 무작정 1번조건부터 쓰다가 갈아엎음, Stirng compareTo 이해도 부족
 */

class Student implements Comparable<Student>{
    private String name;
    private int korean;
    private int english;
    private int math;
    Student(String name, int k, int e, int m){
        this.name = name;
        this. korean = k;
        this.english = e;
        this. math = m;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Student o) {
        if(this.korean == o.korean && this.english == o.english && this.math == o.math){
            return  this.name.compareTo(o.name);
        }else if(this.korean == o.korean && this.english == o.english){
            if(this.math > o.math)
                return -1;
            else
                return 1;
        }else if(this.korean == o.korean){
            if(this.english < o.english)
                return -1;
            else
                return 1;
        }else{
            if(this.korean > o.korean)
                return -1;
            else
                return 1;
        }
    }
}
public class Main {

    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        List<Student> list = new LinkedList<>();

        for(int i = 0; i < N; i++){
            String[] str = sc.nextLine().split(" ");
        //sc.next();
            list.add(new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
        }

        Collections.sort(list);

        for (Student s: list
             ) {
            System.out.println(s.getName());
        }
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}