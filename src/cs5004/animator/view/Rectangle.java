package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * This class represents a rectangle shape. A rectangle shape has position, scale and color.
 */
public class Rectangle extends AbstractViewShape {

  private final double width;
  private final double height;


  /**
   * Constructs an rectangle object with given value.
   *
   * @param x      x position
   * @param y      y position
   * @param width  scale x
   * @param height scale y
   * @param color  color
   */
  public Rectangle(double x, double y, double width, double height, Color color) {
    super(x, y, color);
    this.width = width;
    this.height = height;
  }

  /**
   * Draw a 2d rectangle.
   *
   * @param g a 2d graph
   */
  @Override
  public void draw(Graphics2D g) {
    g.setColor(color);
    g.fill(new Rectangle2D.Double(x, y, width, height));
  }
}
