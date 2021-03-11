package ObjectsAndCollections_Q3;

import java.util.Scanner;

public class Main {
	static final int CarbonMass = 12;
	static final int OxygenMass = 16;
	static final int HydrogenMass = 1;

	/*
	 * Method to calculate molecular mass of Organic compound
	 * 
	 * @param String formula
	 * 
	 * @return mass molecular mass of the compound
	 */
	public static int calculateMolecularMass(String formula) {
		int mass = 0;
		formula = formula + " ";

		// Loop for scanning per character in the string
		for (int i = 0; i < formula.length() - 1; ++i) {
			if ((formula.charAt(i + 1) >= '0')
					&& (formula.charAt(i + 1) <= '9')) {
				mass += (returnMass(formula.charAt(i)) * Integer
						.parseInt(formula.charAt(++i) + ""));
			} else if (formula.charAt(i) == '(') {
				String buffer = "";

				// Loop storing formula that comes within the brackets()
				while (++i < formula.length() && formula.charAt(i) != ')') {
					buffer += formula.charAt(i);
				}
				if ((i + 1) < formula.length()
						&& (formula.charAt(i + 1) >= '0')
						&& (formula.charAt(i + 1) <= '9')) {
					mass += (calculateMolecularMass(buffer) * Integer
							.parseInt(formula.charAt(++i) + ""));
				} else {
					mass += calculateMolecularMass(buffer);
				}
			} else {
				mass += returnMass(formula.charAt(i));
			}
		}

		return mass;
	}

	/*
	 * Method to get Molecular mass of a periodic element
	 * 
	 * @return molecular mass of periodic element
	 */
	public static int returnMass(Character periodicSymbol) {
		switch (periodicSymbol) {
		case 'C':
			return CarbonMass;
		case 'H':
			return HydrogenMass;
		case 'O':
			return OxygenMass;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter Organic checmical formula :");
		String formula = in.nextLine();

		System.out
				.println("Molecular Mass :" + calculateMolecularMass(formula));

		in.close();
	}

}
