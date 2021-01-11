// chapter 7 이진탐색 - 재귀적으로 구현한 이진탐색

import java.util.*;

public class ch7_2_binary {
	
	public static int index = -1;
	public static int size;
	public static int search;
	
	/* 재귀적으로 구현*/
	public static void binary(int start, int end, int number,int[] arr) {
		// 정렬되어있는 함수이기 때문에, 시작점이 끝점보다 뒤에 가있으면 search 종료
		if(start>end)
			return;
		
		int mid = (start+end)/2; // (start+end / 2) = 중간점
		
		// 중간값과 같은 경우 search 성공
		if(number == arr[mid]) {
			index = mid;
			return;
		}
		// 중간값보다 작은 경우 -> 왼쪽 탐색
		else if(number < arr[mid]) {
			binary(start,mid-1,number,arr);
			return;
		}
		// 중간값보다 큰 경우 -> 오른쪽 탐색
		else {
			binary(mid+1,end,number,arr);
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		size = keyboard.nextInt();
		search = keyboard.nextInt();

		int arr[] = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		binary(0,size-1,search,arr);
		
		if(index>=0) 
			System.out.println(index+1);
		else
			System.out.println("원소가 존재하지 않습니다.");
		
		
		/* 코드 실행시간 계산 */
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
        System.out.println("실행시간(second) : " + secDiffTime);
	}
	
	/* 
	 답지
	 
	 import java.util.*;

public class Main {

    // 이진 탐색 소스코드 구현(재귀 함수)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target) return mid;
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기 
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력 
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }

}
	  */

}
