public class Parsing {
	
	private String expression;
	private int index;
	private int length;
	private char currentChar;
	private double result;
	
	public Parsing(String expression) {
		this.expression = expression;
		this.index = 0;
		this.length = expression.length();
		this.currentChar = expression.charAt(index);
	}
	
	public double parse() {
		result = parseExpression();
		return result;
	}
	
	private double parseExpression() {
		double result = parseTerm();
		while (currentChar == '+' || currentChar == '-') {
			if (currentChar == '+') {
				nextChar();
				result += parseTerm();
			} else if (currentChar == '-') {
				nextChar();
				result -= parseTerm();
			}
		}
		return result;
	}
	
	private double parseTerm() {
		double result = parseFactor();
		while (currentChar == '*' || currentChar == '/' || currentChar == '%') {
			if (currentChar == '*') {
				nextChar();
				result *= parseFactor();
			} else if (currentChar == '/') {
				nextChar();
				result /= parseFactor();
			} else if (currentChar == '%') {
				nextChar();
				result %= parseFactor();
			}
		}
		return result;
	}
	
	private double parseFactor() {
		double result = 0;
		if (currentChar == '(') {
			nextChar();
			result = parseExpression();
			nextChar();
		} else if (currentChar == '-') {
			nextChar();
			result = -parseFactor();
		} else if (currentChar == '+') {
			nextChar();
			result = parseFactor();
		} else if (Character.isDigit(currentChar)) {
			result = parseNumber();
		}
		return result;
	}
	
	private double parseNumber() {
		double result = 0;
		while (Character.isDigit(currentChar)) {
			result = result * 10 + Character.getNumericValue(currentChar);
			nextChar();
		}
		if (currentChar == '.') {
			nextChar();
			double fraction = 0;
			double divider = 10;
			while (Character.isDigit(currentChar)) {
				fraction = fraction + Character.getNumericValue(currentChar) / divider;
				divider *= 10;
				nextChar();
			}
			result += fraction;
		}
		return result;
	}
	
	private void nextChar() {
		index++;
		if (index < length) {
			currentChar = expression.charAt(index);
		} else {
			currentChar = '\0';
		}
	}
}