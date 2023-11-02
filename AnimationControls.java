import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimationControls extends JPanel{
    private JToggleButton playPause;
    private JButton apply;
    private JButton stopButton;

    public AnimationControls(){
        this.playPause = new JToggleButton("Play");
        this.stopButton = new JButton("Stop");
        this.apply = new JButton("Apply");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        this.add(this.playPause, c);
        c.gridy = 1;
        this.add(this.stopButton, c);
        c.gridy = 2;
        this.add(this.apply, c);
    }

    public JToggleButton getPlayPause() {
        return playPause;
    }

    public void setPlayPause(JToggleButton playPause) {
        this.playPause = playPause;
    }

    public JButton getApply() {
        return apply;
    }

    public void setApply(JButton apply) {
        this.apply = apply;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }
}
