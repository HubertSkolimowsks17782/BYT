import org.jetbrains.annotations.NotNull;

public class Divide implements Chain {
    private Chain nextInChain = null;


    public void setNextChain(Chain nextChain) {
        nextInChain = nextChain;
    }

    public void calculate(@NotNull Request request) {
        if (request.getOperation().equals("/")) {
            Main.result = request.getNumber1() / request.getNumber2();

        } else {
            nextInChain.calculate(request);
        }
    }
}
