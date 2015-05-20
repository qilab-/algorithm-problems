import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main_2 {
  private static final String SPACE = "\u0020";
  private static final String LEFT_BRACKET = "(";
  private static final String RIGHT_BRACKET = ")";
  private static final char LITTLE_A = 'a';

  private static final Pattern LITTLE = Pattern.compile("^[a-z]$");
  private static final Pattern NUMBER = Pattern.compile("^[0-9]$");

  public static void main(String args[] ) throws IOException {
    String afterCompression = null;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      afterCompression = br.readLine();
    }

    long[] result = new long[26];
    List<Long> numList = new ArrayList<>();

    String number = "";
    for (int i = 0; i < afterCompression.length(); i++) {
      String c = afterCompression.substring(i, i + 1);
      if (LITTLE.matcher(c).matches()) {
        long n = 1L;
        if (!number.isEmpty()) {
          n = Long.parseLong(number);
          number = "";
        }
        for (long j : numList) {
          n *= j;
        }
        result[c.charAt(0) - LITTLE_A] += n;
      } else if (NUMBER.matcher(c).matches()) {
        number += c;
      } else if (c.equals(LEFT_BRACKET)) {
        long n = 1L;
        if (!number.isEmpty()) {
          n = Long.parseLong(number);
          number = "";
        }
        numList.add(n);
      } else if (c.equals(RIGHT_BRACKET)) {
        numList.remove(numList.size() - 1);
      }
    }

    for (int i = 0; i < 26; i++) {
      System.out.println((char)(i + LITTLE_A) + SPACE + result[i]);
    }
  }

}
