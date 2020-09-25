package cs5004.animator.model.canvas;

import java.util.List;

public interface ICanvasPlus extends ICanvas{
  void removeShape(String shape);
  List<String> getAllShapes();
}
