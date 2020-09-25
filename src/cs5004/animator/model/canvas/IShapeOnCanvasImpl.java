package cs5004.animator.model.canvas;

import cs5004.animator.model.shapes.Oval;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.color.Color;
import cs5004.animator.model.shapes.color.RGBColor;
import cs5004.animator.model.shapes.Shapes;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This class represents a shape on canvas. A shape on canvas has a position, a position center , a
 * type, a shape, a initial description, an appears time and a disappears time.
 */
public class IShapeOnCanvasImpl implements IShapeOnCanvas {

  // The position of this shape.
  private Position2D position;
  // The type of shape.
  private final String type;
  // The shape.
  private final Shapes shape;

  private final LinkedHashMap<Integer, Double[]> shapeAnimation;

  // The appear time.
  private int appears = 0;
  // The disappear time.
  private int disappears = 0;


  /**
   * Constructs a IShapeOnCanvasImpl object with given value.
   *
   * @param shape a shape object
   */
  public IShapeOnCanvasImpl(Shapes shape) {
    this.position = new Position2DImpl(0, 0);
    this.shape = shape;
    this.type = shape.getType();
    this.shapeAnimation = new LinkedHashMap<>();
  }

  /**
   * Set the appear time.
   *
   * @param time time
   */
  @Override
  public void setAppear(int time) {
    this.appears = time;
  }


  /**
   * Set the disappear time.
   *
   * @param time time
   */
  @Override
  public void setDisappear(int time) {
    this.disappears = time;
  }


  /**
   * Get the textual view of this shape without speed.
   *
   * @return the textual view of this shape
   */
  @Override
  public HashMap<Integer, String> getTimeLine() {
    HashMap<Integer, String> txtAni = new HashMap<>();
    int tmp = appears;
    for (Integer i : shapeAnimation.keySet()) {
      Double[] end = shapeAnimation.get(i);
      Double[] begin = shapeAnimation.get(tmp);
      if (i == tmp) {
        continue;
      }
      if (Arrays.equals(end, begin)) {
        tmp = i;
        continue;
      }
      if ((begin[0] - end[0]) != 0 || (begin[1] - end[1]) != 0) {
        moveTxtView(txtAni, tmp, begin[0], begin[1], i, end[0], end[1]);
      }
      if ((begin[2] - end[2]) != 0 || (begin[3] - end[3]) != 0) {
        scaleTxtView(txtAni, tmp, begin[2], begin[3], i, end[2], end[3]);
      }
      if ((begin[4] - end[4]) != 0 || (begin[5] - end[5]) != 0
          || (begin[6] - end[6]) != 0) {
        colorTxtView(txtAni, tmp, begin[4], begin[5], begin[6],
            i, end[4], end[5], end[6]);
      }
      tmp = i;
    }
    return txtAni;
  }


  /**
   * Get the textual view of this shape with speed.
   *
   * @param speed ticks/ second
   * @return the textual view of this shape
   */
  @Override
  public HashMap<Integer, String> getTimeLine(int speed) {
    HashMap<Integer, String> txtAni = new HashMap<>();
    int tmp = appears;
    for (Integer i : shapeAnimation.keySet()) {
      Double[] end = shapeAnimation.get(i);
      Double[] begin = shapeAnimation.get(tmp);
      if (i == tmp) {
        continue;
      }
      if (Arrays.equals(end, begin)) {
        tmp = i;
        continue;
      }
      if ((begin[0] - end[0]) != 0 || (begin[1] - end[1]) != 0) {
        moveTxtView(txtAni, tmp, begin[0], begin[1], i, end[0], end[1], speed);
      }
      if ((begin[2] - end[2]) != 0 || (begin[3] - end[3]) != 0) {
        scaleTxtView(txtAni, tmp, begin[2], begin[3], i, end[2], end[3], speed);
      }
      if ((begin[4] - end[4]) != 0 || (begin[5] - end[5]) != 0
          || (begin[6] - end[6]) != 0) {
        colorTxtView(txtAni, tmp, begin[4], begin[5], begin[6],
            i, end[4], end[5], end[6], speed);
      }
      tmp = i;
    }
    return txtAni;
  }


  /**
   * A helper function helps to add data in a hashmap with given speed.
   *
   * @param txtAni textual view
   * @param from   from time
   * @param fromX  from x position
   * @param fromY  from y position
   * @param to     to time
   * @param toX    to x position
   * @param toY    to y position
   * @param speed  speed
   */
  private void moveTxtView(HashMap<Integer, String> txtAni, int from,
      double fromX, double fromY, int to, double toX, double toY, double speed) {
    DecimalFormat df = new DecimalFormat("0.00");
    String actionP = "moves from (" + fromX + ", " + fromY + ") to ("
        + toX + ", " + toY + ") from t = "
        + df.format(from / speed) + " S to t = " + df.format(to / speed) + " S" + "\n";
    txtAni.put(from, actionP);
  }

