public class CountSeven {

  public static void main(String[] args) {
  
    int n = 99;
    int count = 0;
    
    for (int i = 1; i <= n; i++) {
      int num = i;
      for (int j = 1; j < 4; j++) {  // 桁
        if (num % 10 == 7) {
          count += 1;
        }
        num = (int) Math.floor(num / 10);
        if (num < 1) {
          break;
        }
      }
    }
    
    System.out.println("7の数は" + count + "個です。");
  }
}