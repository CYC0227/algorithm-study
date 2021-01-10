import java.util.*;

public class _2_upDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//내림차순 정렬
		Arrays.sort(arr, Collections.reverseOrder());
	
		//출력
		for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }
	}

}
