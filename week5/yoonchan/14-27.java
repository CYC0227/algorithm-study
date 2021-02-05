
import java.util.*;

/*
    걸린시간: 16분 57초
    문제점: 시간제한 잘 지킬 생각하기
 */


public class Main {

    public static void main(String[] args) {

        int N,x;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        x = sc.nextInt();
        int [] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int target =  Arrays.binarySearch(arr, x);

     //   System.out.println(target);

        if(target < 0){
            System.out.println(-1);
            return;
        }

        int a = target;
        while(true) {
            if(arr[a - 1] == x)
                a++;
            else
                break;
        }

        System.out.println(a - target);


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}


import java.util.*;

class Num implements Comparable<Num>{

    private int n;
    public Num(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public int compareTo(Num o) {
        return Integer.compare(o.n,this.n);
    }
}
public class Main {

    public static void main(String[] args) {

        int N,x;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        x = sc.nextInt();
        int [] arr = new int[N];

        List<Num> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
            arr[i] = a;
            list.add(new Num(a));
        }

        Collections.sort(list);

        int target1 =  Arrays.binarySearch(arr, x);

        if(target1 < 0){
            System.out.println(-1);
            return;
        }

        int target2 = N - Collections.binarySearch(list, new Num(x));

        int res = target2 - target1 + 2;

        System.out.println(res);



        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}