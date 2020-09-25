package cs5004.animator.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * This class represents an AnimationView. An animation view has a drawing panel. In this class,
 * user can draw rectangle and oval.
 */
public class AnimationView extends JFrame implements IAnimationView {

  private DrawingPanel drawPanel;

  /**
   * Constructs a AnimationView object.
   */
  public AnimationView() {
    super();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /**
   * Clear all shapes on panel.
   */
  @Override
  public void clear() {
    drawPanel.clear();
  }


  /**
   * Set the size of canvas.
   *
   * @param x width
   * @param y height
   */
  @Override
  public void setCanvasSize(int x, int y) {

    setSize(x, y);
    drawPanel = new DrawingPanel(x, y);
    JScrollPane scrollPane = new JScrollPane(drawPanel);
    add(scrollPane);
    setVisible(true);
  }

  /**
   * Draw a shape with given value.
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
  @Override
  public void draw(String type, double x, double y, double w,
      double h, double r, double g, double b) {
    Shape s;
    switch (type) {
      case "rectangle":
        s = new Rectangle(x, y, w, h, new Color((int) r, (int) g, (int) b));
        break;
      case "oval":
        s = new Oval(x, y, w, h, new Color((int) r, (int) g, (int) b));
        break;
      default:
        throw new IllegalArgumentException("Your shape is wrong!!!");
    }
    drawPanel.drawShape(s);

  }
}
