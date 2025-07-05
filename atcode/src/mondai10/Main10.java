package mondai10;

import java.util.Scanner;

public class Main10 {

  static int[] tree;
  static int size;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();


    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
    }

    // セグメントツリー構築
    size = 1;
    while (size < N)
      size <<= 1;
    tree = new int[size * 2];

    build(A);
    // 日数を入力
    int D = scanner.nextInt();

    // クエリ処理
    for (int i = 0; i < D; i++) {
      int L = scanner.nextInt();
      int R = scanner.nextInt();

      // 左側 [0, L-2] と右側 [R, N-1]
      int leftMax = 0;
      int rightMax = 0;

      if (L > 1) {
        leftMax = query(0, 0, size - 1, 0, L - 2);
      }
      if (R < N) {
        rightMax = query(0, 0, size - 1, R, N - 1);
      }

      System.out.println(Math.max(leftMax, rightMax));
    }

    scanner.close();
  }

  static void build(int[] A) {
    // 葉に値をセット
    for (int i = 0; i < A.length; i++) {
      tree[size - 1 + i] = A[i];
    }
    // 下から構築
    for (int i = size - 2; i >= 0; i--) {
      tree[i] = Math.max(tree[i * 2 + 1], tree[i * 2 + 2]);
    }
  }

  static int query(int node, int l, int r, int ql, int qr) {
    if (qr < l || r < ql) {
      return 0; // 範囲外
    }
    if (ql <= l && r <= qr) {
      return tree[node];
    }
    int mid = (l + r) / 2;
    int left = query(node * 2 + 1, l, mid, ql, qr);
    int right = query(node * 2 + 2, mid + 1, r, ql, qr);
    return Math.max(left, right);
  }
}
