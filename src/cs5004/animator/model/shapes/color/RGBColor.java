package cs5004.animator.model.shapes.color;

/**
 * This class represents a rgb color class. A rgb color class has red, green and blue rgb color.
 */
public class RGBColor extends AbsColor {

  /**
   * Constructs a rgb color object with given value.
   *
   * @param r red
   * @param g green
   * @param b blue
   * @throws IllegalArgumentException if input is illegal
   */
  public RGBColor(int r, int g, int b) throws IllegalArgumentException {
    if (r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("Illegal color input!!! "
          + "Please try number between 0 and 255.");
    }
    this.rgbR = r;
    this.rgbG = g;
    this.rgbB = b;
  }
}
