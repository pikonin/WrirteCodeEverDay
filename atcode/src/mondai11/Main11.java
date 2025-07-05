package mondai11;

import java.util.Scanner;

public class Main11 {

  static int[] A;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // 配列を指定
    int N = input.nextInt();

    // 指定の数値入力
    int X = input.nextInt();

    // 配列に入る値を入力
    A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = input.nextInt();
    }

    input.close();

    // 二部探索でXが何番目に含まれているかを調べる
    BinarySearch bs = new BinarySearch(A);
    int index = bs.binarySearch(X);

    // 結果の出力
    if (index != -1) {
      System.out.println(index + 1);
    } else {
      System.out.println("Xは配列に含まれていません。");
    }
  }
}


class BinarySearch {

  private int[] array; // 配列Aを保持するフィールド

  BinarySearch(int[] A) {
    // コンストラクタ
    this.array = A;
  }

  // 二部探索を行うメソッド
  public int binarySearch(int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int middle = (left + right) / 2;
      if (array[middle] == target) {
        return middle; // ターゲットが見つかったインデックスを返す
      } else if (array[middle] < target) {
        left = middle + 1; // ターゲットは右側にある
      } else {
        right = middle - 1; // ターゲットは左側にある
      }
    }
    return -1; // ターゲットが見つからなかった場合
  }
}

