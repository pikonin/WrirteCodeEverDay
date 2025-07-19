package mondai12;

import java.util.Arrays;
import java.util.Scanner;

public class Main12 {

  /**
   * K枚目のチラシが印刷される時刻を二分探索で求める
   * 
   * @param A 各プリンターの印刷間隔の配列
   * @param K 何枚目のチラシか
   * @return K枚目のチラシが印刷される時刻
   */
  public static long solve(int[] A, long K) {

    long left = Arrays.stream(A).min().getAsInt(); // 最小の印刷間隔
    long right = K * Arrays.stream(A).max().getAsInt(); // 最大の印刷間隔 × K

    // 二分探索
    while (left < right) {
      long mid = left + (right - left) / 2;

      // 時刻mid以下で印刷される総チラシ枚数を計算
      long count = countPrintedFlyers(A, mid);

      if (count >= K) {
        // K枚以上印刷されている → 答えはmid以下
        right = mid;
      } else {
        // K枚未満 → 答えはmidより大きい
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * 時刻t以下で印刷される総チラシ枚数を計算
   * 
   * @param A 各プリンターの印刷間隔の配列
   * @param t 時刻
   * @return 時刻t以下で印刷される総チラシ枚数
   */
  private static long countPrintedFlyers(int[] A, long t) {
    long count = 0;
    for (int a : A) {
      count += t / a; // プリンターiが時刻t以下で印刷する枚数
    }
    return count;
  }

  // メインメソッド
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // プリンターの台数を入力
    int N = input.nextInt();

    // チラシの枚数を入力
    int K = input.nextInt();

    // 印刷の秒間隔を入力
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      // プリンターの印刷速度を入力
      int P = input.nextInt();
      A[i] = P;
    }

    // 答えを計算して出力
    long answer = solve(A, K);
    System.out.println(answer);

    input.close();
  }

}
