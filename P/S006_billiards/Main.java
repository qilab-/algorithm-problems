import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static final String SPACE = "\u0020";
  
  public static void main(String args[] ) throws IOException {
    int a, b, x, y, r, theta, L;
    
    // input from console
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      String line = br.readLine();
      String[] elems = line.split(SPACE);
      a = Integer.parseInt(elems[0]);
      b = Integer.parseInt(elems[1]);
      x = Integer.parseInt(elems[2]);
      y = Integer.parseInt(elems[3]);
      r = Integer.parseInt(elems[4]);
      theta = Integer.parseInt(elems[5]);
      L = Integer.parseInt(elems[6]);
    }
    
    final int TOP = b - r;
    final int BOTTOM = r;
    final int RIGHT = a - r;
    final int LEFT = r;
    
    double rad = theta * Math.PI / 180.0;
    // current position Point(xc, yc)
    double xc = x;
    double yc = y;
    double l = L;  // rest
    double c = Math.cos(rad);
    double s = Math.sin(rad);
    
    while (true) {
      if ( xc + l * c > RIGHT ||  // right
           xc + l * c < LEFT ||  // left
           yc + l * s > TOP ||  // top
           yc + l * s < BOTTOM ) {  // bottom
        // hit a wall
        if (s >= 0 && c >= 0) {
          // hit top or right
          if (xc + (TOP - yc) * c / s <= RIGHT) {
            // hit top
            l -= (TOP - yc) / s;
            xc = xc + (TOP - yc) * c / s;
            yc = TOP;
            s = -s;
          } else {  // yc + (RIGHT - xc) * s / c < TOP
            // hit right
            l -= (RIGHT - xc) / c;
            yc = yc + (RIGHT - xc) * s / c;
            xc = RIGHT;
            c = -c;
          }
        } else if (s >= 0 && c <= 0) {
          // hit top or left
          if (xc + (TOP - yc) * c / s >= LEFT) {
            // hit top
            l -= (TOP - yc) / s;
            xc = xc + (TOP - yc) * c / s;
            yc = TOP;
            s = -s;
          } else {  // yc + (LEFT - xc) * s / c < TOP
            // hit left
             l -= (LEFT - xc) / c;
             yc = yc + (LEFT - xc) * s / c;
             xc = LEFT;
             c = -c;
          }
        } else if (s <= 0 && c >= 0) {
          // hit bottom or right
          if (xc + (BOTTOM - yc) * c / s <= RIGHT) {
            // hit bottom
            l -= (BOTTOM - yc) / s;
            xc = xc + (BOTTOM - yc) * c / s;
            yc = BOTTOM;
            s = -s;
          } else {  // yc + (RIGHT - xc) * s / c > BOTTOM
            // hit right
            l -= (RIGHT - xc) / c;
            yc = yc + (RIGHT - xc) * s / c;
            xc = RIGHT;
            c = -c;
          }
        } else {
          // hit bottom or left
          if (xc + (BOTTOM - yc) * c / s >= LEFT) {
            // hit bottom
            l -= (BOTTOM - yc) / s;
            xc = xc + (BOTTOM - yc) * c / s;
            yc = BOTTOM;
            s = -s;
          } else {  // 
            // hit left
            l -= (LEFT - xc) / c;
            yc = yc + (LEFT - xc) * s / c;
            xc = LEFT;
            c = -c;
          }
        }
      } else {
        xc = xc + l * c;
        yc = yc + l * s;
        break;
      }
    }
    
    System.out.println(xc + SPACE + yc);
  }
  
}
