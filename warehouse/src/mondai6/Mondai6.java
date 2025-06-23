package mondai6;

import java.util.Scanner;

public class Mondai6 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt(); // 営業日数
    int q = input.nextInt(); // 質問数

    // 累積和用の配列（長さn+1）
    int[] prefixSum = new int[n + 1];

    // 累積和の計算（1日目〜i日目までの合計を格納）
    for (int i = 1; i <= n; i++) {
      int v = input.nextInt(); // i日目の来場者数
      prefixSum[i] = prefixSum[i - 1] + v;
    }

    // 質問に対する答えを求める
    for (int i = 0; i < q; i++) {
      int startDay = input.nextInt();
      int endDay = input.nextInt();
      int totalVisitors = prefixSum[endDay] - prefixSum[startDay - 1];
      System.out.println(totalVisitors);
    }

    input.close();
  }
}
