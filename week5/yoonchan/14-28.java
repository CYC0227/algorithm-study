
import java.util.*;

/*
    걸린시간: 19분 47초
    문제점:  아 이건 아닌데 싶은 방법은 빠르게 버리고 다른걸로 시도하기(뻘짓 금지)
 */


public class Main {

    public static int bSearch(int[] arr, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == mid){
                return mid;
            }
            else if(arr[mid] < mid){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int [] arr = new int[N];


        for(int i = 0; i< N; i++){
            int a = sc.nextInt();
            arr[i] = a;// how to get fast?
        }

        int res = bSearch(arr, 0, N - 1);


        System.out.println(res);

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}