import java.awt.*;
import java.io.File;

public class DTOGeneralParameters {
    private int fireWidth;
    private int fireHeight;
    private int fireXPosition;
    private int fireYPosition;
    private File backgroundImage;


    public DTOGeneralParameters(int fireWidth, int fireHeight, int fireXPosition, int fireYPosition, File backgroundImage) {
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.fireXPosition = fireXPosition;
        this.fireYPosition = fireYPosition;
        this.backgroundImage = backgroundImage;
    }

    public int getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(int fireWidth) {
        this.fireWidth = fireWidth;
    }

    public int getFireHeight() {
        return fireHeight;
    }

    public void setFireHeight(int fireHeight) {
        this.fireHeight = fireHeight;
    }

    public int getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(int fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public int getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(int fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public File getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(File backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
