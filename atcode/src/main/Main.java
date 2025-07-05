package main;

import java.util.Scanner;

public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);
    // 最大値を入力
    int maxNumber = input.nextInt();

    // 目標合計値を入力
    int targetSum = input.nextInt();

    input.close();

    // ３つの整数の和が目標合計値になるような整数の組み合わせが何通りあるか計算
    int count = 0;
    for (int i = 1; i <= maxNumber; i++) {
      for (int j = 1; j <= maxNumber; j++) {
        int k = targetSum - i - j;
        if (k >= 1 && k <= maxNumber)
          count++;
      }
    }

    // 結果の出力
    System.out.println(count);
  }
}
