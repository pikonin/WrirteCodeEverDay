package mondai7;

import java.util.Scanner;

public class Mondai7 {

  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);

    // イベント開催日数を入力
    int d = input.nextInt();

    // 出席人数
    int n = input.nextInt();

    // 差分配列
    int[] diff = new int[d + 1];

    for (int i = 0; i < n; i++) {
      int start = input.nextInt(); // 開始日
      int end = input.nextInt(); // 終了日
      // 差分配列の更新
      // 開始日に1人増える
      diff[start]++;

      // 終了日の翌日に1人減る
      diff[end + 1]--;
    }

    input.close();

    // 累積和を計算して日ごとの出席人数を求める
    int sum = 0;
    for (int day = 1; day <= d; day++) {
      sum += diff[day]; // 差分配列から累積和を計算
      System.out.println(sum); // 日ごとの出席人数を出力

    }
  }

}
