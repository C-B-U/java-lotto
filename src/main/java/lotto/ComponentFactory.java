package lotto;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputManager());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return new LottoRepository();
    }

    private InputManager inputManager() {
        return new InputManager();
    }
}
