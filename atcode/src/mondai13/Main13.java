package mondai13;

import java.util.Scanner;

public class Main13 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    long count = 0;
    int r = 0;

    for (int l = 0; l < N; l++) {
      while (r < N && A[r] - A[l] <= K) {
        r++;
      }
      count += r - l - 1;
    }

    System.out.println(count);

    sc.close();
  }
}
