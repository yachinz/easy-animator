package animator.model;

import static org.junit.Assert.assertEquals;

import cs5004.animator.model.IAnimatorModel;
import cs5004.animator.model.IAnimatorModelImpl;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a junit class for IAnimatorModelImpl. I has a noShape, a onShape and a twoShapes test
 * case.
 */
public class IAnimatorModelImplTest {

  // Test case with no shape.
  private IAnimatorModel noShape;

  // Test case with one shape.
  private IAnimatorModel oneShape;

  // Test case with two shapes.
  private IAnimatorModel twoShapes;

  @Before
  public void setUp() {
    noShape = new IAnimatorModelImpl();

    oneShape = new IAnimatorModelImpl();
    oneShape.addShapes("A", "ellipse");

    twoShapes = new IAnimatorModelImpl();
    twoShapes.addShapes("B", "ellipse");
    twoShapes.addShapes("C", "rectangle");
  }

  @Test
  public void constructor() {
    assertEquals("No Animation!", noShape.toString());

    assertEquals("Shapes:\n"
        + "Name: A\n"
        + "Type: ellipse\n"
        + "Center: (0.0,0.0), X radius: 0.0, Y radius: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0", oneShape.toString());

    assertEquals("Shapes:\n"
        + "Name: B\n"
        + "Type: ellipse\n"
        + "Center: (0.0,0.0), X radius: 0.0, Y radius: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0\n"
        + "\n"
        + "Name: C\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (0.0,0.0), Width: 0.0, Height: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0", twoShapes.toString());
  }

