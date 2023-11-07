import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private AnimationControls AnimationControls;
    private GeneralConfiguration GeneralConfiguration;
    private TemperatureConfiguration TemperatureConfiguration;
    private PaletteConfiguration PaletteConfiguration;
    public ControlPanel() {
        AnimationControls = new AnimationControls();
        GeneralConfiguration = new GeneralConfiguration();
        TemperatureConfiguration = new TemperatureConfiguration();
        PaletteConfiguration = new PaletteConfiguration();
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

    public TemperatureConfiguration getTemperatureConfiguration() {
        return TemperatureConfiguration;
    }

    public void setTemperatureConfiguration(TemperatureConfiguration temperatureConfiguration) {
        TemperatureConfiguration = temperatureConfiguration;
    }

    public PaletteConfiguration getPaletteConfiguration() {
        return PaletteConfiguration;
    }

    public void setPaletteConfiguration(PaletteConfiguration paletteConfiguration) {
        PaletteConfiguration = paletteConfiguration;
    }
}
