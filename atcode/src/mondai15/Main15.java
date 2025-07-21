package mondai15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main15 {

  public static void main(String[] args) throws IOException {

    // 高速入力
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // カードの枚数を入力
    int N = Integer.parseInt(st.nextToken());

    // 配列を設定
    int[] A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    // コピーしてソートしてユニークに
    int[] B = A.clone();
    Arrays.sort(B);

    // 値 → 圧縮値
    Map<Integer, Integer> compressMap = new HashMap<>();
    int id = 1;
    compressMap.put(B[0], id);
    for (int i = 1; i < N; i++) {
      if (B[i] != B[i - 1]) {
        id++;
        compressMap.put(B[i], id);
      }
    }

    // 元の順序に対応して出力
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(compressMap.get(A[i]));
      if (i != N - 1)
        sb.append(" ");
    }
    System.out.println(sb);
  }
}
