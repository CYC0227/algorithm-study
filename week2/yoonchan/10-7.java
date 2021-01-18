import java.util.*;

/*
    걸린시간: 20.20
    문제점: 문제 푸는거는 빨랐는데 리스트에 입력받고 출력하는 과정에서 숙련도 부족 - 공부필요
 */

public class Main {

    public static int findParent(int x){
        if(x == parent[x])
            return x;
        else
            return parent[x] = findParent(parent[x]);
    }
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }


    public static int[] parent = new int[100001];

    public static void main(String[] args) {

        int N,M;
        int cnt = 0;
        List<String> lst = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i < N + 1; i ++){
            parent[i] = i;
        }

        for(int i = 0 ; i < M; i++){
            int op = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(op == 0)
                unionParent(a,b);
            else{

                if(findParent(a) == findParent(b))
                    lst.add("YES"); //System.out.println("YES");
                else
                    lst.add("NO");

            }
        }

       for(int i = 0; i< lst.size(); i++){
           System.out.println(lst.get(i));
       }
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}