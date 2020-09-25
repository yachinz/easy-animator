package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is a textual view. In this view, user can print the textual view on console or int a new
 * .txt file.
 */
public class TextView implements ITextView {

  /**
   * Print or write the textual view.
   *
   * @param textView textual view
   * @param name     name of output file
   * @throws IllegalArgumentException if input is illegal
   */
  @Override
  public void print(String textView, String name) throws IllegalArgumentException {
    if (textView == null || name == null || name.equals(".txt")) {
      throw new IllegalArgumentException("Your input is illegal!!!");
    }
    if (name.equals("")) {
      System.out.println(textView);
    } else {
      FileWriter writer;
      try {
        writer = new FileWriter(name);
        writer.write(textView);
        writer.flush();
        writer.close();
      } catch (IOException e) {
        throw new IllegalArgumentException("Your file name is illegal!!!!");
      }
    }
  }
}
