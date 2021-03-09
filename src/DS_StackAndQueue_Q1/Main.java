package DS_StackAndQueue_Q1;

import java.util.Scanner;

class GenericStack<T> implements Stack<T> {
	/**
	 * Node class used to create new node in the linked list.
	 */
	public class Node<T> {
		T data;
		public Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// Head
	public Node<T> head = null;

	/**
	 * Method to insert element in the stack.
	 * 
	 * @param new_data
	 *            data to be insert
	 */
	@Override
	public void push(T new_data) {
		Node<T> new_node = new Node<T>(new_data);

		if (head == null) {
			head = new_node;
			return;
		}

		new_node.next = head;
		head = new_node;

		return;

	}

	/**
	 * Method to insert element in the stack.
	 */
	@Override
	public T pop() {
		if (head == null) {
			return null;
		}

		T pop = head.data;
		head = head.next;

		return pop;
	}

	/**
	 * Method to traverse stack.
	 */
	@Override
	public void traverse() {
		Node tempNode = head;
		if (head == null) {
			System.out.println("Stack is empty");
			return;
		}

		while (tempNode != null) {
			System.out.print("->" + tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.println();

	}

	/**
	 * Method to get peek value of the stack.
	 * 
	 * @return peek value of stack
	 */
	@Override
	public T peek() {
		T peek = head.data;
		return peek;
	}

	/**
	 * Method to check wheather stack is empty or not.
	 * 
	 * @return true if stack is empty otherwise false
	 */
	@Override
	public boolean empty() {
		if (head == null) {
			return true;
		}

		else {
			return false;
		}

	}

}

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

		values = new GenericStack<Double>();
		operator = new GenericStack<Character>();

		//Loop for scanning one character at a time from expression
		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) == ' ')
				continue;

			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				String digit = "";
				
				//Loop will run untill it encounter an operator
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
				
				//Loop will run untill it encounter opening bracket
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
