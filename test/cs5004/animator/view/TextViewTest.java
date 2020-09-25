package cs5004.animator.view;

import static cs5004.animator.util.AnimationReader.parseFile;
import static org.junit.Assert.assertEquals;

import cs5004.animator.model.IAnimatorModel;
import cs5004.animator.model.IAnimatorModelImpl;
import cs5004.animator.util.Builder;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

/**
 * This is junit class for text view test.
 */
public class TextViewTest {

  private String output1;
  private String output2;
  private String output3;
  private ITextView view;


  @Before
  public void setUp() throws FileNotFoundException {
    IAnimatorModel rawModel = new IAnimatorModelImpl();
    IAnimatorModel rawModel1 = new IAnimatorModelImpl();
    IAnimatorModel model = parseFile(new FileReader("smalldemo.txt"),
        new Builder(rawModel));
    IAnimatorModel model2 = parseFile(new FileReader("toh-3.txt"),
        new Builder(rawModel1));
    view = new TextView();
    output1 = model.getTextualAnimation(1);
    output2 = model2.getTextualAnimation(30);
    output3 = "print test";
  }

  @Test
  public void print1() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    view.print(output1, "");
    assertEquals("Shapes:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Top Left Corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n"
        + "Appears at t = 1.00 S\n"
        + "Disappears at t = 100.00 S\n"
        + "\n"
        + "Name: C\n"
        + "Type: ellipse\n"
        + "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n"
        + "Appears at t = 6.00 S\n"
        + "Disappears at t = 100.00 S\n"
        + "\n"
        + "Shape R moves from (200.0, 200.0) to (300.0, 300.0) "
        + "from t = 10.00 S to t = 50.00 S\n"
        + "Shape C moves from (440.0, 70.0) to (440.0, 250.0) "
        + "from t = 20.00 S to t = 50.00 S\n"
        + "Shape C moves from (440.0, 250.0) to (440.0, 370.0) "
        + "from t = 50.00 S to t = 70.00 S\n"
        + "Shape C changes color from (0,0,255) to (0,170,85) "
        + "from t = 50.00 S to t = 70.00 S\n"
        + "Shape R scales from Width: 50.0, Height: 100.0 to "
        + "Width: 25.0, Height: 100.0 from t= 51.00 S to t = 70.00 S\n"
        + "Shape R moves from (300.0, 300.0) to (200.0, 200.0) "
        + "from t = 70.00 S to t = 100.00 S\n"
        + "Shape C changes color from (0,170,85) to (0,255,0) "
        + "from t = 70.00 S to t = 80.00 S\r\n", outContent.toString());
  }

  @Test
  public void print2() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    view.print(output3, "");
    assertEquals("print test\r\n", outContent.toString());
  }

  @Test
  public void print3() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    view.print(output2, "");
    assertEquals("Shapes:\n"
            + "Name: disk1\n"
            + "Type: rectangle\n"
            + "Top Left Corner: (190.0,180.0), Width: 20.0, Height: 30.0, Color: (0,49,90)\n"
            + "Appears at t = 0.03 S\n"
            + "Disappears at t = 10.07 S\n"
            + "\n"
            + "Name: disk2\n"
            + "Type: rectangle\n"
            + "Top Left Corner: (167.0,210.0), Width: 65.0, Height: 30.0, Color: (6,247,41)\n"
            + "Appears at t = 0.03 S\n"
            + "Disappears at t = 10.07 S\n"
            + "\n"
            + "Name: disk3\n"
            + "Type: rectangle\n"
            + "Top Left Corner: (145.0,240.0), Width: 110.0, Height: 30.0, Color: (11,45,175)\n"
            + "Appears at t = 0.03 S\n"
            + "Disappears at t = 10.07 S\n"
            + "\n"
            + "Shape disk1 moves from (190.0, 180.0) to (190.0, 50.0) "
            + "from t = 0.83 S to t = 1.17 S\n"
            + "Shape disk1 moves from (190.0, 50.0) to "
            + "(490.0, 50.0) from t = 1.20 S to t = 1.53 S\n"
            + "Shape disk1 moves from (490.0, 50.0) to (490.0, 240.0) "
            + "from t = 1.57 S to t = 1.90 S\n"
            + "Shape disk2 moves from (167.0, 210.0) to (167.0, 50.0) "
            + "from t = 1.90 S to t = 2.23 S\n"
            + "Shape disk2 moves from (167.0, 50.0) to (317.0, 50.0) "
            + "from t = 2.27 S to t = 2.60 S\n"
            + "Shape disk2 moves from (317.0, 50.0) to (317.0, 240.0) "
            + "from t = 2.63 S to t = 2.97 S\n"
            + "Shape disk1 moves from (490.0, 240.0) to (490.0, 50.0) "
            + "from t = 2.97 S to t = 3.30 S\n"
            + "Shape disk1 moves from (490.0, 50.0) to (340.0, 50.0) "
            + "from t = 3.33 S to t = 3.67 S\n"
            + "Shape disk1 moves from (340.0, 50.0) to (340.0, 210.0) "
            + "from t = 3.70 S to t = 4.03 S\n"
            + "Shape disk3 moves from (145.0, 240.0) to (145.0, 50.0) "
            + "from t = 4.03 S to t = 4.37 S\n"
            + "Shape disk3 moves from (145.0, 50.0) to (445.0, 50.0) "
            + "from t = 4.40 S to t = 4.73 S\n"
            + "Shape disk3 moves from (445.0, 50.0) to (445.0, 240.0) "
            + "from t = 4.77 S to t = 5.10 S\n"
            + "Shape disk1 moves from (340.0, 210.0) to (340.0, 50.0) "
            + "from t = 5.10 S to t = 5.43 S\n"
            + "Shape disk3 changes color from (11,45,175) to (0,255,0) "
            + "from t = 5.10 S to t = 5.37 S\n"
            + "Shape disk1 moves from (340.0, 50.0) to (190.0, 50.0) "
            + "from t = 5.47 S to t = 5.80 S\n"
            + "Shape disk1 moves from (190.0, 50.0) to (190.0, 240.0) "
            + "from t = 5.83 S to t = 6.17 S\n"
            + "Shape disk2 moves from (317.0, 240.0) to (317.0, 50.0) "
            + "from t = 6.17 S to t = 6.50 S\n"
            + "Shape disk2 moves from (317.0, 50.0) to (467.0, 50.0) "
            + "from t = 6.53 S to t = 6.87 S\n"
            + "Shape disk2 moves from (467.0, 50.0) to (467.0, 210.0)"
            + " from t = 6.90 S to t = 7.23 S\n"
            + "Shape disk1 moves from (190.0, 240.0) to (190.0, 50.0)"
            + " from t = 7.23 S to t = 7.57 S\n"
            + "Shape disk2 changes color from (6,247,41) to (0,255,0)"
            + " from t = 7.23 S to t = 7.50 S\n"
            + "Shape disk1 moves from (190.0, 50.0) to (490.0, 50.0)"
            + " from t = 7.60 S to t = 7.93 S\n"
            + "Shape disk1 moves from (490.0, 50.0) to (490.0, 180.0)"
            + " from t = 7.97 S to t = 8.30 S\n"
            + "Shape disk1 changes color from (0,49,90) to (0,255,0)"
            + " from t = 8.30 S to t = 8.57 S\r\n",
        outContent.toString());
  }

  @Test
  public void addFile() {
    view.print(output3, "output3.txt");
    try {
      Path path = Paths.get("output3.txt");
      byte[] data = Files.readAllBytes(path);
      String result = new String(data, StandardCharsets.UTF_8);
      assertEquals("print test", result);
      Files.delete(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    view.print(output1, "output1.txt");
    try {
      Path path = Paths.get("output1.txt");
      byte[] data = Files.readAllBytes(path);
      String result = new String(data, StandardCharsets.UTF_8);
      assertEquals("Shapes:\n"
          + "Name: R\n"
          + "Type: rectangle\n"
          + "Top Left Corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n"
          + "Appears at t = 1.00 S\n"
          + "Disappears at t = 100.00 S\n"
          + "\n"
          + "Name: C\n"
          + "Type: ellipse\n"
          + "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n"
          + "Appears at t = 6.00 S\n"
          + "Disappears at t = 100.00 S\n"
          + "\n"
          + "Shape R moves from (200.0, 200.0) to (300.0, 300.0) "
          + "from t = 10.00 S to t = 50.00 S\n"
          + "Shape C moves from (440.0, 70.0) to (440.0, 250.0) "
          + "from t = 20.00 S to t = 50.00 S\n"
          + "Shape C moves from (440.0, 250.0) to (440.0, 370.0) "
          + "from t = 50.00 S to t = 70.00 S\n"
          + "Shape C changes color from (0,0,255) to (0,170,85) "
          + "from t = 50.00 S to t = 70.00 S\n"
          + "Shape R scales from Width: 50.0, Height: 100.0 to "
          + "Width: 25.0, Height: 100.0 from t= 51.00 S to t = 70.00 S\n"
          + "Shape R moves from (300.0, 300.0) to (200.0, 200.0) from "
          + "t = 70.00 S to t = 100.00 S\n"
          + "Shape C changes color from (0,170,85) to (0,255,0) from "
          + "t = 70.00 S to t = 80.00 S", result);
      Files.delete(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      view.print(output3, ".txt");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      view.print(output3, null);
    } catch (IllegalArgumentException ignored) {
    }
    try {
      view.print(null, "output.txt");
    } catch (IllegalArgumentException ignored) {
    }


  }
}