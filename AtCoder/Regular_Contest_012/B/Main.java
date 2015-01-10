import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int va = scanner.nextInt();
    int vb = scanner.nextInt();
    int L = scanner.nextInt();
    scanner.close();
  
    double diff = L;
  
    for (int i = 0; i < N; i++) {
      diff = diff * vb / (double)va;
    }
  
    System.out.println(diff);
  }
}