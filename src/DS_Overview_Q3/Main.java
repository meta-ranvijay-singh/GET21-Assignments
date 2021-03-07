package DS_Overview_Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MultiVariablePloy polynomial = new MultiVariablePloy();

		int coeff;
		List<String> variable;
		List<Integer> power;

		String termChoice, varChoice;

		//Loop to enter terms
		do {
			variable = new ArrayList<String>();
			power = new ArrayList<Integer>();

			System.out.print("Enter Coefficent :");
			coeff = in.nextInt();
			
			//Loop to enter variables and their power
			do {
				System.out.print("Enter variable :");
				variable.add(in.next());

				System.out.print("Enter power :");
				power.add(in.nextInt());

				System.out.print("Want to enter more variables (Y/N) ? :");
				varChoice = in.next();
			} while ("y".equals(varChoice) || "Y".equals(varChoice));

			polynomial.insertLast(coeff, variable, power);

			System.out.print("Want to enter more terms (Y/N) ? :");
			termChoice = in.next();

		} while ("y".equals(termChoice) || "Y".equals(termChoice));

		polynomial.traverse();

		System.out.println(polynomial.findDegree());
	}

}
