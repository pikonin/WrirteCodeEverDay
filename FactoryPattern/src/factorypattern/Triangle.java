package factorypattern;

/**
 * 三角形を描写するクラス
 */
public class Triangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Triangle");
  }

}
