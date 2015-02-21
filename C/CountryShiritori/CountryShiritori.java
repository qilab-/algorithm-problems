import java.util.ArrayList;
import java.util.List;

public class CountryShiritori {

  public static void main(String[] args) {
    // しりとりで使う単語の配列
    String[] countries = {"Brazil", "Croatia", "Mexico", "Cameroon", "Spain", "Netherlands", "Chile", "Australia", "Colombia", "Greece", "Cote d'Ivoire", "Japan", "Uruguay", "Costa Rica", "England", "Italy", "Switzerland", "Ecuador", "France", "Honduras", "Argentina", "Bosnia and Herzegovina", "Iran", "Nigeria", "Germany", "Portugal", "Ghana", "USA", "Belgium", "Algeria", "Russia", "Korea Republic"};
    
    // しりとりで使った単語の index を格納するリスト
    List<Integer> shiritori = new ArrayList<Integer>();
    List<Integer> shiritori2 = new ArrayList<Integer>();
    
    // while ループのフラグ
    // flag = false ですべて終了
    boolean flag = true;
    // currentIndex は、しりとりで一番最後に言われた単語に対応する、配列 countries の index
    int currentIndex = 0;
    // nextIndex はサーチ用の、次の単語の index
    int nextIndex = 0;

    // しりとりの最初の単語の初期値
    shiritori.add(0);
    
    while(flag) {
      // 現在の単語の「しり」
      String currentWord = countries[shiritori.get(shiritori.size() - 1)];
      char e = currentWord.toLowerCase().charAt(currentWord.length() - 1);

      // 次の単語の検索
      for (int i = nextIndex; i < countries.length; i++) {
        // 現在の単語の「しり」と、次の単語の「あたま」が同じかどうかを判定
        if (e == countries[i].toLowerCase().charAt(0)) {
          // すでにその単語が使われていなければ、しりとりの最後の単語に追加。
          if (!shiritori.contains(i)) {
            shiritori.add(i);
            // 現在の単語を、いま追加されたものにする
            currentIndex = i;
            // 次の単語は、また index = 0 からサーチ
            nextIndex = 0;
            break;
          }
        }
        // もし、配列 countries の単語をすべて検索し終えたら
        if (i == countries.length - 1) {
          // 今までで一番長く続いた場合は、それを記録
          if (shiritori2.size() < shiritori.size()) {
            shiritori2.clear();
            shiritori2.addAll(shiritori);
          }
          // もし、現在の単語が1つ目ならば、
          if (shiritori.size() - 1 - 1 < 0) {
            // しりとりの最初の単語として、すべての countries の単語を使用したら、終わり。
            if (currentIndex == countries.length - 1) {
              // while ループを抜ける
              flag = false;
            }
            // しりとりの最初の単語を変更（countries の index を1つあげる）
            currentIndex++;
            nextIndex = 0;
            shiritori.clear();
            shiritori.add(currentIndex);
            break;
          }
          // 検索対象の単語を一つ前にもどす
          int lastIndex = shiritori.size() - 1;
          currentIndex = shiritori.get(lastIndex -1);
          nextIndex = shiritori.get(lastIndex) + 1;
          shiritori.remove(lastIndex);
        }
      }
    }
    
    // 結果の出力
    System.out.println("使われた国の数： " + shiritori2.size());
    for (Integer index : shiritori2) {
      System.out.println(countries[index]);
    }

  }
}
