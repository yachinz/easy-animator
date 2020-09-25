package cs5004.animator.model.shapes.color;

/**
 * This is an abstract color class. And abstract color class has red, green and blue rgb color.
 */
public abstract class AbsColor implements Color {

  // Red.
  protected int rgbR;
  // Green.
  protected int rgbG;
  // Blue.
  protected int rgbB;

  /**
   * Get the red value.
   *
   * @return the red value
   */
  @Override
  public int getRed() {
    return rgbR;
  }

  /**
   * Get the green value.
   *
   * @return the green value
   */
  @Override
  public int getGreen() {
    return rgbG;
  }

  /**
   * Get the blue value.
   *
   * @return the blue value
   */
  @Override
  public int getBlue() {
    return rgbB;
  }

  /**
   * Get the color.
   *
   * @return the color
   */
  @Override
  public String toString() {
    return "(" + rgbR + "," + rgbG + "," + rgbB + ")";
  }
}
