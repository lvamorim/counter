import java.util.Scanner;
import java.util.InputMismatchException;

public class Counter {
  public static void main(String[] args) {
    printTitle("Counter");

    int num1, num2;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Please, insert the first number:");
      num1 = scanner.nextInt();

      System.out.println("Now, insert the second number:");
      num2 = scanner.nextInt();

      printCounter(num1, num2);
    }

    catch (IllegalArgumentException e) {
      printErrorMessage("Second number must be greater than first number.");
    }

    catch (InputMismatchException e) {
      printErrorMessage("Invalid input. Please insert an integer number.");
    }

    finally {
      divider();
    }
  }

  private static final int DIVIDER_LENGTH = 50;

  private static void printCounter(int num1, int num2) {
		if (num2 <= num1) {
			throw new IllegalArgumentException();
		}
		
    printTitle("List");
    
    for (int i = num1; i <= num2; i++) {
      System.out.println("Current number: " + i);
    }

    System.out.println(
      "\n" +
      "  /\\_/\\  (\r\n" +
      " ( ^.^ ) _)  thanks for\r\n" +
      "   \\\"/  (      using\r\n" +
      " ( | | )      Counter!\r\n" +
      "(__d b__)"
    );
	}

  private static void printErrorMessage(String msg) {
    printTitle("Error");
    System.err.println(msg);
  }

  private static void divider() {
    String divider = "";

    for (int i = 0; i < DIVIDER_LENGTH; i++) {
      divider +=  "-";
    }

    System.out.println(divider);
  }

  private static void printTitle(String title) {
    int length = (DIVIDER_LENGTH - title.length()) / 2;
    String spacing = " ".repeat(length);
    title = title.toUpperCase();

    divider();
    System.out.println(spacing + title + spacing);
    divider();
  }
}
