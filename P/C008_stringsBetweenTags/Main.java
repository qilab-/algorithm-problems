import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
  private static final String SPACE = "\u0020";
  
  public static void main(String args[] ) throws IOException {
    List<String> list = new ArrayList<>();
    String tagA = null;
    String tagB = null;
    String s = null;
    
    // input from console
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      String[] tags = br.readLine().split(SPACE);
      tagA = tags[0];
      tagB = tags[1];
      s = br.readLine();
    }
    
    for (int i = 0; i < s.length(); i++) {
      if (s.length() >= i + tagA.length() && s.substring(i, i + tagA.length()).equals(tagA)) {
        i += tagA.length();
        for (int j = i; j < s.length(); j++) {
          if (s.length() >= j + tagB.length() && s.substring(j, j + tagB.length()).equals(tagB)) {
            if (!s.substring(i,j).isEmpty()) {
              list.add(s.substring(i, j));
            } else {
              list.add("<blank>");
            }
            i = j + tagB.length() - 1;
            break;
          }
        }
      }
    }
    
    for (String str: list) {
      System.out.println(str);
    }
  }
}
