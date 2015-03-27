import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {

		Number number = new Number();

		System.out.println(number.getNumber());

		Scanner scanner = new Scanner(System.in);

		String yourNumber = "";

		String regex = "\\d{3}";

		try {

			while (true) {
				System.out.println("input Your Three Numbers : ");
				yourNumber = scanner.next();
				if (!yourNumber.matches(regex)) {
					System.out.println("Type Three Numbers.");
					continue;
				}

				if (!Number.isValid(yourNumber)) {
					System.out.println("Type three different numbers.");
					continue;
				}

				if (number.equals(yourNumber)) {
					System.out.println("It's Correct! Congraturation!");
					break;
				} else {
					System.out.println(number.compares(yourNumber));

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}

class Number {
	private String number = "";

	private String format = "%03d";

	public Number() {

		do {
			number = String.format(format, (int) (Math.random() * 1000));
		} while (!isValid(number));

	}

	public String compares(String yourNumber) {
		int strike = 0;
		int ball = 0;

		char[] yourChars = yourNumber.toCharArray();
		char[] numberChars = this.number.toCharArray();

		for (int i = 0; i < yourChars.length; i++) {
			for (int j = 0; j < numberChars.length; j++) {
				if (yourChars[i] == numberChars[j] && i == j) {
					strike++;
				} else if (yourChars[i] == numberChars[j]) {
					ball++;
				}

			}
		}

		return strike + "strike, " + ball + "ball.";

	}

	public boolean equals(String text) {
		return number.equals(text);
	}

	public String getNumber() {
		return this.number;
	}

	public static boolean isValid(String text) {
		char[] chars = text.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j])
					return false;
			}
		}

		return true;
	}
}
