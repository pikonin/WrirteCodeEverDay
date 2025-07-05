package mondai9;

import java.util.Scanner;

public class Main9 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 入力
    // 縦のマスの数
    int height = scanner.nextInt();
    // 横のマスの数
    int width = scanner.nextInt();
    // 雪が降る日数
    int days = scanner.nextInt();

    // Gridインスタンス生成
    Grid grid = new Grid(height, width);

    // 日数分、降雪領域を登録
    for (int i = 0; i < days; i++) {
      int xA = scanner.nextInt();
      int yB = scanner.nextInt();
      int xC = scanner.nextInt();
      int yD = scanner.nextInt();
      grid.addSnow(xA, yB, xC, yD);
    }

    scanner.close();

    // 累積和を計算
    grid.computeCumulativeSum();

    // 出力
    grid.printGrid();
  }
}


class Grid {
  private final int height;
  private final int width;
  private final int[][] diff;

  public Grid(int height, int width) {
    this.height = height;
    this.width = width;
    this.diff = new int[height + 2][width + 2];
  }

  // 差分配列に雪を追加
  public void addSnow(int xA, int yB, int xC, int yD) {
    diff[xA][yB]++;
    diff[xA][yD + 1]--;
    diff[xC + 1][yB]--;
    diff[xC + 1][yD + 1]++;
  }

  // 累積和を計算
  public void computeCumulativeSum() {
    // 横方向
    for (int i = 1; i <= height; i++) {
      for (int j = 1; j <= width; j++) {
        diff[i][j] += diff[i][j - 1];
      }
    }
    // 縦方向
    for (int j = 1; j <= width; j++) {
      for (int i = 1; i <= height; i++) {
        diff[i][j] += diff[i - 1][j];
      }
    }
  }

  // 結果を出力
  public void printGrid() {
    for (int i = 1; i <= height; i++) {
      for (int j = 1; j <= width; j++) {
        System.out.print(diff[i][j]);
        if (j != width) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
