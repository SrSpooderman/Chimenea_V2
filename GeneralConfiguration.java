import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class GeneralConfiguration {
    private JFormattedTextField fireWidth;
    private JFormattedTextField fireHeight;
    private JFormattedTextField fireXPosition;
    private JFormattedTextField fireYPosition;
    private Image backgroundImage;

    public GeneralConfiguration() {
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);

        NumberFormat formata = NumberFormat.getIntegerInstance();
        NumberFormatter formattera = new NumberFormatter(formata);
        formattera.setValueClass(Integer.class);


        fireWidth = new JFormattedTextField(formatter);
        fireWidth.setName("AnchoFuegoTextField");

        fireHeight = new JFormattedTextField(formatter);
        fireHeight.setName("AltoFuegoTextField");

        fireXPosition = new JFormattedTextField(formattera);
        fireXPosition.setName("PosicionXTextField");

        fireYPosition = new JFormattedTextField(formattera);
        fireYPosition.setName("PosicionYTextField");
    }

    public JFormattedTextField getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(JFormattedTextField fireWidth) {
        this.fireWidth = fireWidth;
    }

    public JFormattedTextField getFireHeight() {
        return fireHeight;
    }

    public void setFireHight(JFormattedTextField fireHight) {
        this.fireHeight = fireHight;
    }

    public JFormattedTextField getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(JFormattedTextField fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public JFormattedTextField getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(JFormattedTextField fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
