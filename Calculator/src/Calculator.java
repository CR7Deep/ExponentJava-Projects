import java.util.Scanner;

public class Calculator {

	static Scanner sc = new Scanner(System.in);

	public static int methodone() {

		System.out.println("Enter first number: ");
		int first = sc.nextInt();
		return first;
	}

	public static int methodtwo() {

		System.out.println("Enter second number: ");
		int second = sc.nextInt();
		return second;
	}

	public static int add(int first, int second) {

		int result = first + second;
		return result;
	}

	public static int sub(int first1, int second1) {

		int sub = first1 - second1;
		return sub;
	}

	public static int multi(int first2, int second2) {

		int multi = first2 * second2;
		return multi;
	}

	public static double div(double first3, double second3) {

		double div = first3 / second3;
		return div;
	}

	public static void main(String[] args) {

		System.out.println("Welcome To Calculator");
		boolean flag = true;

		while (flag) {
			System.out.println("1) Addition");
			System.out.println("2) Substraction");
			System.out.println("3) Multiplication");
			System.out.println("4) Division");
			System.out.println("5) Exit");

			int Choice = sc.nextInt();

			switch (Choice) {

			case 1:
				System.out.println("Add");
				int first = methodone();
				int second = methodtwo();
				int result = add(first, second);
				System.out.println(first + "+" + second + "=" + result);
				break;

			case 2:

				System.out.println("Sub");
				int first1 = methodone();
				int second1 = methodtwo();
				int subtraction = sub(first1, second1);
				System.out.println(first1 + "-" + second1 + "=" + subtraction);
				break;

			case 3:

				System.out.println("Multi");
				int first2 = methodone();
				int second2 = methodtwo();
				int multiplication = multi(first2, second2);
				System.out.println(first2 + "*" + second2 + "=" + multiplication);
				break;

			case 4:

				System.out.println("Division");
				int first3 = methodone();
				int second3 = methodtwo();
				double division = div(first3, second3);
				System.out.println(first3 + "/" + second3 + "=" + division);
				break;

			case 5:

				System.out.println("Thank You");
				flag = false;
				break;

			default:
				System.out.println("Invalid Input!!!");
				break;
			}
		}
	}
}