import java.util.Scanner;
import java.util.InputMismatchException;

public class Counter {
  public static void main(String[] args) {
    title();

    int num1, num2;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Please, insert the first number:");
      num1 = scanner.nextInt();

      System.out.println("Now, insert the second number:");
      num2 = scanner.nextInt();

      System.out.println();

      try {
        count(num1, num2);
      }
      
      catch (IllegalArgumentException e) {
        scanner.nextLine();
        errorMsg("Second number must be greater than first number.");
      }
    }

    catch (InputMismatchException e) {
      errorMsg("Invalid input. Please insert two numbers.");
    }

    finally {
      drawLine();
    }
  }

  static void count(int num1, int num2) {
		if (num2 <= num1) {
			throw new IllegalArgumentException();
		}
		
    System.out.println("----------------- L I S T -----------------");
    
    for (int i = num1; i <= num2; i++) {
      System.out.println("Current number: " + i);
    }
	}

  static void title() {
    drawLine();
		System.out.println("-------------- C O U N T E R --------------");
    drawLine();
		System.out.println();
  }

  static void errorMsg(String msg) {
    System.err.println("---------------- E R R O R ----------------");
    System.err.println(msg);
  }

  static void drawLine() {
    System.out.println("-------------------------------------------");
  }
}
