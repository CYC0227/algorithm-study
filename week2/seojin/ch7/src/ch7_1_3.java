import java.util.*;

public class ch7_1_3 {

    // ���� Ž�� �ҽ��ڵ� ����(�ݺ���)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // ã�� ��� �߰��� �ε��� ��ȯ
            if (arr[mid] == target) return mid;
            // �߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
            else if (arr[mid] > target) end = mid - 1;
            // �߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
            else start = mid + 1; 
        }
        return -1;
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