package lotto;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return new LottoRepository();
    }
}
