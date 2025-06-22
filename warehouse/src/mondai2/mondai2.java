package mondai2;

import java.util.ArrayList;
import java.util.Scanner;

public class mondai2 {

  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);

    int N = input.nextInt();
    int X = input.nextInt();
    // 画面から入力した値をArraylistに格納
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i <= N; i++) {
      list.add(input.nextInt());
    }

    input.close();

    // list内にXの値が含まれる場合は、Yesを返す。
    boolean found = false;
    for (int number : list) {
      if (number == X) {
        found = true;
        break;
      }
    }
    if (found) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

}
