package lotto;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        final LottoController lottoController = componentFactory.lottoController();
        lottoController.startLotto();
    }
}
