package cs5004.animator.view;

import java.awt.Color;

/**
 * This is an abstract view shape class. An abstract view shape class has a x position, a y
 * position, and a color.
 */
public abstract class AbstractViewShape implements Shape {

  protected double x;
  protected double y;
  protected Color color;

  /**
   * Initialize all given data.
   *
   * @param x     x position
   * @param y     y position
   * @param color color of shape
   */
  public AbstractViewShape(double x, double y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

}
