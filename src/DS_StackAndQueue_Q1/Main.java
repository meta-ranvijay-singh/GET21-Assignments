package DS_StackAndQueue_Q1;

import java.util.Scanner;

class EvaluateInfixExpression {

	private Stack<Double> values;
	private Stack<Character> operator;

	/*
	 * Method to evaluate infix expression
	 * 
	 * @param expression infix expression for evaluation
	 * 
	 * @return final result of whole expression
	 */
	public double evaluate(String expression) {

		values = new Stack<Double>();
		operator = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) == ' ')
				continue;

			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				String digit = "";
				while (i < expression.length() && expression.charAt(i) >= '0'
						&& expression.charAt(i) <= '9') {
					digit += expression.charAt(i++);
				}

				values.push(Double.parseDouble(digit));
				i--;
			}

			else if (expression.charAt(i) == '(')
				operator.push(expression.charAt(i));

			else if (expression.charAt(i) == ')') {
				while (operator.peek() != '(')
					values.push(calculate(operator.pop(), values.pop(),
							values.pop()));
				operator.pop();
			}

			else if (expression.charAt(i) == '+' || expression.charAt(i) == '-'
					|| expression.charAt(i) == '*'
					|| expression.charAt(i) == '/') {
				while (!operator.empty()
						&& hasPrecedence(expression.charAt(i), operator.peek()))
					values.push(calculate(operator.pop(), values.pop(),
							values.pop()));

				operator.push(expression.charAt(i));
			}
		}

		while (!operator.empty())
			values.push(calculate(operator.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	/*
	 * Method to check precedence of operator
	 * 
	 * @param operator1 and operator2 for comparing
	 * 
	 * @return return false if operator1 has high precedence otherwise true
	 */
	public boolean hasPrecedence(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')')
			return false;
		if ((operator1 == '*' || operator1 == '/')
				&& (operator2 == '+' || operator2 == '-'))
			return false;
		else
			return true;
	}

	/*
	 * Method to calculate value between two operands
	 * 
	 * @param operator, num1 and num2 are operands
	 * 
	 * @return result of operator
	 */
	public double calculate(char operator, double num1, double num2) {
		switch (operator) {
		case '+':
			return num2 + num1;
		case '-':
			return num2 - num1;
		case '*':
			return num2 * num1;
		case '/':
			if (num1 == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return num2 / num1;
		}
		return 0;
	}
}

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		EvaluateInfixExpression infixEvaluation = new EvaluateInfixExpression();

		System.out.print("Enter infix expression : ");
		String expression = in.nextLine();

		System.out.printf(expression + " = %.2f",
				infixEvaluation.evaluate(expression));

		in.close();
	}
}
