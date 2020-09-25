package cs5004.animator.model.shapes;


/**
 * This class represents a rectangle shape. A rectangle shape has color, type, width and height.
 */
public class Rectangle extends AbsShape {

  /**
   * Constructs a rectangle class with given value.
   *
   * @param width  the width
   * @param height the height
   * @param r      rgb red
   * @param g      rgb green
   * @param b      rgb blue
   * @throws IllegalArgumentException if input is illegal
   */
  public Rectangle(double width, double height, int r, int g, int b)
      throws IllegalArgumentException {
    super(width, height, r, g, b);
    this.type = "rectangle";
  }

  /**
   * Get the width.
   *
   * @return the width
   */
  public double getWidth() {
    return this.width;
  }


  /**
   * Get the height.
   *
   * @return the height
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Get the scale.
   *
   * @return the scale
   */
  @Override
  public String getScale() {
    return "Width: " + this.width + ", Height: " + this.height;
  }

  /**
   * Change scale.
   *
   * @param x scale x
   * @param y scale y
   */
  @Override
  public void changeScale(double x, double y) {
    this.width = x;
    this.height = y;
  }

}
