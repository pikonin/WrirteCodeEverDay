package executorServic;

public class Task implements Runnable {
  private int taskId;

  public Task(int taskId) {
    this.taskId = taskId;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Task ID: " + this.taskId + " Perform task during: " + i + " iteration");
      try {
        Thread.sleep(1000);// 1秒スリーブ
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // 割り込みフラグを復元
        System.out.println("Thread" + taskId + " was interrupted");
        e.printStackTrace();
      }
    }
    System.out.println("Task " + taskId + " is completed");
  }
}
