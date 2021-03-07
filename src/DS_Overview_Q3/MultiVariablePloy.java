package DS_Overview_Q3;

import java.util.List;

public class MultiVariablePloy {
	/**
	 * Node class used to create new node for terms in the linked list.
	 */
	public class Node {
		public VariableNode variableNode;
		public Node next;
		int coefficient;

		public Node(int data) {
			this.coefficient = data;
			this.next = null;
			this.variableNode = null;
		}
	}

	/**
	 * VariableNode class used to create new node for variable in the Node.
	 */
	public class VariableNode {
		String variable;
		int power;
		public VariableNode next;

		public VariableNode(String var, int pow) {
			this.variable = var;
			this.power = pow;
			this.next = null;
		}
	}

	public Node head = null;

	/**
	 * Method to insert element in the last position in linked list.
	 * 
	 * @param coeff coefficient of variable, variable list of variable, power list of power
	 */
	public void insertLast(int coeff, List<String> variable, List<Integer> power) {
		Node new_node = new Node(coeff);

		for (int i = 0; i < variable.size(); ++i) {
			VariableNode newVarNode = new VariableNode(variable.get(i),
					power.get(i));

			if (new_node.variableNode == null) {
				new_node.variableNode = newVarNode;
			} else {
				VariableNode tempVarNode = new_node.variableNode;
				while (tempVarNode.next != null) {
					tempVarNode = tempVarNode.next;
				}

				tempVarNode.next = newVarNode;

			}

		}

		if (head == null) {
			head = new_node;
			return;
		}

		Node last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;

		return;
	}

	/**
	 * Method to traverse polynomial linked list.
	 */
	public void traverse() {

		Node tempNode = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (tempNode != null) {
			System.out.print(tempNode.coefficient);

			VariableNode varNode = tempNode.variableNode;

			while (varNode != null) {
				System.out.print(varNode.variable + "^" + varNode.power);
				varNode = varNode.next;
			}

			tempNode = tempNode.next;
			if (tempNode != null)
				System.out.print(" + ");

		}
		System.out.println();
	}

	/**
	 * Method to find highest degree of the polynomial.
	 */
	public int findDegree() {
		int maxPower = 0;

		Node tempNode = head;
		if (head == null) {
			return maxPower;
		}

		while (tempNode != null) {
			int powerSum = 0;

			VariableNode varNode = tempNode.variableNode;

			while (varNode != null) {
				powerSum += varNode.power;
				varNode = varNode.next;
			}

			tempNode = tempNode.next;

			if (powerSum > maxPower)
				maxPower = powerSum;

		}

		return maxPower;
	}

}
