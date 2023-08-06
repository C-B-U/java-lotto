package lotto;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(lottoService(), outputManager(), inputManager());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return new LottoRepository();
    }

    private OutputManager outputManager() {
        return new OutputManager();
    }

    private InputManager inputManager() {
        return new InputManager(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}
