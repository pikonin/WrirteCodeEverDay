package factorypattern;

public class ShapeFactory {
  final static String CIRCLE = "CIRCLE";
  final static String TRIANGLE = "TRIANGLE";
  final static String RECTANGLE = "RECTANGLE";

  public static Shape getShape(String shapeType) {
    // shapeTypeがnullの場合はnullを返す
    if (shapeType == null) {
      return null;
    }

    // shapeTypeの値によって返す図形が変わる
    switch (shapeType.toUpperCase()) {
      case CIRCLE:
        return new Circle();
      case TRIANGLE:
        return new Triangle();
      case RECTANGLE:
        return new Rectangle();
      default:
        // shapeTypeがCIRCLE, TRIANGLE, RECTANGLE以外の場合は例外をスローする
        throw new IllegalArgumentException("Unknown shape type: " + shapeType);
    }

  }
}
