public class Main {

    public static void main(String[] args) {
        int money = 1260;
        int [] coin_Types = {500,100,50,10};
        int coin_cnt = 0;

        for (int i :
                coin_Types) {
            coin_cnt += money / i;
            money = money % i;
        }

        System.out.println(coin_cnt);
    }
}