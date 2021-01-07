import java.util.Scanner;

public class Main {

        public static int result = 0;
            static Request req = null;

                public static void main(String[] args) {
                try {

                    Scanner sc = new Scanner(System.in); // example 4 * 2
                    System.out.println("Enter data in following form:number operation number ");

                    String input = sc.nextLine();
                    String[] splitted = input.split(" ");
                    String operation = splitted[1];

                    int first = Integer.parseInt(splitted[0]);
                    int second = Integer.parseInt(splitted[2]);

                    req = new Request(first, second, operation);

                    Chain chainAdd = new Add();
                    Chain chainSub = new Subtract();
                    Chain chainMul = new Multiply();
                    Chain chainDiv = new Divide();

                    chainAdd.setNextChain(chainAdd);
                    chainAdd.setNextChain(chainSub);
                    chainSub.setNextChain(chainMul);
                    chainMul.setNextChain(chainDiv);
                    chainAdd.calculate(req);
                    System.out.println(result);

                //exceptions
                } catch (NumberFormatException e) {
                    System.err.println(
                            "Please enter date in format specified above");
                } catch (ArrayIndexOutOfBoundsException e2) {
                    System.err.println(
                            "Out of Bounds");
                } catch (NullPointerException e3) {
                    System.err.println(
                            "NullPointerException " + req.getOperation());
                }
         }
}
