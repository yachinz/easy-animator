package cs5004.animator.view;

import java.util.List;

public interface IAnimationViewPlus extends IAnimationView{
  boolean getPlayStatus();

  boolean resetButton();

  void reset();

  void setFile(String content);

  void setAllShapes(List<String> shapes);

  List<String> getRemoveShape();
}
