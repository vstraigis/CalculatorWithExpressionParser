public class ExpressionParser {

    private String[] tokens;
    private int pos;

    public ExpressionParser(String expr) {
        this.tokens = expr.split(" ");
        this.pos = 0;
    }

    double calculate() {
    double first = multiply();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multiply() {
        double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    public double factor() {
        String next = tokens[pos];
        double result;
        if (next.equals("(")) {
            pos++;
            result = calculate();
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalArgumentException("Unexpected end of expression");
            }
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalArgumentException("')' expected but " + closingBracket + " found");
        }
        pos++;
        return Double.parseDouble(next);
    }
}