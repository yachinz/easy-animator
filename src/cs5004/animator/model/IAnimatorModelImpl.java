package cs5004.animator.model;

import cs5004.animator.model.canvas.Canvas;
import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.shapes.Shapes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a regular animator model, an animator model has a canvas. And in this
 * class, we can add shape, set and get canvas bound. And user can also add animation , get two
 * kinds of animations by calling the method.
 */
public class IAnimatorModelImpl implements IAnimatorModel {

  // The canvas, it has shapes on it.
  private final ICanvas canvas;

  /**
   * Constructs a model. Initialize canvas.
   */
  public IAnimatorModelImpl() {
    this.canvas = new Canvas();
  }


  /**
   * Add a shape on the canvas.
   *
   * @param name the name of shape
   * @param type the type of shape
   * @throws IllegalArgumentException if the name doesn't exist or already exist.
   */
  @Override
  public void addShapes(String name, String type)
      throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Your name input is illegal!!!");
    }
    canvas.addShapes(name, type);
  }


  /**
   * Add animation action to the model.
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
   * @param toH   to height
   * @param toR   to red
   * @param toG   to green
   * @param toB   to blue
   * @throws IllegalArgumentException if input is illegal
   */
  @Override
  public void addAnimation(String name, int fromT, double fromX, double fromY,
      double fromW, double fromH, double fromR, double fromG, double fromB, int toT
      , double toX, double toY
      , double toW, double toH, double toR, double toG, double toB)
      throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Your input is illegal!!!");
    }
    canvas.addAnimation(name, fromT, fromX, fromY, fromW, fromH, fromR, fromG, fromB,
        toT, toX, toY, toW, toH, toR, toG, toB);
  }


  /**
   * Set the bound of canvas.
   *
   * @param x      top left x position
   * @param y      top left y position
   * @param width  width of canvas
   * @param height height of canvas
   * @throws IllegalArgumentException if input is illegal
   */
  @Override
  public void setBound(double x, double y, double width, double height)
      throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Your input is illegal!!!");
    }
    canvas.setBound((int) x, (int) y, (int) width, (int) height);
  }

  /**
   * Get the bound of canvas.
   *
   * @return a linked list of bound
   */
  @Override
  public LinkedList<Integer> getBound() {
    return canvas.getBound();
  }


  /**
   * Get all shapes' data that on the canvas at a specific frame.
   *
   * @param frame ticks
   * @return shapes' data and they are in the order of their add shape sequence
   * @throws IllegalArgumentException if frame is not positive
   */
  public LinkedHashMap<String, Double[]> getAnimationFrame(int frame)
      throws IllegalArgumentException {
    if (frame < 1) {
      throw new IllegalArgumentException("Your input is illegal!!!!!!");
    }
    return canvas.getAnimationFrame(frame);
  }


  /**
   * Get a textualView with given speed.
   *
   * @param speed ticks per second
   * @return a textual view
   * @throws IllegalArgumentException if speed is not positive
   */
  @Override
  public String getTextualAnimation(int speed) throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("Your input is illegal!!!!");
    }
    return canvas.getTextualAnimation(speed);
  }

  /**
   * Get the status now, including animation information.
   *
   * @return the status now with out speed
   */
  @Override
  public String toString() {
    return canvas.toString();
  }

  /**
   * Get the max frame in shapes.
   *
   * @return the max frame
   */
  @Override
  public int getMaxFrame() {
    return canvas.getMaxFrame();
  }

  @Override
  public ICanvas getCanvas() {
    return this.canvas;
  }

}
