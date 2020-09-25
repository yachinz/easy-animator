package cs5004.animator.model.canvas;

/**
 * This class represents a 2D position class. A 2D position class has a x and a y position.
 */
public class Position2DImpl implements Position2D {

  // Position x.
  private final double x;
  // Position y.
  private final double y;

  /**
   * Constructs a position2DImpl object with given value.
   *
   * @param x position x
   * @param y position y
   */
  public Position2DImpl(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Get x position.
   *
   * @return x position
   */
  @Override
  public double getX() {
    return this.x;
  }

  /**
   * Get y position.
   *
   * @return y position
   */
  @Override
  public double getY() {
    return this.y;
  }

  /**
   * Get position.
   *
   * @return position
   */
  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }
}
