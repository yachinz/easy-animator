package cs5004.animator.view;

import java.util.List;

/**
 * This is a interface for animation view.
 */
public interface IAnimationView {

  /**
   * draw a shape on canvas.
   *
   * @param type the type of shape
   * @param x    x position
   * @param y    y position
   * @param w    width
   * @param h    height
   * @param r    red
   * @param g    green
   * @param b    blue
   */
  void draw(String type, double x, double y, double w, double h, double r, double g, double b);

  /**
   * clear the view.
   */
  void clear();

  /**
   * Set canvas size.
   *
   * @param x width
   * @param y height
   */
  void setCanvasSize(int x, int y);

}
