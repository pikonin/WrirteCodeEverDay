package factorypattern;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter shape type (circle, rectangle, triangle): ");
    String shapeType = scanner.nextLine();

    try {
      // staticメソッドを呼び出すため、インスタンスを生成せずに呼び出せる。
      Shape shape = ShapeFactory.getShape(shapeType);
      shape.draw();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } finally {
      scanner.close();
    }


  }

}
