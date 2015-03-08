import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static final String SPACE = "\u0020";
  
  public static void main(String args[] ) throws IOException {
    // あみだを座標(x, y)で表現する。
    // x in [0, n - 1] where n is the number of vertical lines
    // y in [0, L] where L is the length of a vertical line
    boolean[][] crossPos = null;  // crossPos[x, y] is true if a vertical line crosses a horizontal line at (x, y)
    Point[][] nextPos = null;  // transfer from Point(x, y) to nextPos[x, y]
    int L;  // length of a line
    
    // input from console
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      String line = br.readLine();
      String[] elems = line.split(SPACE);
      L = Integer.parseInt(elems[0]);  // length of a line
      int n = Integer.parseInt(elems[1]);  // number of vertical lines
      int m = Integer.parseInt(elems[2]);  // number of horizontal lines
      
      crossPos = new boolean[n][L + 1];
      nextPos = new Point[n][L + 1];
      
      for (int i = 0; i < m; i++) {
        String posLine = br.readLine();
        String[] pos = posLine.split(SPACE);
        int a = Integer.parseInt(pos[0]);  // x of left line, x_left = a - 1
        int b = Integer.parseInt(pos[1]);  // y of left line, y_left = b
        int c = Integer.parseInt(pos[2]);  // y of right line, y_right = c
        
        Point posLeft = new Point(a - 1, b);
        Point posRight = new Point(a, c);
        
        crossPos[posLeft.x][posLeft.y] = true;
        crossPos[posRight.x][posRight.y] = true;
        nextPos[posLeft.x][posLeft.y] = posRight;
        nextPos[posRight.x][posRight.y] = posLeft;
      }
    }
    
    // current position Point(xc, yc)
    int xc = 0;
    
    // (0, L)からスタート。
    // 上に進み、crossPosに当たったらnextPosで次の場所に遷移。
    // 一番上(x, 0)まで行ったら終了。
    for (int yc = L; yc >= 0; yc--) {
      if (crossPos[xc][yc]) {
        Point p = nextPos[xc][yc];
        xc = p.x;
        yc = p.y;
      }
    }
    
    System.out.println(xc + 1);
  }
  
}

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
