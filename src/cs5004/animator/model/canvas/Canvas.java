package cs5004.animator.model.canvas;

import cs5004.animator.model.shapes.Oval;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.Shapes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents canvas. A canvas has some shapes on it and a bound. In this class, user can
 * add shapes, set bound, get bound, get the max frame, get two kinds of data to produce the
 * animation view and textual view. This class linked the IAnimatorModelImpl and the
 * IShapeOnCanvasImpl class.
 */
public class Canvas implements ICanvas {

  private final LinkedHashMap<String, IShapeOnCanvas> shapes;
  private final LinkedList<Integer> bound;

  /**
   * Constructs a  Canvas class and initialize shapes and bound.
   */
  public Canvas() {
    shapes = new LinkedHashMap<>();
    bound = new LinkedList<>();

  }

  /**
   * Get the bound of canvas.
   *
   * @return the bound
   */
  @Override
  public LinkedList<Integer> getBound() {
    return this.bound;
  }


  /**
   * Add a shape into this canvas.
   *
   * @param name the name of this shape
   * @param type the type of this shape
   * @throws IllegalArgumentException if input name exists in the shapes
   */
  @Override
  public void addShapes(String name, String type) throws IllegalArgumentException {
    if (shapes.containsKey(name)) {
      throw new IllegalArgumentException("Please don't input a repeat name!!!!");
    }
    Shapes newShape;
    switch (type) {
      case "rectangle":
        newShape = new Rectangle(0, 0, 0, 0, 0);
        break;
      case "ellipse":
        newShape = new Oval(0, 0, 0, 0, 0);
        break;
      default:
        throw new IllegalArgumentException("No such shape");
    }

    shapes.put(name, new IShapeOnCanvasImpl(newShape));
  }


  /**
   * Set the bound. Since the size of swing canvas could only be set as int, I stored int here.
   *
   * @param x      top left x position
   * @param y      top left y position
   * @param width  width
   * @param height height
   */
  @Override
  public void setBound(double x, double y, double width, double height) {
    this.bound.add((int) x);
    this.bound.add((int) y);
    this.bound.add((int) width);
    this.bound.add((int) height);
  }


  /**
   * Get the animation frame.
   *
   * @param frame tick
   * @return the animation frame. It is a LinkedHashMap whose key stores name and type, and the
   *        value stores 7 double in a Double array.
   *        And they are the value of position, scale and color.
   * @throws IllegalStateException if we haven't finished add animation action for all shape.
   */
  @Override
  public LinkedHashMap<String, Double[]> getAnimationFrame(int frame)
      throws IllegalStateException {
    LinkedHashMap<String, Double[]> newFrame = new LinkedHashMap<>();
    for (String keys : shapes.keySet()) {
      IShapeOnCanvas shape = shapes.get(keys);
      if (shape.getAppears() == 0) {
        throw new IllegalStateException("Your input is not completed!!!");
      }
      if (frame < shape.getAppears() || frame > shape.getDisappears()) {
        continue;
      }
      newFrame.put(keys + " " + shape.getType(), shape.getFrame(frame));
    }
    return newFrame;
  }

  /**
   * Get textual animation content with given speed.
   *
   * @param speed speed
   * @return textual animation content
   * @throws IllegalStateException if we haven't finished add animation action for all shape.
   */
  @Override
  public String getTextualAnimation(int speed) throws IllegalStateException {
    HashMap<Integer, String> txtAnimation = new HashMap<>();
    StringBuilder output = new StringBuilder();
    if (shapes.isEmpty()) {
      return "No Animation!";
    }
    // Add all shapes information. And add animation information into txtAnimation.
    output.append("Shapes:\n");
    for (String name : shapes.keySet()) {
      IShapeOnCanvas shape = shapes.get(name);
      if (shape.getAppears() == 0) {
        throw new IllegalStateException("Your input is not completed!!!");
      }
      output.append("Name: ").append(name).append("\n")
          .append(shape.statusSpeed(speed)).append("\n\n");
      HashMap<Integer, String> timeLine = shape.getTimeLine(speed);
      for (Integer i : timeLine.keySet()) {
        String content = timeLine.get(i).trim();
        String[] sArray = content.split("\n");
        StringBuilder newContent = new StringBuilder();
        for (String s : sArray) {
          newContent.append("Shape ").append(name).append(" ")
              .append(s).append("\n");
        }
        if (txtAnimation.containsKey(i)) {
          String tempContent = txtAnimation.get(i);
          txtAnimation.put(i, tempContent + newContent);
          continue;
        }
        txtAnimation.put(i, newContent.toString());
      }
    }

    // Out put
    Object[] key = (txtAnimation.keySet()).toArray();
    Arrays.sort(key);
    for (Object o : key) {
      output.append(txtAnimation.get(o));
    }
    return output.toString().trim();
  }

  /**
   * Add a animation action for a shape.
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
  @Override
  public void addAnimation(String name, int fromT, double fromX, double fromY,
      double fromW, double fromH, double fromR, double fromG, double fromB, int toT,
      double toX, double toY, double toW, double toH, double toR,
      double toG, double toB) {
    // shape can not be null!!!!!
    IShapeOnCanvas shape = shapes.get(name);
    shape.addAnimation(fromT, fromX, fromY, fromW, fromH, fromR, fromG, fromB,
        toT, toX, toY, toW, toH, toR, toG, toB);
  }

  /**
   * Get the max frame.
   *
   * @return the max frame
   */
  @Override
  public int getMaxFrame() {
    int maxFrame = 0;
    for (String name : shapes.keySet()) {
      maxFrame = Math.max(maxFrame, shapes.get(name).getDisappears());
    }
    return maxFrame;
  }

  @Override
  public LinkedHashMap<String, IShapeOnCanvas> getShapes() {
    return this.shapes;
  }

  /**
   * Get textual view with ticks.
   *
   * @return textual view with ticks
   */
  @Override
  public String toString() {
    HashMap<Integer, String> txtAnimation = new HashMap<>();
    StringBuilder output = new StringBuilder();
    if (shapes.isEmpty()) {
      return "No Animation!";
    }
    // Add all shapes information. And add animation information into txtAnimation.
    output.append("Shapes:\n");
    for (String name : shapes.keySet()) {
      IShapeOnCanvas shape = shapes.get(name);
      output.append("Name: ").append(name).append("\n")
          .append(shape.toString()).append("\n\n");
      HashMap<Integer, String> timeLine = shape.getTimeLine();
      for (Integer i : timeLine.keySet()) {
        String content = timeLine.get(i).trim();
        String[] sArray = content.split("\n");
        StringBuilder newContent = new StringBuilder();
        for (String s : sArray) {
          newContent.append("Shape ").append(name).append(" ")
              .append(s).append("\n");
        }
        if (txtAnimation.containsKey(i)) {
          String tempContent = txtAnimation.get(i);
          txtAnimation.put(i, tempContent + newContent);
          continue;
        }
        txtAnimation.put(i, newContent.toString());
      }
    }

    Object[] key = (txtAnimation.keySet()).toArray();
    Arrays.sort(key);
    for (Object o : key) {
      output.append(txtAnimation.get(o));
    }
    return output.toString().trim();
  }
}
