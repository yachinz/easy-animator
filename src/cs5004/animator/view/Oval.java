package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D.Double;

/**
 * This class represents a oval shape. An oval shape has position, scale and color.
 */
public class Oval extends AbstractViewShape {

  private final double radiusX;
  private final double radiusY;

  /**
   * Constructs an oval object with given value.
   *
   * @param x       x position
   * @param y       y position
   * @param radiusX scale x
   * @param radiusY scale y
   * @param color   color
   */
  public Oval(double x, double y, double radiusX, double radiusY, Color color) {
    super(x, y, color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  /**
   * Draw a 2d oval.
   *
   * @param g a 2d graph
   */
  @Override
  public void draw(Graphics2D g) {
    g.setColor(color);
    g.fill(new Double(x, y, radiusX, radiusY));
  }
}