  /**
   * A helper function helps to add data in a hashmap.
   *
   * @param txtAni textual view per ticks
   * @param from   from time
   * @param fromX  from x position
   * @param fromY  from y position
   * @param to     to time
   * @param toX    to x position
   * @param toY    to y position
   */
  private void moveTxtView(HashMap<Integer, String> txtAni, int from,
      double fromX, double fromY, int to, double toX, double toY) {
    String actionP = "moves from (" + fromX + ", " + fromY + ") to ("
        + toX + ", " + toY + ") from t="
        + from + " to t=" + to + "\n";
    txtAni.put(from, actionP);
  }


  /**
   * A helper function helps to add data inside a hashmap.
   *
   * @param txtAni textual view
   * @param from   from time
   * @param fromR  from red
   * @param fromG  from green
   * @param fromB  from blue
   * @param to     to time
   * @param toR    to red
   * @param toG    to green
   * @param toB    to blue
   */
  private void colorTxtView(HashMap<Integer, String> txtAni, int from,
      double fromR, double fromG, double fromB, int to,
      double toR, double toG, double toB) {
    Color oldColor = new RGBColor((int) fromR, (int) fromG, (int) fromB);
    String colorBegin = oldColor.toString();
    Color newColor = new RGBColor((int) toR, (int) toG, (int) toB);
    String colorEnd = newColor.toString();
    String actionC = "changes color from " + colorBegin + " to "
        + colorEnd + " from t="
        + from + " to t=" + to + "\n";
    if (txtAni.containsKey(from)) {
      String temp = txtAni.get(from);
      temp += actionC;
      txtAni.put(from, temp);
    } else {
      txtAni.put(from, actionC);
    }
  }

  /**
   * A helper function helps to add data inside a hashmap with given speed.
   *
   * @param txtAni textual view
   * @param from   from time
   * @param fromR  from red
   * @param fromG  from green
   * @param fromB  from blue
   * @param to     to time
   * @param toR    to red
   * @param toG    to green
   * @param toB    to blue
   * @param speed  ticks/second
   */
  private void colorTxtView(HashMap<Integer, String> txtAni, int from,
      double fromR, double fromG, double fromB, int to,
      double toR, double toG, double toB, double speed) {
    DecimalFormat df = new DecimalFormat("0.00");
    Color oldColor = new RGBColor((int) fromR, (int) fromG, (int) fromB);
    String colorBegin = oldColor.toString();
    Color newColor = new RGBColor((int) toR, (int) toG, (int) toB);
    String colorEnd = newColor.toString();
    String actionC = "changes color from " + colorBegin + " to "
        + colorEnd + " from t = "
        + df.format(from / speed) + " S to t = " + df.format(to / speed) + " S" + "\n";
    if (txtAni.containsKey(from)) {
      String temp = txtAni.get(from);
      temp += actionC;
      txtAni.put(from, temp);
    } else {
      txtAni.put(from, actionC);
    }
  }


  /**
   * A helper method that add a String inside the hashmap.
   *
   * @param txtAni textual animation
   * @param from   from time
   * @param fromW  from width
   * @param fromH  from height
   * @param to     to time
   * @param toW    to width
   * @param toH    to height
   */
  private void scaleTxtView(HashMap<Integer, String> txtAni, int from,
      double fromW, double fromH, int to, double toW, double toH) {
    Shapes s;
    Shapes s1;
    if (shape.getType().equals("rectangle")) {
      s = new Rectangle(fromW, fromH, 0, 0, 0);
      s1 = new Rectangle(toW, toH, 0, 0, 0);
    } else {
      s = new Oval(fromW, fromH, 0, 0, 0);
      s1 = new Oval(toW, toH, 0, 0, 0);
    }
    String actionS = "scales from " + s.getScale() + " to "
        + s1.getScale() + " from t="
        + from + " to t=" + to + "\n";
    if (txtAni.containsKey(from)) {
      String temp = txtAni.get(from) + actionS;
      txtAni.put(from, temp);
    } else {
      txtAni.put(from, actionS);
    }
  }

  /**
   * A helper method that add a String inside the hashmap with given speed.
   *
   * @param txtAni textual animation
   * @param from   from time
   * @param fromW  from width
   * @param fromH  from height
   * @param to     to time
   * @param toW    to width
   * @param toH    to height
   * @param speed  speed
   */
  private void scaleTxtView(HashMap<Integer, String> txtAni, int from,
      double fromW, double fromH, int to, double toW, double toH, double speed) {
    DecimalFormat df = new DecimalFormat("0.00");
    Shapes s;
    Shapes s1;
    if (shape.getType().equals("rectangle")) {
      s = new Rectangle(fromW, fromH, 0, 0, 0);
      s1 = new Rectangle(toW, toH, 0, 0, 0);
    } else {
      s = new Oval(fromW, fromH, 0, 0, 0);
      s1 = new Oval(toW, toH, 0, 0, 0);
    }
    String actionS = "scales from " + s.getScale() + " to "
        + s1.getScale() + " from t= "
        + df.format(from / speed) + " S to t = " + df.format(to / speed) + " S" + "\n";
    if (txtAni.containsKey(from)) {
      String temp = txtAni.get(from) + actionS;
      txtAni.put(from, temp);
    } else {
      txtAni.put(from, actionS);
    }
  }

