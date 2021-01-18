import java.util.*;

public class ch7_1_2 {

    // ���� Ž�� �ҽ��ڵ� ����(��� �Լ�)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // ã�� ��� �߰��� �ε��� ��ȯ
        if (arr[mid] == target) return mid;
        // �߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // �߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
        else return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // ������ ����(n)�� ã���� �ϴ� ��(target)�� �Է¹ޱ� 
        int n = sc.nextInt();
        int target = sc.nextInt();

        // ��ü ���� �Է¹ޱ� 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ���� Ž�� ���� ��� ��� 
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("���Ұ� �������� �ʽ��ϴ�.");
        }
        else {
            System.out.println(result + 1);
        }
    }

}