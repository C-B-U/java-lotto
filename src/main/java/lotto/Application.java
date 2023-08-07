package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSystem lottoSystem = new LottoSystem(new LottoCustomer(), new LottoMarket());
            lottoSystem.play();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
