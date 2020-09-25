package cs5004.animator.util;

import cs5004.animator.model.IAnimatorModel;

/**
 * This class represents a builder. In this class, user can parse some data to the model.
 */
public final class Builder implements AnimationBuilder<IAnimatorModel> {

  private final IAnimatorModel model;

  /**
   * Constructs a Builder object with given value.
   *
   * @param model the model
   */
  public Builder(IAnimatorModel model) {
    this.model = model;
  }

  /**
   * Get the model.
   *
   * @return model
   */
  @Override
  public IAnimatorModel build() {
    return model;
  }

  /**
   * Set bound of canvas.
   *
   * @param x      The leftmost x value
   * @param y      The topmost y value
   * @param width  The width of the bounding box
   * @param height The height of the bounding box
   * @return this object
   */
  @Override
  public AnimationBuilder<IAnimatorModel> setBounds(int x, int y, int width, int height) {
    model.setBound(x, y, width, height);
    return this;
  }

  /**
   * Add a shape in model.
   *
   * @param name The unique name of the shape to be added. No shape with this name should already
   *             exist.
   * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
   *             shapes is unspecified, but should include "ellipse" and "rectangle" as a minimum.
   * @return this object
   */
  @Override
  public AnimationBuilder<IAnimatorModel> declareShape(String name, String type) {
    model.addShapes(name, type);
    return this;
  }


  /**
   * Add a shape's action in model.
   *
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   * @return this object
   */
  @Override
  public AnimationBuilder<IAnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
      int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
      int b2) {
    model.addAnimation(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
    return this;
  }
}
