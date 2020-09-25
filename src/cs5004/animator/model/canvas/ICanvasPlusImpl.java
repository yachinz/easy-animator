package cs5004.animator.model.canvas;

import cs5004.animator.model.shapes.Shapes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ICanvasPlusImpl implements ICanvasPlus {
  private final ICanvas canvas;

  public ICanvasPlusImpl(ICanvas canvas) {
    this.canvas = canvas;
  }


  @Override
  public LinkedList<Integer> getBound() {
    return canvas.getBound();
  }

  @Override
  public void addShapes(String name, String type) throws IllegalArgumentException {
    canvas.addShapes(name, type);
  }

  @Override
  public void setBound(double x, double y, double width, double height) {
    canvas.setBound(x, y, width, height);
  }

  @Override
  public LinkedHashMap<String, Double[]> getAnimationFrame(int frame) {
    return canvas.getAnimationFrame(frame);
  }

  @Override
  public String getTextualAnimation(int speed) {
    return canvas.getTextualAnimation(speed);
  }

  @Override
  public void addAnimation(String name, int fromT, double fromX, double fromY, double fromW,
      double fromH, double fromR, double fromG, double fromB, int toT, double toX, double toY,
      double toW, double toH, double toR, double toG, double toB) {
    canvas.addAnimation(name, fromT, fromX, fromY, fromW, fromH, fromR,
        fromG, fromB, toT, toX, toY, toW, toH, toR, toG, toB);
  }

  @Override
  public int getMaxFrame() {
    return canvas.getMaxFrame();
  }

  @Override
  public void removeShape(String shape) {
    LinkedHashMap<String, IShapeOnCanvas> s = canvas.getShapes();
    s.remove(shape);
  }

  @Override
  public List<String> getAllShapes() {
    return new ArrayList<String>(canvas.getShapes().keySet());
  }

  @Override
  public LinkedHashMap<String, IShapeOnCanvas> getShapes() {
    return canvas.getShapes();
  }
}
