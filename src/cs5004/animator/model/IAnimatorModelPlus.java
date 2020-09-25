package cs5004.animator.model;

import java.util.List;

public interface IAnimatorModelPlus extends IAnimatorModel{
  void removeShape(String name);
  List<String> getAllShapes();

}
