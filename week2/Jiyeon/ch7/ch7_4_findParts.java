// chapter 7 이진탐색 - 부품 찾기(이진탐색 )

import java.util.*;

public class ch7_4_findParts {
	
	// 재귀적으로 작성
	public static String search(int start, int end, int number, int arr[]) {

		if(start > end) return "no";
		
		int mid = (start + end) / 2;
		
		if(number == arr[mid])
			return "yes";
		else if(number < arr[mid])
			return search(start,mid-1,number,arr);
		else
			return search(mid+1,end,number,arr);
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 26분 
		 * 어려운 점 : 이진탐색을 재귀적으로 구현하는 것과 반복문으로 구현하는 것이 헷갈림.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] store = new int[n];
		for(int i=0;i<n;i++) {
			store[i] = keyboard.nextInt();
		}

		int m = keyboard.nextInt();
		int[] customer = new int[m];
		for(int i=0;i<m;i++) {
			customer[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		
		// 상점에 있는 부품 번호 오름차순으로 정렬
		Arrays.sort(store);
		
		// 손님이 요청한 부품 있는지 확인 & 출력
		for(int i=0;i<m;i++) {
			System.out.print(search(0,n-1,customer[i],store)+" ");
		}
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
	}

	
	/* 답지 - 반복문으로 구현
	
public class Main {

    // 이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1; 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
    */
}
