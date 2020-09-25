package cs5004.animator.model.canvas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * This is the interface of canvas.
 */
public interface ICanvas {

  /**
   * Get the bound of canvas.
   *
   * @return the bound of canvas
   */
  LinkedList<Integer> getBound();

  /**
   * Add a shape in canvas, default position, scale and color are all 0.
   *
   * @param name the name of this shape
   * @param type the type of this shape
   * @throws IllegalArgumentException if input is illegal
   */
  void addShapes(String name, String type)
      throws IllegalArgumentException;

  /**
   * Set the bound of canvas.
   *
   * @param x      top left x position
   * @param y      top left y position
   * @param width  width
   * @param height height
   */
  void setBound(double x, double y, double width, double height);

  /**
   * Get shapes data from a specific frame.
   *
   * @param frame tick
   * @return shapes data
   */
  LinkedHashMap<String, Double[]> getAnimationFrame(int frame);

  /**
   * Get the textual view of shapes with given speed.
   *
   * @param speed speed
   * @return textual view
   */
  String getTextualAnimation(int speed);

  /**
   * Add animation action into a specific shape.
   *
   * @param name  name of shape
   * @param fromT from time
   * @param fromX from x position
   * @param fromY from y position
   * @param fromW from width
   * @param fromH from height
   * @param fromR from red
   * @param fromG from green
   * @param fromB from blue
   * @param toT   to time
   * @param toX   to x position
   * @param toY   to y position
   * @param toW   to width
   * @param toH   to height
   * @param toR   to red
   * @param toG   to green
   * @param toB   to blue
   */
  void addAnimation(String name, int fromT, double fromX, double fromY,
      double fromW, double fromH, double fromR, double fromG, double fromB,
      int toT, double toX, double toY,
      double toW, double toH, double toR, double toG, double toB);

  /**
   * Get the max frame in canvas animation.
   *
   * @return the max frame
   */
  int getMaxFrame();


  LinkedHashMap<String, IShapeOnCanvas> getShapes();

}
