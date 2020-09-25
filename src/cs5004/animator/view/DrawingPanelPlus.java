package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DrawingPanelPlus extends DrawingPanel{
  private Boolean play;
  private Boolean reset;

  /**
   * Constructs a DrawingPanel object with given value.
   *
   * @param width  width of canvas
   * @param height height of canvas
   */
  public DrawingPanelPlus(int width, int height) {
    super(width, height);
    play = false;
    reset = false;
    JButton playButton = new JButton("play");
    playButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        play = true;
        reset = false;
      }
    });

    JButton stopButton = new JButton("stop");
    stopButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        play = false;
        reset = false;
      }
    });

    JButton resetButton = new JButton("reset");
    resetButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        play = true;
        reset = true;
      }
    });
    add(playButton);
    add(stopButton);
    add(resetButton);
  }

  public boolean play() {
    return this.play;
  }

  public boolean getReset() {
    return this.reset;
  }

  public void setReset() {
    this.play = true;
    this.reset = false;
  }

}
