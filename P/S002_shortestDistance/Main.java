import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  private static final String SPACE = "\u0020";
  
  public static void main(String args[] ) throws IOException {
    final String START = "s";
    final String GOAL = "g";
    final String ROAD = "0";
    final String WALL = "1";
    
    int N, M;
    String[][] initField = null;
    boolean[][] goable = null;
    Point startPoint = null;
    
    // input from console
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      String columnRow = br.readLine();
      M = Integer.parseInt(columnRow.split(SPACE)[0]);  // column
      N = Integer.parseInt(columnRow.split(SPACE)[1]);  // row
      initField = new String[N][M];
      goable = new boolean[N][M];
      for (int i = 0; i < N; i++) {
        String row = br.readLine();
        String[] elements = row.split(SPACE);
        for (int j = 0; j < M; j++) {
          initField[i][j] = elements[j];
          if (elements[j].equals(START)) {
            startPoint = new Point(i, j);
            goable[i][j] = false;
          } else if (elements[j].equals(ROAD)) {
            goable[i][j] = true;
          } else if (elements[j].equals(WALL)) {
            goable[i][j] = false;
          } else if (elements[j].equals(GOAL)) {
            goable[i][j] = true;
          }
        }
      }
    }
    
    Deque<Point> path = new LinkedList<>();
    path.addLast(startPoint);
    int direction = 0;
    Deque<Integer> directionList = new LinkedList<>();
    directionList.addLast(direction);
    
    int minDir = 1000 * 1000;
    
    while (true) {
      Point c = path.getLast();
      if (directionList.getLast() == 0) {
        // right
        if (c.col + 1 < M && goable[c.row][c.col + 1]) {
          path.addLast(new Point(c.row, c.col + 1));
          goable[c.row][c.col + 1]= false; 
          directionList.addLast(0);
        } else {
          int dir = directionList.pollLast();
          directionList.addLast(dir + 1);
          continue;
        }
      } else if (directionList.getLast() == 1) {
        // down
        if (c.row + 1 < N && goable[c.row + 1][c.col]) {
          path.addLast(new Point(c.row + 1, c.col));
          goable[c.row + 1][c.col]= false;
          directionList.addLast(0);
        } else {
          int dir = directionList.pollLast();
          directionList.addLast(dir + 1);
          continue;
        }
      } else if (directionList.getLast() == 2) {
        // left
        if (c.col - 1 > -1 && goable[c.row][c.col - 1]) {
          path.addLast(new Point(c.row, c.col - 1));
          goable[c.row][c.col - 1]= false;
          directionList.add(0);
        } else {
          int dir = directionList.pollLast();
          directionList.addLast(dir + 1);
          continue;
        }
      } else if (directionList.getLast() == 3) {
        // up
        if (c.row - 1 > -1 && goable[c.row - 1][c.col]) {
          path.addLast(new Point(c.row - 1, c.col));
          goable[c.row - 1][c.col]= false;
          directionList.add(0);
        } else {
          int dir = directionList.pollLast();
          directionList.addLast(dir + 1);
          continue;
        }
      }
      
      if (path.size() == 0) {
        path.addLast(startPoint);
      }
      Point current = path.getLast();
      Integer currentDir = directionList.getLast();
      if (initField[current.row][current.col].equals(GOAL)) {
        minDir = Math.min(minDir, path.size() - 1);
        directionList.pollLast();
        Point p = path.pollLast();
        goable[p.row][p.col] = true;
        int dir = directionList.pollLast();
        directionList.addLast(dir + 1);
      }
      if (path.size() == 1 && currentDir >= 4) {
        // start point
        break;
      } else if (currentDir == 4) {
        Point p = path.pollLast();
        goable[p.row][p.col] = true;
        directionList.pollLast();
        int dir = directionList.pollLast();
        directionList.addLast(dir + 1);
      }
    }
    
    if (minDir < 1000 * 1000) {
      System.out.println(minDir);
    } else {
      System.out.println("Fail");
    }
  }
  
}

class Point {
  int row;
  int col;

  public Point(int row, int col) {
    this.row = row;
    this.col = col;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Point) {
      Point p = (Point)obj;
      return (row == p.row) && (col == p.col);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    int sum = row + col;
    return sum * (sum + 1) / 2 + row;
  }
}