  /**
   * Get the color of this shape.
   *
   * @return the color of this shape
   */
  @Override
  public String getColor() {
    return shape.getColor();
  }

  /**
   * Get the appear time of this shape.
   *
   * @return the appear time of this shape
   */
  @Override
  public int getAppears() {
    return this.appears;
  }

  /**
   * Get the type of this shape.
   *
   * @return the type of this shape
   */
  @Override
  public String getType() {
    return this.type;
  }

  /**
   * Get the disappear time of this shape.
   *
   * @return the disappear time of this shape
   */
  @Override
  public int getDisappears() {
    return this.disappears;
  }

  /**
   * Change the position of this shape.
   *
   * @param toX destination x
   * @param toY destination y
   */
  @Override
  public void changePosition(double toX, double toY) {
    this.position = new Position2DImpl(toX, toY);
  }

  /**
   * Get the state of this shape.
   *
   * @return the state of this shape
   */
  @Override
  public String toString() {
    String tmp;
    if (type.equals("rectangle")) {
      tmp = "Top Left Corner: ";
    } else {
      tmp = "Center: ";
    }
    return "Type: " + this.getType() + "\n" + tmp + this.position.toString() + ", "
        + shape.getScale() + ", Color:"
        + " " + shape.getColor() + "\n" + "Appears at t=" + this.appears
        + "\nDisappears at t=" + this.disappears;
  }

  /**
   * Get the initial status with given speed.
   *
   * @param speed ticks/ second
   * @return the initial status
   */
  @Override
  public String statusSpeed(double speed) {
    String tmp;
    if (type.equals("rectangle")) {
      tmp = "Top Left Corner: ";
    } else {
      tmp = "Center: ";
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return "Type: " + this.getType() + "\n" + tmp + this.position.toString() + ", "
        + shape.getScale() + ", Color:"
        + " " + shape.getColor() + "\n" + "Appears at t = " + df.format(this.appears / speed)
        + " S" + "\nDisappears at t = " + df.format(this.disappears / speed) + " S";
  }


  /**
   * Get a hash map that stores the animation time line for this shape.
   *
   * @return a hash map that stores time and status
   */
  @Override
  public LinkedHashMap<Integer, Double[]> getAnimation() {
    return this.shapeAnimation;
  }

  /**
   * Add a animation action to this shape.
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
   * @throws IllegalArgumentException if time is overlapping
   */
  @Override
  public void addAnimation(int fromT, double fromX, double fromY, double fromW,
      double fromH, double fromR, double fromG, double fromB, int toT, double toX,
      double toY, double toW, double toH, double toR, double toG,
      double toB) throws IllegalArgumentException {
    Double[] fromArray = {fromX, fromY, fromW,
        fromH, fromR, fromG, fromB};
    Double[] toArray = {toX, toY, toW, toH, toR, toG, toB};

    if (shapeAnimation.isEmpty()) {
      setAppear(fromT);
      setDisappear(toT);
      shape.changeColor(new RGBColor((int) fromR, (int) fromG, (int) fromB));
      changePosition(fromX, fromY);
      shape.changeScale(fromW, fromH);
      shapeAnimation.put(fromT, fromArray);
      if (fromT == toT) {
        if (Arrays.equals(fromArray, toArray)) {
          return;
        } else {
          throw new IllegalArgumentException("Your input is illegal!!!");
        }
      }
      shapeAnimation.put(toT, toArray);
      return;
    }

    // This is other move.
    if (shapeAnimation.containsKey(fromT)) {
      if (toT < disappears) {
        throw new IllegalArgumentException("Illegal toTime setting!!!!");
      }
      shapeAnimation.put(toT, toArray);
      setDisappear(toT);
      // This is the first move.
    } else {
      throw new IllegalArgumentException("Illegal input!!!");
    }
  }

  /**
   * Get a double array. This array contains the status of this shape when it comes to this frame.
   *
   * @param frame ticks
   * @return double array of data
   */
  @Override
  public Double[] getFrame(int frame) {
    int startTime = 0;
    for (Integer key : shapeAnimation.keySet()) {

      if (key.hashCode() == frame) {
        return shapeAnimation.get(key);
      } else if (key.hashCode() < frame) {
        startTime = key;
      } else {
        int endTime = key;
        Double[] from = shapeAnimation.get(startTime);
        Double[] to = shapeAnimation.get(endTime);
        if (Arrays.equals(from, to)) {
          return from;
        }
        Double[] frameNow = new Double[7];
        int i = 0;
        while (i < 7) {
          frameNow[i] = from[i] * (endTime - frame) / (endTime - startTime)
              + to[i] * (frame - startTime) / (endTime - startTime);
          i++;
        }
        return frameNow;
      }
    }
    throw new IllegalArgumentException("Illegal frame!!!");
  }
}
