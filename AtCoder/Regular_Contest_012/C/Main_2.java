import java.util.Scanner;

public class Main_2 {

  private static final int HEIGHT = 19;
  private static final int WIDTH = 19;

  private static final int BLACK = 1;
  private static final int WHITE = -1;
  private static final int BLANK = 0;
 
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] rows = new String[HEIGHT];
    for (int i = 0; i < HEIGHT; i++) {
      rows[i] = scanner.next();
    }
    scanner.close();
  
    int blackStones = 0;
    int whiteStones = 0;
    int prevTurn;
  
    int[][] stones = new int[HEIGHT][WIDTH];
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        switch (rows[i].charAt(j)) {
          case '.':
            stones[i][j] = BLANK;
            break;
          case 'o':
            stones[i][j] = BLACK;
            blackStones++;
            break;
          case 'x':
            stones[i][j] = WHITE;
            whiteStones++;
            break;
        }
      }
    }
  
    if (blackStones - whiteStones == 1) {
      prevTurn = BLACK;
    } else if (blackStones - whiteStones == 0) {
      prevTurn = WHITE;
    } else {
      System.out.println("NO");
      return;
    }
  
    boolean blackWins = wins(stones, BLACK);
    boolean whiteWins = wins(stones, WHITE);
    if (blackWins && whiteWins) {
      System.out.println("NO");
      return;
    } else if ( (!blackWins) && (!whiteWins) ) {
      System.out.println("YES");
      return;
    }
  
    if (blackWins) {
      if (prevTurn != BLACK) {
        System.out.println("NO");
        return;
      }
    }
    if (whiteWins) {
      if (prevTurn != WHITE) {
        System.out.println("NO");
        return;
      }
    }
  
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        if (stones[i][j] == prevTurn) {
          stones[i][j] = BLANK;
          if (!wins(stones, prevTurn)) {
            System.out.println("YES");
            return;
          }
          stones[i][j] = prevTurn;
        }
      }
    }
    System.out.println("NO");
    return;
  }
 
  private static boolean wins(int[][] stones, int color) {
    int[][] d = { {0, 1}, {1, 1}, {1, 0}, {1, -1} };
    
    for (int i = 0; i < stones.length; i++) {
      for(int j = 0; j < stones[i].length; j++) {
        if (stones[i][j] == color) {
          for (int k = 0; k < d.length; k++) {
            int nh = i;
            int nw = j;
            for (int l = 0; l < 4; l++) {
              nh += d[k][0];
              nw += d[k][1];
              if (nh < 0 || nh >= HEIGHT || nw < 0 || nw >= WIDTH) {
                break;
              }
              if (stones[nh][nw] != color) {
                break;
              }
              if (l == 3) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
}












