import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserPanel extends JPanel {
    private Color selectedColor;

    public ColorChooserPanel(){
        selectedColor = JColorChooser.showDialog(ColorChooserPanel.this, "Elegir Color", selectedColor);
    }

    Color getColor() {
        return selectedColor;
    }

    void setColor(Color color) {
        selectedColor = color;
    }
}
