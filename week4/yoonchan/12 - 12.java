import java.util.*;

/*
    걸린시간: 1시간 36분
    문제점: ㅆㅂ
 */


class Solution {
    public static int[][] cur;

    public boolean isbuildAble(int y,int x){
        if(!(y - 1 == -1 || ( y - 1 >= 0 && cur[y - 1][x] == 0) || ( cur[y][x - 1] == 1 || cur[y][x + 1] ==1 )) ){
            return false;
        }
        else if(!((cur[y][x - 1] == 0 || cur[y][x + 1] == 0) || (cur[y][x - 1] == 1 && cur[y][x + 1] == 1))){
            return false;
        }
        else return true;
    }

    public void build(int x, int y, int a, int b, int[][] answer, int n) {


        for(int i = 0; i < n; i++){
            Arrays.fill(cur[i],3);
        }


        if (b == 1) {
            if (a == 0) {
                cur[y][x] = 0;
                cur[y + 1][x] = 0;
                if(!(y - 1 == -1 || ( y - 1 >= 0 && cur[y - 1][x] == 0) || ( cur[y][x - 1] == 1 || cur[y][x + 1] ==1 )) ){
                    cur[y][x] = 3;
                    cur[y + 1][x] = 3;
                }
            } else if (a == 1) {
                cur[y][x] = 1;
                cur[y][x + 1] = 1;
                if(!((cur[y][x - 1] == 0 || cur[y][x + 1] == 0) || (cur[y][x - 1] == 1 && cur[y][x + 1] == 1))){
                    cur[y][x] = 3;
                    cur[y][x + 1] = 3;
                }
            }
        }else if(b == 0){
            if (a == 0) {
                cur[y][x] = 3;
                cur[y + 1][x] = 3;
                if(!(isbuildAble(y,x - 1) && isbuildAble(y,x+1) &&isbuildAble(y+1,x-1)&& isbuildAble(y + 1, x + 1))){
                    cur[y][x] = 0;
                    cur[y + 1][x] = 0;
                }
            } else if (a == 1) {
                cur[y][x] = 3;
                cur[y][x + 1] = 3;
                if(!(isbuildAble(y,x - 1) && isbuildAble(y,x+1) &&isbuildAble(y+1,x-1)&& isbuildAble(y + 1, x + 1))){
                    cur[y][x] = 1;
                    cur[y + 1][x] = 1;
                }
            }
        }


    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        cur = new int[n+2][n+2];
        List<Node> lst = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            build(build_frame[i][0], build_frame[i][1], build_frame[i][2], build_frame[i][3], answer, n);
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cur[i - 1][j] == 0 && cur[i][j] ==0)
                    lst.add(new Node(j,i - 1,0));
                else if(cur[i][j] == 1 && cur[i][j + 1] == 1)
                    lst.add(new Node( j,i - 1 ,1));
            }
        }
        Collections.sort(lst);

        answer = new int[lst.size()][3];
        for(int i = 0; i < lst.size(); i++){
            answer[i][0] = lst.get(i).getX();
            answer[i][1] = lst.get(i).getY();
            answer[i][2] = lst.get(i).getA();
        }

        return answer;
    }
}
class Node implements Comparable<Node>{
    private int x,y,a;
    Node(int x, int y,int a){
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getA(){
        return this.a;
    }

    @Override
    public int compareTo(Node o) {
        if(this.x < o.x)
            return -1;
        else if(this.x == o.x){
            if(this.y < o.y)
                return -1;
            else if(this.y == o.y)
                if(this.a < o.a){
                    return -1;
                }
        }

        return 1;

    }
}
public class Main {

    public static void main(String[] args) {

        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        Solution s = new Solution();

        s.solution(5 , build_frame);
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}