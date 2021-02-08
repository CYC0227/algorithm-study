
import java.util.*;

/*
    걸린시간: 1시간 35분
    문제점:    중간에 멘붕와서 다른방법 안찾고 똑같은 방법으로 계속 다시 고쳐볼 생각만 함. 시간 훠얼씬 아낄수있었는데...
                -애초에 생각을 좀 대충하고 들어간것 같기도..
                main에서 offer 하는 부분에서 배열 아닌 리스트로 바꿔야 통과함. 배열로 하면 예제는 맞는데 다른 예외가 있음...
                - 틀렸다고 하면 맞았는데 왜 틀렸대? 하지 말고 코드 처음부터 쭉 읽기...
                

 */

class Node {
    private int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int N, K;
    public static int S, X, Y;
    public static int[][] graph;
    public static int[] dx = {-1, 1, 0, 0};//상하좌우.
    public static int[] dy = {0, 0, -1, 1};


    public static Queue<Node> q = new LinkedList<>();

    public static void bfs(int now) {


        while (!q.isEmpty()) {
            Node nd = q.peek();
            int aa = nd.getX();
            int bb = nd.getY();

            if(graph[aa][bb] != now)
                break;

            Node n = q.poll();
            int a = n.getX();
            int b = n.getY();



            for (int j = 0; j < 4; j++) {
                int nx = a + dx[j];
                int ny = b + dy[j];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N)
                    continue;

                if (graph[nx][ny] != 0)
                    continue;



                graph[nx][ny] = graph[a][b];
/*
                for (int i = 1; i <= N; i++) {
                    for (int k = 1; k <= N; k++) {
                        System.out.print(graph[i][j] + " ");
                    }
                    System.out.println();

                }
                System.out.println();

*/

                q.offer(new Node(nx, ny));
            }

        }


    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        S = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();




        List<Integer> list_x = new ArrayList<>();
        List<Integer> list_y = new ArrayList<>();

        for (int m = 1; m <= K; m++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] == m) {
                        list_x.add(i);
                        list_y.add(j);
                    }
                }
            }
        }


        for (int i = 0; i < list_x.size(); i++) {
            q.offer(new Node(list_x.get(i), list_y.get(i)));
        }


        for (int j = 0; j < S; j++) {
            for (int i = 1; i <= K; i++) {
                bfs(i);

            }

        }

        /*
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();



        */
        System.out.println(graph[X][Y]);


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}