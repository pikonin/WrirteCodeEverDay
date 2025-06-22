package main;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 画面から入力
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    input.close();

    int area = N * N;

    // 結果の出力
    System.out.println(area);
  }
}
