package tax;

import java.util.Scanner;

public class tax {
	public static void main(String[] args) {
		calculator Tax = new calculator();
		int husbandIncome, wifeIncome;
		System.out.println("Welcome this is a Hong Kong Tax Systems:");
		try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Type a Husband Income:");
			husbandIncome = myObj.nextInt();
			System.out.println("Husband MPF:");
			System.out.println(Tax.husbandMpfC(husbandIncome));
			System.out.println("Type a Wife Income:");
			wifeIncome = myObj.nextInt();
			System.out.println("Wife MPF:");
			System.out.println(Tax.wifeMpfC(wifeIncome));
			System.out.println("Husband Pay Tax:");
			System.out.println(Tax.husbandTaxPay(husbandIncome));
			System.out.println("Wife Pay Tax:");
			System.out.println(Tax.husbandTaxPay(wifeIncome));
			System.out.println("Total Pay Tax:");
			System.out.println(Tax.husbandTaxPay(husbandIncome) + Tax.husbandTaxPay(wifeIncome));
			System.out.println("Joint Assessment Pay Tax:");
			System.out.println(Tax.joinTaxPay(wifeIncome, husbandIncome));
			int total = Tax.husbandTaxPay(husbandIncome) + Tax.husbandTaxPay(wifeIncome);
			int join = Tax.joinTaxPay(wifeIncome, husbandIncome);
			if (total < join) {
				System.out.println("Separated is better.");
			} else {
				System.out.println("Join is better.");
			}
		} catch (Exception e) {
			System.out.println("Number only try again.");

		}

	}

}