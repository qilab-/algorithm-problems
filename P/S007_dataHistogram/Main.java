import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
  private static final String SPACE = "\u0020";
  
  public static void main(String args[] ) throws IOException {
    String afterCompression = null;
    
    // input from console
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      afterCompression = br.readLine();
    }
    
    final Pattern LITTLE = Pattern.compile("^[a-z]$");
    final Pattern NUMBER = Pattern.compile("^[0-9]$");
    final char RIGHT_BRACKET = ')';
    final char LITTLE_A = 'a';
    
    long[] result = new long[26];
    List<Integer> numList = new ArrayList<>();
    
    for (int i = 0; i < afterCompression.length(); i++) {
      char ch = afterCompression.charAt(i);
      String str = afterCompression.substring(i, i + 1);
      if (LITTLE.matcher(str).matches()) {
        long n = 1;
        for (int j : numList) {
          n *= j;
        }
        result[ch - LITTLE_A] += n;
      } else if (NUMBER.matcher(str).matches()) {
        String number = str;
        String next = afterCompression.substring(i + 1, i + 2);
        while (NUMBER.matcher(next).matches()) {
          number += next;
          i++;
          next = afterCompression.substring(i + 1, i + 2);
        }
        if (next.equals("(")) {
          numList.add(Integer.valueOf(number));
        } else if (LITTLE.matcher(next).matches()) {
          long n = Integer.parseInt(number);
          for (Integer j : numList) {
            n *= j;
          }
          result[next.charAt(0) - LITTLE_A] += n;
          i++;
        }
      } else if (ch == RIGHT_BRACKET) {
        numList.remove(numList.size() - 1);
      }
    }
    
    for (int i = 0; i < 26; i++) {
      System.out.println((char)(i + LITTLE_A) + SPACE + result[i]);
    }
  }
  
}
