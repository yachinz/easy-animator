package cs5004.animator;

import static cs5004.animator.util.AnimationReader.parseFile;
import static cs5004.animator.util.InputHandler.inputInfo;

import cs5004.animator.controller.AnimationControllerPlus;
import cs5004.animator.controller.IController;
import cs5004.animator.controller.TextViewController;
import cs5004.animator.model.IAnimatorModel;
import cs5004.animator.model.IAnimatorModelImpl;
import cs5004.animator.model.IAnimatorModelPlus;
import cs5004.animator.model.IAnimatorModelPlusImpl;
import cs5004.animator.util.Builder;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.AnimationViewPlus;
import cs5004.animator.view.IAnimationView;
import cs5004.animator.view.IAnimationViewPlus;
import cs5004.animator.view.ITextView;
import cs5004.animator.view.TextView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 * This class represents a easy animator.
 * User could input argument -in "filename.txt" -view "view type"
 * - out "out filename.txt" - speed "ticks per seconds" to get a view.
 * We have "text" and "visual" -view type. User should at least input
 * -in and -view. Others are optional.
 *
 */
public class EasyAnimator {

  /**
   * main function for easy animator.
   * @param args the input arguments
   */
  public static void main(String[] args) {
    String [] s = inputInfo(args);
    IAnimatorModel model =  new IAnimatorModelImpl();
    IAnimatorModelPlus modelPlus = new IAnimatorModelPlusImpl(model);
    try {
      model = parseFile(new FileReader(s[0]), new Builder(modelPlus));
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Can not find the file!!!");
      System.exit(0);
    }
    if (s[1].equals("text")) {
      ITextView view = new TextView();
      IController controller = new TextViewController(model, view, s[2], Integer.parseInt(s[3]));
      controller.animate();
    }
    if (s[1].equals("visual")) {
      IAnimationViewPlus view = new AnimationViewPlus();
      IController controller = new AnimationControllerPlus(modelPlus, view, Integer.parseInt(s[3]));
      controller.animate();
    }
  }

}
