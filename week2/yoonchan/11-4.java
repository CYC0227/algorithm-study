import java.util.Scanner;

/*
    걸린시간: 19.14
    문제점: for 문 안에서 num 초기화할때 버벅거림, 쓸데없이 어렵게 풂(나중에는 답지랑 같은 방법 생각났지만 그냥...)
 */

public class Main {

    public static void main(String[] args) {

        String [] arr;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        arr = sc.nextLine().split("");


        for(int i = 0 ; i< arr.length - 1; i = i +1){
            int num1 = Integer.valueOf(arr[i]);
            int num2 = Integer.valueOf(arr[i + 1]) ;

            if(num1 == 1 || num1 == 0 || num2 == 1 || num2 ==0) {
                result = num1 + num2;
                arr[i + 1] = String.valueOf(result);
            }
            else {
                result = num1 * num2;
                arr[i + 1] = String.valueOf(result);
            }
        }

        System.out.println(result);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}