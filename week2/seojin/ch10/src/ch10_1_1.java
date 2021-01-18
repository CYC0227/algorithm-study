import java.util.*;

public class ch10_1_1 {

    // ����� ����(V)�� ����(Union ����)�� ����(E)
    // ����� ������ �ִ� 100,000����� ����
    public static int v, e;
    public static int[] parent = new int[100001]; // �θ� ���̺� �ʱ�ȭ�ϱ�

    // Ư�� ���Ұ� ���� ������ ã��
    public static int findParent(int x) {
        // ��Ʈ ��尡 �ƴ϶��, ��Ʈ ��带 ã�� ������ ��������� ȣ��
        if (x == parent[x]) return x;
        return findParent(parent[x]);
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

        v = sc.nextInt();
        e = sc.nextInt();

        // �θ� ���̺�󿡼�, �θ� �ڱ� �ڽ����� �ʱ�ȭ
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union ������ ���� ����
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // �� ���Ұ� ���� ���� ����ϱ�
        System.out.print("�� ���Ұ� ���� ����: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // �θ� ���̺� ���� ����ϱ�
        System.out.print("�θ� ���̺�: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}