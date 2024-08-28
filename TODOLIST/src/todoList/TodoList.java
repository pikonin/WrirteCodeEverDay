package todoList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class TodoList {

  private static ArrayList<String> tasks = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean running = true;
    while (running) {
      // menu
      showMenu();

      int choice = getUserChoice();

      switch (choice) {
        case 1:
          addTask();
          break;
        case 2:
          showTasks();
          break;
        case 3:
          removeTask();
          break;
        case 4:
          running = false;
          break;
        default:
          System.out.println("無効な選択です。もう一度お試しください。");
      }

    }

    System.out.println("アプリを終了します。");
  }


  /**
   * menumoniter
   */
  private static void showMenu() {
    System.out.println("\n--- To-Do リスト アプリ ---");
    System.out.println("1. タスクを追加する");
    System.out.println("2. タスクを表示する");
    System.out.println("3. タスクを削除する");
    System.out.println("4. 終了する");
    System.out.print("選択肢を入力してください: ");
  }

  /**
   * @return ユーザーが入力した行全体を取得
   */
  private static int getUserChoice() {
    return Integer.parseInt(scanner.nextLine());
  }

  /**
   * タスクの追加
   */
  private static void addTask() {

    System.out.print("追加するタスクを入力してください: ");
    String task = scanner.nextLine();
    tasks.add(task);
    System.out.println("タスクが追加されました。");
  }

  /**
   * タスクの参照
   */
  private static void showTasks() {
    if (tasks.isEmpty()) {
      System.out.println("タスクがありません。");
    } else {
      System.out.println("\n--- 現在のタスク ---");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println((i + 1) + ". " + tasks.get(i));
      }
    }
  }

  /**
   * タスクの削除
   */
  private static void removeTask() {
    showTasks();
    if (!tasks.isEmpty()) {
      System.out.print("削除するタスクの番号を入力してください: ");
      int taskNumber = Integer.parseInt(scanner.nextLine());
      if (taskNumber > 0 && taskNumber <= tasks.size()) {
        tasks.remove(taskNumber - 1);
        System.out.println("タスクが削除されました。");
      } else {
        System.out.println("無効なタスク番号です。");
      }
    }
  }
}
