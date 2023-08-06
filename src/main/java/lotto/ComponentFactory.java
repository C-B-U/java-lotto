package lotto;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private LottoService lottoService() {
        return new LottoService();
    }
}
