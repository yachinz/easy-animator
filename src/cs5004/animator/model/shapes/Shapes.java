package cs5004.animator.model.shapes;

import cs5004.animator.model.shapes.color.Color;

/**
 * This represents different kinds of shapes.
 */
public interface Shapes {

  /**
   * Get the type of the shape.
   *
   * @return the type of the shape
   */
  String getType();

  /**
   * Get the color of the shape.
   *
   * @return the color of the shape
   */
  String getColor();

  /**
   * Get the scale of the shape.
   *
   * @return the scale of the shape
   */
  String getScale();

  /**
   * Change the color of a shape.
   *
   * @param otherColor the new color
   */
  void changeColor(Color otherColor);

  /**
   * Change the scale of a shape.
   *
   * @param x scale x
   * @param y scale y
   */
  void changeScale(double x, double y);


}
