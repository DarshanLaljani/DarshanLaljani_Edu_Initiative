public class ShapeFactory {
    public static Shape createShape(String shapeType, double... dimensions) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                if (dimensions.length != 1) {
                    throw new IllegalArgumentException("Circle requires 1 dimension (radius).");
                }
                return new Circle(dimensions[0]);

            case "square":
                if (dimensions.length != 1) {
                    throw new IllegalArgumentException("Square requires 1 dimension (side).");
                }
                return new Square(dimensions[0]);

            case "rectangle":
                if (dimensions.length != 2) {
                    throw new IllegalArgumentException("Rectangle requires 2 dimensions (length, width).");
                }
                return new Rectangle(dimensions[0], dimensions[1]);

            default:
                throw new IllegalArgumentException("Unknown shape type.");
        }
    }
}
