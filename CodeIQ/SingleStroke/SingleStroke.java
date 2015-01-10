/*
横にm個、縦にn個の格子点が並んでいます。
このすべての点を一筆書きで結ぶことを考えます。

ただし、縦と横の隣り合う点を直線で結ぶのみとし、交差してはいけないものとします。
斜めに結ぶこともできませんし、直線以外で結ぶこともできません。
（始点と終点が重なることも交差とみなすことにします。）

m=4, n=3のとき、以下の図にあるOKのような形が考えられます。
また、NGのような形は交差しているため、対象外となります。

m=5, n=4のとき、全部で何通りの書き方があるかを求めなさい。
※始点と終点が逆なだけで同じ位置、同じ形である場合は1つと数えますが、
　上下・左右などの反転で形だけ同じ（位置が違う）場合は別々のものとカウントします。

【解答方法】
解答フォームの1行目に答えを記入してください。
２行目以降はあなたが求めた方法を記入してください。プログラムを書いた場合はコードを貼り付けてください。
*/
// written by Java SE 7
public class SingleStroke {

  public static void main(String[] args) {
  
    int m = 5;  // column
    int n = 4;  // row
    boolean[][] frag = new boolean[n][m];  // grid
    
    // up: 1, right: 2, down: 3, left: 4
    //int direction = 1;
    
    // 移動回数は、(n * m - 1)回
    
    
    // 成功した path を記録
    Set<Path> pathSet = new HashSet<Path>();
    for (int i = 0, i < n; i++) {
      for (int j = 0; j < m; j++) {
        
        // initialize
        for (boolean[] ba : frag) {
          for (boolean b : ba) {
            b = false;
          }
        }
        // start point
        frag[i][j] = true;
        Point startPoint = new Point(i, j);
        Path path = new Path(startPoint);
        
        Point currentPoint = path.pointList.get(path.currentIndex);
        for (;;) {
          int direction = path.directionList.get(currentIndex);
          switch (direction) {
            case 1:  // up
              if (currentPoint.row == 0 || frag[currentPoint.row - 1][currentPoint.column]) {
                path.directionList.set(currentIndex, 2);
              }
          }
        }
        
        
        
      
      }
    
    }
  
  
  }

  public class Point {
    int row;  // row in [0, n-1]
    int column;  // column in [0, m-1]
    
    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }
  
  public class Path {
    List<Point> pointList;
    List<Integer> directionList;
    int currentIndex;
    
    public Path(Point startPoint) {
      pointList = new ArrayList<Point>();
      pointList.add(startPoint);
      directionList = new ArrayList<Integer>();
      directionList.add(1);
      currentIndex = 0;
    }
    // equals() override
  }



}







