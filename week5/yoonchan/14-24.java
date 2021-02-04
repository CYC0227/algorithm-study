
import java.util.*;

/*
    걸린시간: 36분
    문제점: 틀림 - 시간초과 걸림... 내가 푼 답으로는 이중 반복문에서 20만 곱하기 20만 = 엄청큼 이여서 일케 하면 안됨.
 */

class Node implements Comparable<Node>{
    private int diff;
    private int dest;

    Node(int dest){
        this.dest = dest;
    }

    public void setDiff(int i){
        this.diff = i;
    }
    public int getDest(){
        return dest;
    }
    @Override
    public int compareTo(Node o) {
        if (this.diff == o.diff){
            return Integer.compare(this.dest, o.dest);
        }
        else
             return Integer.compare(this.diff, o.diff);
    }
}
public class Main {

    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int [] arr = new int[N];

        List<Node> list = new LinkedList<>();

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            list.add(new Node(arr[i]));
        }

        for(int i = 0; i < N; i++){
            int diff = 0;
            Node n = list.get(i);
            int des = n.getDest();

            for(int j = 0; j < N; j++){
                int num = Math.abs(arr[j] - des);
                diff += num;
            }
            list.get(i).setDiff(diff);
        }

        Collections.sort(list);

        System.out.println(list.get(0).getDest());


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}