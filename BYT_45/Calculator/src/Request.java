public class Request {
    private final int number1;
    private final int number2;
    private final String operation;

    public Request(int number1, int number2, String operation) {
        super();
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }
    public String getOperation() {
        return operation;
    }
    public int getNumber1() {
        return number1;
    }
    public int getNumber2() {
        return number2;
    }
}
