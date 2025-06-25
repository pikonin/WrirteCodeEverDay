package mondai8;

import java.util.Scanner;

public class Main8 {

  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);

    // 縦のマスの数を入力
    int hight = input.nextInt();

    // 横のマスの数を入力
    int width = input.nextInt();

    // 縦マスの累積和
    int[][] sum = new int[hight + 1][width + 1];

    // 累積和の計算
    for (int i = 1; i <= hight; i++) {
      for (int j = 1; j <= width; j++) {
        // マスの値を入力
        int value = input.nextInt();

        // 累積和を計算
        sum[i][j] = sum[i][j - 1] + value;
      }
    }
    // 累積和の表示（デバッグ用）
    for (int i = 1; i <= hight; i++) {
      for (int j = 1; j <= width; j++) {
        System.out.print(sum[i][j] + " ");
      }
      System.out.println();
    }

    // 質問数の入力
    int q = input.nextInt();
    for (int i = 1; i <= q; i++) {
      // 質問の左上の座標を入力
      int x1 = input.nextInt();
      int y1 = input.nextInt();

      // 質問の左下の座標を入力
      int x2 = input.nextInt();
      int y2 = input.nextInt();
      // 選択した範囲内の累積和の計算
      int ans = 0;
      for (int row = x1; row <= x2; row++) {
        ans += sum[row][y2] - sum[row][y1 - 1];
        // 計算内容のデバック
        System.out.println("row: " + row + ", sum[row][y2]: " + sum[row][y2]
            + ", sum[row][y1 - 1]: " + sum[row][y1 - 1] + ", ans: " + ans);
      }

      // 結果の出力
      System.out.println(ans);

    }
    input.close();
  }

}
