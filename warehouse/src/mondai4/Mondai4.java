package mondai4;

import java.util.Scanner;

public class Mondai4 {

  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);

    // 2進数に変換する値を入力
    int N = input.nextInt();

    input.close();

    // 2進数に変換
    String binary = Integer.toBinaryString(N);

    // 2進数の値を10桁にする.
    String paddedBinary = String.format("%10s", binary).replace(' ', '0');

    // 10桁の2進数の値を出力
    System.out.println(paddedBinary);
  }

}
