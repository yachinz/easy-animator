package cs5004.animator.controller;

import cs5004.animator.model.IAnimatorModel;
import cs5004.animator.view.ITextView;

/**
 * This represents a text view controller. A text view controller has a model, a view, a file name
 * and a speed.
 */
public class TextViewController implements IController {

  private final IAnimatorModel model;
  private final ITextView view;
  private String name = "";
  private final int speed;

  /**
   * Constructs a TextViewController object with given values.
   *
   * @param model    the model
   * @param view     the text view
   * @param fileName out put file name
   * @param speed    ticks per second
   */
  public TextViewController(IAnimatorModel model, ITextView view, String fileName, int speed) {
    this.model = model;
    this.view = view;
    this.name += fileName;
    this.speed = speed;
  }

  /**
   * Start the animation.
   */
  @Override
  public void animate() {
    String tmp = model.getTextualAnimation(speed);
    view.print(tmp, name);
  }
}