  @Test
  public void IllegalAddShape() {
    assertEquals("Shapes:\n"
        + "Name: B\n"
        + "Type: ellipse\n"
        + "Center: (0.0,0.0), X radius: 0.0, Y radius: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0\n"
        + "\n"
        + "Name: C\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (0.0,0.0), Width: 0.0, Height: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0", twoShapes.toString());
    // Illegal name.
    try {
      oneShape.addShapes("", "ellipse");
    } catch (IllegalArgumentException ignored) {
    }

    // Illegal type.
    try {
      oneShape.addShapes("B", "other");
    } catch (IllegalArgumentException ignored) {
    }

    // Repeat name.
    try {
      oneShape.addShapes("A", "ellipse");
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void addShape() {
    noShape.addShapes("k", "rectangle");
    assertEquals("Shapes:\n"
        + "Name: k\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (0.0,0.0), Width: 0.0, Height: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0", noShape.toString());

    noShape.addShapes("k1", "ellipse");
    assertEquals("Shapes:\n"
        + "Name: k\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (0.0,0.0), Width: 0.0, Height: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0\n"
        + "\n"
        + "Name: k1\n"
        + "Type: ellipse\n"
        + "Center: (0.0,0.0), X radius: 0.0, Y radius: 0.0, Color: (0,0,0)\n"
        + "Appears at t=0\n"
        + "Disappears at t=0", noShape.toString());
  }

  @Test
  public void addAnimationTest() {
    oneShape.addAnimation("A", 1, 500, 100, 60,
        30, 0, 0, 255, 10, 200, 100,
        30, 30, 0, 0, 255);
    assertEquals("Shapes:\n"
        + "Name: A\n"
        + "Type: ellipse\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t=1\n"
        + "Disappears at t=10\n"
        + "\n"
        + "Shape A moves from (500.0, 100.0) to (200.0, 100.0) from t=1 to t=10\n"
        + "Shape A scales from X radius: 60.0, Y radius: 30.0 to X radius: 30.0"
        + ", Y radius: 30.0 from t=1 to t=10", oneShape.toString());
    try {
      oneShape.addAnimation("A", 1, 500, 100, 60,
          30, 0, 0, 255, 10, 200, 100,
          30, 30, 0, 0, 255);
    } catch (IllegalArgumentException ignored) {
    }
    oneShape.addAnimation("A", 10, 200, 100,
        30, 30, 0, 0, 255, 20, 200,
        150, 30, 30, 0, 255, 0);
    assertEquals("Shapes:\n"
            + "Name: A\n"
            + "Type: ellipse\n"
            + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
            + "Appears at t=1\n"
            + "Disappears at t=20\n"
            + "\n"
            + "Shape A moves from (500.0, 100.0) to (200.0, 100.0) from t=1 to t=10\n"
            + "Shape A scales from X radius: 60.0, Y radius: 30.0 to X radius: 30.0"
            + ", Y radius: 30.0 from t=1 to t=10\n"
            + "Shape A moves from (200.0, 100.0) to (200.0, 150.0) from t=10 to t=20\n"
            + "Shape A changes color from (0,0,255) to (0,255,0) from t=10 to t=20",
        oneShape.toString());
    try {
      oneShape.addAnimation("A", 1, 500, 100, 60,
          30, 0, 0, 255, 10, 200, 100,
          30, 30, 0, 0, 255);
    } catch (IllegalArgumentException ignored) {
    }

    twoShapes.addAnimation("B", 1, 501, 101, 60,
        30, 0, 0, 255, 10, 200, 101,
        30, 30, 0, 0, 255);
    twoShapes.addAnimation("C", 20, 500, 100, 60,
        30, 0, 0, 255, 50, 200, 100,
        30, 30, 0, 0, 255);
    assertEquals("Shapes:\n"
        + "Name: B\n"
        + "Type: ellipse\n"
        + "Center: (501.0,101.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t=1\n"
        + "Disappears at t=10\n"
        + "\n"
        + "Name: C\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (500.0,100.0), Width: 60.0, Height: 30.0, Color: (0,0,255)\n"
        + "Appears at t=20\n"
        + "Disappears at t=50\n"
        + "\n"
        + "Shape B moves from (501.0, 101.0) to (200.0, 101.0) from t=1 to t=10\n"
        + "Shape B scales from X radius: 60.0, Y radius: 30.0 to X radius: 30.0"
        + ", Y radius: 30.0 from t=1 to t=10\n"
        + "Shape C moves from (500.0, 100.0) to (200.0, 100.0) from t=20 to t=50\n"
        + "Shape C scales from Width: 60.0, Height: 30.0 to Width: 30.0"
        + ", Height: 30.0 from t=20 to t=50", twoShapes.toString());
  }

  @Test
  public void textView() {
    oneShape.addAnimation("A", 1, 500, 100, 60,
        30, 0, 0, 255, 10, 200, 100,
        30, 30, 0, 0, 255);
    oneShape.addAnimation("A", 10, 200, 100,
        30, 30, 0, 0, 255, 20, 200,
        150, 30, 30, 0, 255, 0);
    assertEquals("Shapes:\n"
        + "Name: A\n"
        + "Type: ellipse\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 1.00 S\n"
        + "Disappears at t = 20.00 S\n"
        + "\n"
        + "Shape A moves from (500.0, 100.0) to (200.0, 100.0) "
        + "from t = 1.00 S to t = 10.00 S\n"
        + "Shape A scales from X radius: 60.0, Y radius: 30.0 to"
        + " X radius: 30.0, Y radius: 30.0 from t= 1.00 S to t = 10.00 S\n"
        + "Shape A moves from (200.0, 100.0) to (200.0, 150.0) "
        + "from t = 10.00 S to t = 20.00 S\n"
        + "Shape A changes color from (0,0,255) to"
        + " (0,255,0) from t = 10.00 S to t = 20.00 S", oneShape.getTextualAnimation(1));
    assertEquals("Shapes:\n"
        + "Name: A\n"
        + "Type: ellipse\n"
        + "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 0.10 S\n"
        + "Disappears at t = 2.00 S\n"
        + "\n"
        + "Shape A moves from (500.0, 100.0) to (200.0, 100.0)"
        + " from t = 0.10 S to t = 1.00 S\n"
        + "Shape A scales from X radius: 60.0, Y radius: 30.0 to X radius: 30.0, Y radius:"
        + " 30.0 from t= 0.10 S to t = 1.00 S\n"
        + "Shape A moves from (200.0, 100.0) to (200.0, 150.0) "
        + "from t = 1.00 S to t = 2.00 S\n"
        + "Shape A changes color from (0,0,255) to (0,255,0) "
        + "from t = 1.00 S to t = 2.00 S", oneShape.getTextualAnimation(10));

    twoShapes.addAnimation("B", 1, 501, 101, 60,
        30, 0, 0, 255, 10, 200, 101,
        30, 30, 0, 0, 255);
    twoShapes.addAnimation("C", 20, 500, 100, 60,
        30, 0, 0, 255, 50, 200, 100,
        30, 30, 0, 0, 255);
    twoShapes.addAnimation("C", 50, 200, 100,
        30, 30, 0, 0, 255, 70
        , 200, 100, 30, 70, 255, 0, 255);
    assertEquals("Shapes:\n"
        + "Name: B\n"
        + "Type: ellipse\n"
        + "Center: (501.0,101.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 1.00 S\n"
        + "Disappears at t = 10.00 S\n"
        + "\n"
        + "Name: C\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (500.0,100.0), Width: 60.0, Height: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 20.00 S\n"
        + "Disappears at t = 70.00 S\n"
        + "\n"
        + "Shape B moves from (501.0, 101.0) to (200.0, 101.0) "
        + "from t = 1.00 S to t = 10.00 S\n"
        + "Shape B scales from X radius: 60.0, Y radius: 30.0 to X "
        + "radius: 30.0, Y radius: 30.0 from t= 1.00 S to t = 10.00 S\n"
        + "Shape C moves from (500.0, 100.0) to (200.0, 100.0) "
        + "from t = 20.00 S to t = 50.00 S\n"
        + "Shape C scales from Width: 60.0, Height: 30.0 to Width: "
        + "30.0, Height: 30.0 from t= 20.00 S to t = 50.00 S\n"
        + "Shape C scales from Width: 30.0, Height: 30.0 to Width: "
        + "30.0, Height: 70.0 from t= 50.00 S to t = 70.00 S\n"
        + "Shape C changes color from (0,0,255) to (255,0,255) "
        + "from t = 50.00 S to t = 70.00 S", twoShapes.getTextualAnimation(1));
    assertEquals("Shapes:\n"
        + "Name: B\n"
        + "Type: ellipse\n"
        + "Center: (501.0,101.0), X radius: 60.0, Y radius: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 0.10 S\n"
        + "Disappears at t = 1.00 S\n"
        + "\n"
        + "Name: C\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (500.0,100.0), Width: 60.0, Height: 30.0, Color: (0,0,255)\n"
        + "Appears at t = 2.00 S\n"
        + "Disappears at t = 7.00 S\n"
        + "\n"
        + "Shape B moves from (501.0, 101.0) to (200.0, 101.0) from t = 0.10 S "
        + "to t = 1.00 S\n"
        + "Shape B scales from X radius: 60.0, Y radius: 30.0 "
        + "to X radius: 30.0, Y radius: 30.0 from t= 0.10 S to t = 1.00 S\n"
        + "Shape C moves from (500.0, 100.0) to (200.0, 100.0)"
        + " from t = 2.00 S to t = 5.00 S\n"
        + "Shape C scales from Width: 60.0, Height: 30.0 to Width: "
        + "30.0, Height: 30.0 from t= 2.00 S to t = 5.00 S\n"
        + "Shape C scales from Width: 30.0, Height: 30.0 to Width: 30.0, "
        + "Height: 70.0 from t= 5.00 S to t = 7.00 S\n"
        + "Shape C changes color from (0,0,255) to (255,0,255)"
        + " from t = 5.00 S to t = 7.00 S", twoShapes.getTextualAnimation(10));
  }

  @Test
  public void animation() {
    oneShape.addAnimation("A", 1, 500, 100, 60,
        30, 0, 0, 255, 10, 200, 100,
        30, 30, 0, 0, 255);
    oneShape.addAnimation("A", 10, 200, 100,
        30, 30, 0, 0, 255, 20, 200,
        150, 30, 30, 0, 255, 0);
    LinkedHashMap<String, Double[]> frameNow = oneShape.getAnimationFrame(1);
    StringBuilder i = new StringBuilder();
    DecimalFormat df = new DecimalFormat("0.00");
    for (String key : frameNow.keySet()) {
      Double[] tmp = frameNow.get(key);
      i.append(key).append(" ").append(df.format(tmp[0])).append(" ").
          append(df.format(tmp[1])).append(" ").append(df.format(tmp[2]))
          .append(" ").append(df.format(tmp[3])).append(" ").append(df.format(tmp[4]))
          .append(" ").append(df.format(tmp[5]))
          .append(" ").append(df.format(tmp[6])).append("\n");
    }
    assertEquals("A ellipse 500.00 100.00 60.00 30.00 0.00 0.00 255.00",
        i.toString().trim());
    frameNow = oneShape.getAnimationFrame(5);
    StringBuilder j = new StringBuilder();
    for (String key : frameNow.keySet()) {
      Double[] tmp = frameNow.get(key);
      j.append(key).append(" ").append(df.format(tmp[0])).append(" ").
          append(df.format(tmp[1])).append(" ").append(df.format(tmp[2]))
          .append(" ").append(df.format(tmp[3])).append(" ").append(df.format(tmp[4]))
          .append(" ").append(df.format(tmp[5]))
          .append(" ").append(df.format(tmp[6])).append("\n");
    }
    assertEquals("A ellipse 366.67 100.00 "
        + "46.67 30.00 0.00 0.00 255.00", j.toString().trim());
  }

  @Test
  public void setAndGetBound() {
    oneShape.setBound(1, 2, 3, 4);
    LinkedList<Integer> tmp = oneShape.getBound();
    assertEquals(1, (int) tmp.get(0));
    assertEquals(2, (int) tmp.get(1));
    assertEquals(3, (int) tmp.get(2));
    assertEquals(4, (int) tmp.get(3));
    try {
      oneShape.setBound(1, 3, -1, 1);
    } catch (IllegalArgumentException ignored) {
    }
    try {
      oneShape.setBound(1, 3, 1, 0);
    } catch (IllegalArgumentException ignored) {
    }
  }

}