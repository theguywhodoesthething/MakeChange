import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		char anotherTransaction;
		double purchasePrice, amountGiven;
		int sendPennies;

		do {

			System.out.print("Enter the cost of your item: ");
			purchasePrice = kb.nextDouble();

			System.out.print("Enter the amount tendered by the customer: ");
			amountGiven = kb.nextDouble();

			sendPennies = (int) ((amountGiven * 100) - (purchasePrice * 100));

			System.out.println(returnChange(sendPennies));

			System.out.print("Would you like to make another transaction? (Y/N) ");
			anotherTransaction = ((kb.next()).toLowerCase()).charAt(0);

		} while (anotherTransaction == 'y');

		kb.close();

	}

	public static String returnChange(int changeIn) {

		String changeOut = "The customer receives ";
		String singleMint[] = {"twenty, ", "ten, ", "five, ", "dollar, ", "quarter, ",
										"dime, ", "nickel, ", "penny, " };
		String pluralMint[] = {"twenties, ", "tens, ", "fives, ", "dollars, ", "quarters, ",
													"dimes, ", "nickels, ", "pennies, " };
		int pennies[] = { 2000, 1000, 500, 100, 25, 10, 5, 1 };

		if (changeIn < 0) {
			changeOut = "You didn't pay enough. Try again.";
			return changeOut;
		} else if (changeIn == 0) {
			changeOut = "You gave exact change.";
			return changeOut;
		}

		for (int i = 0; i < pennies.length; i++) {
			if (changeIn >= pennies[i]) {
				changeOut += "(" + (int) (changeIn / pennies[i]) + ") ";

				if ( ((int)(changeIn / pennies[i])) == 1 ) {
					changeOut += singleMint[i];
				}
				else {
					changeOut += pluralMint[i];
				}


				changeIn = changeIn % pennies[i];
			}
		}

		changeOut += "\b\b in change.";

		return changeOut;
	}
}
