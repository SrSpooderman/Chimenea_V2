import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.io.File;
import java.text.NumberFormat;

public class GeneralConfiguration extends JPanel {
    private JFormattedTextField fireWidth;
    private JFormattedTextField fireHeight;
    private JFormattedTextField fireXPosition;
    private JFormattedTextField fireYPosition;
    private JButton backgroundImage;
    private JTextArea backgroundInfo;

    public GeneralConfiguration() {
        backgroundImage = new JButton("Selecciona Imagen");

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

        backgroundInfo = new JTextArea("");

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        JLabel label = new JLabel("Fire Height:");
        this.add(label, c);

        c.gridy = 1;
        this.add(this.fireHeight, c);

        c.gridy = 2;
        label = new JLabel("Fire Width:");
        this.add(label, c);

        c.gridy = 3;
        this.add(this.fireWidth, c);

        c.gridy = 4;
        label = new JLabel("Fire X Position:");
        this.add(label, c);

        c.gridy = 5;
        this.add(this.fireXPosition, c);

        c.gridy = 6;
        label = new JLabel("Fire Y Position:");
        this.add(label, c);

        c.gridy = 7;
        this.add(this.fireYPosition, c);

        c.gridy = 8;
        this.add(this.backgroundImage, c);

        c.gridy = 9;
        this.add(this.backgroundInfo, c);
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

    public void setFireHeight(JFormattedTextField fireHeight) {
        this.fireHeight = fireHeight;
    }

    public JButton getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(JButton backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public JTextArea getBackgroundInfo() {
        return backgroundInfo;
    }

    public void setBackgroundInfo(JTextArea backgroundInfo) {
        this.backgroundInfo = backgroundInfo;
    }
}
