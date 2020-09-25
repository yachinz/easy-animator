package cs5004.animator.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * This class represents a DrawingPanel class. It has a list of shapes. When a user changes these
 * shapes, it will be repaint on the canvas.
 */
public class DrawingPanel extends JPanel {

  private final LinkedList<Shape> myShape;


  /**
   * Constructs a DrawingPanel object with given value.
   *
   * @param width  width of canvas
   * @param height height of canvas
   */
  public DrawingPanel(int width, int height) {
    super();
    setPreferredSize(new Dimension(width, height));
    myShape = new LinkedList<>();
  }

  /**
   * Add a new shape in list and draw all shapes.
   *
   * @param s shape
   */
  public void drawShape(Shape s) {
    myShape.add(s);
  }

  /**
   * Draw all shapes in list.
   *
   * @param g graph
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graph = (Graphics2D) g;
    for (Shape i : myShape) {
      i.draw(graph);
    }
  }

  /**
   * Clear all shapes and canvas.
   */
  public void clear() {
    myShape.clear();
    repaint();
  }


}
