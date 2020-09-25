package cs5004.animator.model.shapes;

import cs5004.animator.model.shapes.color.Color;
import cs5004.animator.model.shapes.color.RGBColor;

/**
 * This is an abstract shape class, an abstract shape class has an color and a type.
 */
public abstract class AbsShape implements Shapes {

  protected Color color;

  protected String type;

  protected double width;

  protected double height;

  /**
   * Initialize some given data.
   * @param x position x
   * @param y position y
   * @param r red
   * @param g green
   * @param b blue
   * @throws IllegalArgumentException if input is illegal
   */
  public AbsShape(double x, double y, double r, double g, double b)
      throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Illegal Input!!!");
    }
    this.width = x;
    this.height = y;
    this.color = new RGBColor((int) r, (int) g, (int) b);
  }

  /**
   * Get the color.
   *
   * @return the color
   */
  @Override
  public String getColor() {
    return this.color.toString();
  }

  /**
   * Get the type.
   *
   * @return the type
   */
  @Override
  public String getType() {
    return this.type;
  }

  /**
   * Change the color.
   *
   * @param otherColor new color
   */
  @Override
  public void changeColor(Color otherColor) {
    this.color = otherColor;
  }

}
