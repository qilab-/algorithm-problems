import java.util.Scanner;

public class Main_4 {

  private static final int MAX_NUM = 100000;
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int T = scanner.nextInt();
    long modulo = scanner.nextLong();
    int[][] pos = new int[N][2];
    for (int i = 0; i < N; i++) {
      pos[i][0] = Math.abs(scanner.nextInt());
      pos[i][1] = Math.abs(scanner.nextInt());
    }
    scanner.close();
    
    long result = 1;
    
    for (int person = 0; person < N; person++) {
      int x = pos[person][0];
      int y = pos[person][1];
      if (T - x - y < 0 || (T - x - y) % 2 != 0) {
        System.out.println(0);
        return;
      }
      
      int ru = (T - x - y) / 2;
      int ld = x + y + ru;
      int lu = x + ru;
      int rd = y + ru;
      
      int[] powers = new int[MAX_NUM + 1];
      // 階乗の起点
      powers[T]++;
      powers[T]++;
      powers[ru]--;
      powers[ld]--;
      powers[lu]--;
      powers[rd]--;
      // 階乗の起点から階乗を作る
      int count = 0;
      for (int i = MAX_NUM; i >= 0; i--) {
        count += powers[i];
        powers[i] = count;
      }
      // 素因数分解をして、その積を求める。
      boolean[] composite = new boolean[MAX_NUM + 1];
      for (int i = 2; i < MAX_NUM; i++) {
        // 素数チェック
        if (composite[i]) {
          continue;
        }
        long pow = 0;
        for (long j = i; j <= MAX_NUM; j *= i) {
          // jはiの冪。j = i^1, i^2, i^3,...
          for (long k = j; k <= MAX_NUM; k += j) {
            // k = j, 2j, 3j,...
            // すなわち、 k = a*i^b for a, b in N
            // a, b != 1 ならば、 k は i で素因数分解できる合成数である。
            composite[(int)k] = true;
            pow += powers[(int)k];
          }
        }
        result = (result * powMod(i, pow, modulo)) % modulo;
      }
    }
    
    System.out.println(result);
  }
  
  private static long powMod(long base, long exp, long mod) {
    if (exp == 0) {
      return 1;
    }
    if (exp % 2 == 0) {
      return powMod(base * base % mod, exp / 2, mod);
    }
    return powMod(base * base % mod, exp / 2, mod) * base % mod;
  }

}
