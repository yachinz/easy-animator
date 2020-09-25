package cs5004.animator.util;

import javax.swing.JOptionPane;

/**
 * This is a util class to check the correctness of argument.
 */
public class InputHandler {

  /**
   * Check the argument and put them in order.
   *
   * @param info arguments
   * @return a array of input data
   */
  public static String[] inputInfo(String[] info) {
    String[] output = {"", "", "", "1"};
    if (info.length < 4 || info.length > 8) {
      JOptionPane.showMessageDialog(null, "your Input is illegal!!");
      System.exit(0);
    }
    int counterIn = 0;
    int counterView = 0;
    int counterOut = 0;
    int counterSpeed = 0;
    for (String s : info) {
      switch (s) {
        case "-in":
          counterIn++;
          break;
        case "-view":
          counterView++;
          break;
        case "-out":
          counterOut++;
          break;
        case "-speed":
          counterSpeed++;
          break;
        default:
      }
    }
    if (counterIn != 1 || counterView != 1 || counterOut > 1 || counterSpeed > 1) {
      JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
      System.exit(0);
    }
    int i = 0;
    while (i < info.length - 1) {
      if (info[i].equals("-in")) {
        try {
          String next = info[i + 1];
          if (next.endsWith(".txt")) {
            output[0] = next;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
          System.exit(0);
        }
      }
      if (info[i].equals("-view")) {
        try {
          String next = info[i + 1];
          if ((next.equals("visual") && counterOut == 0) || (next.equals("text"))) {
            output[1] = next;
          } else {
            JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
            System.exit(0);
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
          System.exit(0);
        }
      }
      if (info[i].equals("-out")) {
        try {
          String next = info[i + 1];
          if (next.endsWith(".txt")) {
            output[2] = next;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
          System.exit(0);
        }
      }
      if (info[i].equals("-speed")) {
        try {
          String next = info[i + 1];
          int k = Integer.parseInt(next);
          output[3] = next;
        } catch (ArrayIndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(null, "your Input is illegal!!!");
          System.exit(0);
        } catch (NumberFormatException n) {
          JOptionPane.showMessageDialog(null, "your Input speed is illegal!!!");
          System.exit(0);
        }
      }
      i++;
    }
    int speed = Integer.parseInt(output[3]);
    if (speed <= 0 || speed > 100) {
      JOptionPane.showMessageDialog(null, "Please "
          + "input your speed between(1, 100)!!!");
      System.exit(0);
    }
    return output;
  }
}
