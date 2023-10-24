import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    AnimationControls AnimationControls;
    GeneralConfiguration GeneralConfiguration;

    public ControlPanel() {
        AnimationControls = new AnimationControls();
        GeneralConfiguration = new GeneralConfiguration();
    }

    public AnimationControls getAnimationControls() {
        return AnimationControls;
    }

    public void setAnimationControls(AnimationControls animationControls) {
        AnimationControls = animationControls;
    }

    public GeneralConfiguration getGeneralConfiguration() {
        return GeneralConfiguration;
    }

    public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
        GeneralConfiguration = generalConfiguration;
    }
}
