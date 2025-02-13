package factorypattern;

/**
 * 長方形を描写するクラス
 */
public class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Rectangle");
  }
}
