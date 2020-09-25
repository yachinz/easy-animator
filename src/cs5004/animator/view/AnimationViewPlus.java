package cs5004.animator.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class AnimationViewPlus extends JFrame implements IAnimationViewPlus {
  private DrawingPanelPlus myPanel;
  private final JMenuBar br;
  private String fileToSave;
  private final List<String> removeShapes;

  public AnimationViewPlus() {
    super();
    fileToSave = "";
    removeShapes = new ArrayList<>();
    JMenu jm = new JMenu("File") ;
    JMenuItem t1 = new JMenuItem("Save") ;
    t1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();

        int user = chooser.showSaveDialog(null);
        if (user == JFileChooser.APPROVE_OPTION) {
          FileWriter writer;
          try{
            File f = chooser.getSelectedFile();
            String newPath = (f.getAbsolutePath()).replace("\\", "/");
            writer = new FileWriter(newPath);
            writer.write(fileToSave);
            writer.flush();
            writer.close();
          } catch (IOException ioe) {
            throw new IllegalArgumentException("Your file name is illegal!!!!");
          }
        }
      }
    });
    JMenu jmRemove = new JMenu("Remove");

    jm.add(t1);
    br = new  JMenuBar();
    br.add(jm) ;
    br.add(jmRemove);
    setJMenuBar(br) ;
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  @Override
  public boolean getPlayStatus() {
    return myPanel.play();
  }

  @Override
  public boolean resetButton() {
    return myPanel.getReset();
  }

  @Override
  public void reset() {
    myPanel.setReset();
  }

  @Override
  public void setFile(String content) {
    this.fileToSave = content;
  }

  @Override
  public void setAllShapes(List<String> shapes) {
    for(String i : shapes) {
      JMenuItem tmp = new JMenuItem(i);
      tmp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          br.getMenu(1).remove(tmp);
          removeShapes.add(tmp.getText());
        }
      });
      br.getMenu(1).add(tmp);
    }
  }

  @Override
  public List<String> getRemoveShape() {
    return removeShapes;
  }

  @Override
  public void setCanvasSize(int x, int y) {

    setSize(x, y);
    myPanel = new DrawingPanelPlus(x, y);
    JScrollPane scrollPane = new JScrollPane(myPanel);
    add(scrollPane);
    setVisible(true);
  }

  @Override
  public void clear() {
    myPanel.clear();
  }

  @Override
  public void draw(String type, double x, double y, double w,
      double h, double r, double g, double b) {
    Shape s;
    switch (type) {
      case "rectangle":
        s = new Rectangle(x, y, w, h, new Color((int) r, (int) g, (int) b));
        break;
      case "oval":
        s = new Oval(x, y, w, h, new Color((int) r, (int) g, (int) b));
        break;
      default:
        throw new IllegalArgumentException("Your shape is wrong!!!");
    }
    myPanel.drawShape(s);
  }
}
