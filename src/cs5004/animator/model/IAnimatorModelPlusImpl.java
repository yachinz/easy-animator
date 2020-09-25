package cs5004.animator.model;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasPlus;
import cs5004.animator.model.canvas.ICanvasPlusImpl;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class IAnimatorModelPlusImpl implements IAnimatorModelPlus{
  private final IAnimatorModel oldModel;
  private final ICanvasPlus canvas;

  public IAnimatorModelPlusImpl(IAnimatorModel oldModel) {

    this.oldModel = oldModel;
    this.canvas = new ICanvasPlusImpl(oldModel.getCanvas());
  }


  @Override
  public void addShapes(String name, String type) throws IllegalArgumentException {
    oldModel.addShapes(name, type);
  }

  @Override
  public LinkedList<Integer> getBound() {
    return oldModel.getBound();
  }

  @Override
  public void setBound(double x, double y, double width, double height)
      throws IllegalArgumentException {
    oldModel.setBound(x, y, width, height);
  }

  @Override
  public LinkedHashMap<String, Double[]> getAnimationFrame(int frame)
      throws IllegalArgumentException {
    return oldModel.getAnimationFrame(frame);
  }

  @Override
  public String getTextualAnimation(int speed) {
    return oldModel.getTextualAnimation(speed);
  }

  @Override
  public void addAnimation(String name, int fromT, double fromX, double fromY, double fromW,
      double fromH, double fromR, double fromG, double fromB, int toT, double toX, double toY,
      double toW, double toH, double toR, double toG, double toB) throws IllegalArgumentException {
    oldModel.addAnimation(name, fromT, fromX, fromY, fromW, fromH, fromR, fromG, fromB,
        toT, toX, toY, toW, toH, toR, toG, toB);
  }

  @Override
  public int getMaxFrame() {
    return oldModel.getMaxFrame();
  }

  @Override
  public ICanvas getCanvas() {
    return canvas;
  }

  @Override
  public void removeShape(String name) {
    canvas.removeShape(name);
  }

  @Override
  public List<String> getAllShapes() {
    return canvas.getAllShapes();
  }
}
