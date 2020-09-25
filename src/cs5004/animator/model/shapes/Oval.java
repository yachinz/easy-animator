package cs5004.animator.model.shapes;

/**
 * This class represents an oval shape. An oval shape has color, type, radiusX, radiusY.
 */
public class Oval extends AbsShape {

  /**
   * Constructs a oval object with given values.
   *
   * @param radiusX x radius
   * @param radiusY y radius
   * @param r       rgb red
   * @param g       rgb green
   * @param b       rgb blue
   * @throws IllegalArgumentException if input is illegal
   */
  public Oval(double radiusX, double radiusY, double r, double g, double b)
      throws IllegalArgumentException {
    super(radiusX, radiusY, r, g, b);
    this.type = "ellipse";
  }


  /**
   * Get the scale.
   *
   * @return scale
   */
  @Override
  public String getScale() {
    return "X radius: " + this.width +
        ", Y radius: " + this.height;
  }

  /**
   * Change the scale.
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
