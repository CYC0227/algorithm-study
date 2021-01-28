import java.util.*;

/*
    걸린시간: 
    문제점: 
 */




public class Main {

    public static int[] arr;
    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];

        for(int i=  0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int num = arr[N - 1];
        int compare = 0;
        int result = -1;

        while(true){
            for(int i = N - 1; i >= 0; i --){
                if(i == 0)
                    result = num;

                if(arr[i] > num){
                    continue;
                }
                compare += arr[i];
                if(compare == num){
                    break;
                }

            }
            if(num == 1)
                break;
            num--;
        }
        System.out.println(result);
