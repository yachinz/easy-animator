package cs5004.animator.controller;

import cs5004.animator.model.IAnimatorModelPlus;
import cs5004.animator.view.IAnimationViewPlus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 * This class represents a animationController. It has a timer to control the refresh time of view.
 */
public class AnimationControllerPlus implements IController {

  private final Timer timer;

  /**
   * Constructs a animationController object with given value.
   *
   * @param model the model
   * @param view  animation view
   * @param speed ticks/second
   * @throws IllegalArgumentException if speed is not positive
   */
  public AnimationControllerPlus(IAnimatorModelPlus model, IAnimationViewPlus view, int speed)
      throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("You can't put a negative speed!!!");
    }
    LinkedList<Integer> size = model.getBound();
    view.setCanvasSize(size.get(2), size.get(3));
    view.setFile(model.getTextualAnimation(speed)); // For save method.
    view.setAllShapes(model.getAllShapes()); // For remove method.
    timer = new Timer(1000 / speed, new ActionListener() {
      int frameNow = 1;
      final int maxFrame = model.getMaxFrame();

      @Override
      public void actionPerformed(ActionEvent e) {
        // Remove feature.
        List<String> remove = view.getRemoveShape();
        if (!remove.isEmpty()) {
          for (String i : remove) {
            model.removeShape(i);
          }
          view.setFile(model.getTextualAnimation(speed));
          }
        // Animation finish, but not reset.
        if (frameNow > maxFrame && !view.resetButton()) {
          return;
        }
        // Reset.
        if (view.resetButton()) {
          frameNow = 1;
          view.reset();
          return;
        }
        // If play is true then go on.
        if (view.getPlayStatus()) {
          view.clear();
          LinkedHashMap<String, Double[]> map = model.getAnimationFrame(frameNow);
          for (String keys : map.keySet()) {
            Double[] s = map.get(keys);
            if (keys.contains("rectangle")) {
              view.draw("rectangle", s[0], s[1],
                  s[2], s[3], s[4], s[5], s[6]);
            }
            if (keys.contains("ellipse")) {
              view.draw("oval", s[0], s[1], s[2], s[3]
                  , s[4], s[5], s[6]);
            }
          }
          frameNow++;
        }
      }
    });
  }


  /**
   * Start the animation.
   */
  @Override
  public void animate() {
    timer.start();
  }
}
