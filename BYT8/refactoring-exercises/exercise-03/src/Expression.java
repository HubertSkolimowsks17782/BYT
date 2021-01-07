import java.util.HashMap;
import java.util.Map;

public class Expression {

	private final char op;
	//private char op; made final

	private Expression left;
	private Expression right;
	private int constant;


	//map made final,created Map instead of switch,created interface for using maps in Expression
	private final Map<Character, IOperation> map;
	{
		map = new HashMap<>();
		map.put('c', () -> constant);
		map.put('+', () -> left.evaluate() + right.evaluate());
		map.put('-', () -> left.evaluate() - right.evaluate());
		map.put('/', () -> left.evaluate() / right.evaluate());
		map.put('*', () -> left.evaluate() * right.evaluate());
	}

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
	public int evaluate() {
		return map.get(op).calculate();
	}

	/*public int evaluate() {
		return switch (op) {
			case 'c' -> constant;
			case '+' -> left.evaluate() + right.evaluate();
			case '-' -> left.evaluate() - right.evaluate();
			case '*' -> left.evaluate() * right.evaluate();
			case '/' -> left.evaluate() / right.evaluate();
			default -> throw new IllegalStateException();
		};*/
}

