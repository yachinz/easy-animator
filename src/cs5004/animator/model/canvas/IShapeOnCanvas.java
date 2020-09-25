package cs5004.animator.model.canvas;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This interface represents a shape on a canvas.
 */
public interface IShapeOnCanvas {

  /**
   * Get a hash map that stores the animation time line for this shape.
   *
   * @return a hash map that stores time and status
   */
  LinkedHashMap<Integer, Double[]> getAnimation();


  /**
   * Add a animation action for this shape.
   *
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
  void addAnimation(int fromT, double fromX, double fromY, double fromW, double fromH,
      double fromR, double fromG, double fromB, int toT, double toX,
      double toY, double toW, double toH, double toR,
      double toG, double toB);

  /**
   * Get the data of this shape for specific frame.
   *
   * @param frame ticks
   * @return the data of this shape for specific frame
   */
  Double[] getFrame(int frame);


  /**
   * Get the color of this shape.
   *
   * @return the color of this shape
   */
  String getColor();


  /**
   * Get the type of this shape.
   *
   * @return the type of this shape
   */
  String getType();


  /**
   * Get the appear time of this shape.
   *
   * @return the appear time of this shape
   */
  int getAppears();

  /**
   * Get the disappear time of this shape.
   *
   * @return the disappear time of this shape
   */
  int getDisappears();

  /**
   * Change the position of this shape.
   *
   * @param toX destination x
   * @param toY destination y
   */
  void changePosition(double toX, double toY);


  /**
   * Set the appear time.
   *
   * @param time time
   */
  void setAppear(int time);


  /**
   * Set the disappear time.
   *
   * @param time time
   */
  void setDisappear(int time);

  /**
   * Get the initial content wit speed for this shape.
   *
   * @param speed ticks/ second
   * @return the initial content wit speed for this shape
   */
  HashMap<Integer, String> getTimeLine(int speed);

  /**
   * Get the animation timeline from this shape.
   *
   * @return the animation timeline
   */
  HashMap<Integer, String> getTimeLine();

  /**
   * Get the initial content without speed for this shape.
   *
   * @param speed ticks/ second
   * @return the textual animation
   */
  String statusSpeed(double speed);


}
