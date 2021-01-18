//��ġ�� ���� -> ���μ� union find
import java.util.*;

public class ch10_2 {

    // ����� ����(N)�� ������ ����(M)
    // ����� ������ �ִ� 100,000����� ����
    public static int n, m;
    public static int[] parent = new int[100001]; // �θ� ���̺� �ʱ�ȭ

    // Ư�� ���Ұ� ���� ������ ã��
    public static int findParent(int x) {
        // ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // �� ���Ұ� ���� ������ ��ġ��
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // �θ� ���̺�󿡼�, �θ� �ڱ� �ڽ����� �ʱ�ȭ
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // �� ������ �ϳ��� Ȯ�� 
        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // ������(Union) ������ ���
            if (oper == 0) {
                unionParent(a, b);
            }
            // ã��(Find) ������ ���
            else if (oper == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
  