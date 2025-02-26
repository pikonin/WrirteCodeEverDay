package executorServic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

  // スレッドプールのサイズ
  final static int POOL_SIZE = 5;

  public static void main(String[] args) {
    // ExcuterServiceを使って5つのスレッドを作成
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    // 5つのタスクを実行
    for (int i = 0; i < 5; i++) {
      Task task = new Task(i);
      executorService.execute(task);
    }
    executorService.shutdown();
  }
}
