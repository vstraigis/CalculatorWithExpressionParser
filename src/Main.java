public class Main {
    public static void main(String[] args) {

        String expr = "1 + 2 * ( 3.0 / ( 2 + 7 ) - 4 ) / 5.0 + 10";

        ExpressionParser calcApp = new ExpressionParser(expr);
        System.out.println(calcApp.calculate());
      
    }
}
