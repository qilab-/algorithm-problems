import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String day = scanner.next();
    scanner.close();
    
    int r = 0;
    switch (day) {
      case "Monday":
        r = 5;
        break;
      case "Tuesday":
        r = 4;
        break;
      case "Wednesday":
        r = 3;
        break;
      case "Thursday":
        r = 2;
        break;
      case "Friday":
        r = 1;
        break;
      case "Saturday":
      case "Sunday":
        r = 0;
        break;
    }
    System.out.println(r);
  }
}





