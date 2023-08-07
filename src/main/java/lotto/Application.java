package lotto;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        final FrontController frontController = componentFactory.frontController();
        try{
            frontController.playLotto();
        } catch(final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
