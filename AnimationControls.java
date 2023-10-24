import javax.swing.*;
import java.awt.event.*;

public class AnimationControls {
    private JToggleButton playPause;
    private JButton apply;
    private JButton stopButton;

    public AnimationControls() {
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
