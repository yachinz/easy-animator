package cs5004.animator.model;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.shapes.Shapes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This interface represents a easy animator model.
 */
public interface IAnimatorModel {

  /**
   * Add shapes to the model.
   *
   * @param name the name of shape
   * @param type the type of shape
   * @throws IllegalArgumentException when input value is illegal
   */
  void addShapes(String name, String type)
      throws IllegalArgumentException;

  /**
   * Get the bound of canvas.
   *
   * @return the bound
   */
  LinkedList<Integer> getBound();

  /**
   * Set a bound.
   *
   * @param x      top left x position
   * @param y      top left y position
   * @param width  width of canvas
   * @param height height of canvas
   * @throws IllegalArgumentException if width is not positive or height is not positive
   */
  void setBound(double x, double y, double width, double height) throws IllegalArgumentException;

  /**
   * Get the animation frame.
   *
   * @param frame ticks
   * @return a hashmap that stores the data
   * @throws IllegalArgumentException if frame is not positive
   */
  LinkedHashMap<String, Double[]> getAnimationFrame(int frame) throws IllegalArgumentException;

  /**
   * Get the textual view.
   *
   * @param speed ticks per second
   * @return the textual view with given speed
   */
  String getTextualAnimation(int speed);

  /**
   * Add a animation action into the canvas.
   *
   * @param name  the name of shape
   * @param fromT from ticks
   * @param fromX from x position
   * @param fromY from y position
   * @param fromW from width
   * @param fromH from height
   * @param fromR from red
   * @param fromG from green
   * @param fromB from blue
   * @param toT   to ticks
   * @param toX   to x position
   * @param toY   to y position
   * @param toW   to width
   * @param toH   to hieght
   * @param toR   to red
   * @param toG   to green
   * @param toB   to blue
   * @throws IllegalArgumentException if input is illegal
   */
  void addAnimation(String name, int fromT, double fromX, double fromY,
      double fromW, double fromH, double fromR, double fromG, double fromB,
      int toT, double toX, double toY
      , double toW, double toH, double toR, double toG, double toB) throws IllegalArgumentException;

  /**
   * Get the largest tick of this animation.
   *
   * @return the largest tick
   */
  int getMaxFrame();

  ICanvas getCanvas();
}