package lotto;

public class ComponentFactory {

    public FrontController frontController() {
        return new FrontController(lottoController(), outputManager());
    }

    private LottoController lottoController() {
        return new LottoController(lottoService(), outputManager(), inputManager());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return new LottoRepository();
    }

    private OutputManager outputManager() {
        return new OutputManager(outputFormatter());
    }

    private OutputFormatter outputFormatter() {
        return new OutputFormatter();
    }

    private InputManager inputManager() {
        return new InputManager(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}
