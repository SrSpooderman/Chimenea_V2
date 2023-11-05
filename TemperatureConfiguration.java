import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class TemperatureConfiguration extends JPanel {
    private JSlider coolPixelsPercentage;
    private JLabel coolPixelLabel;
    private JSlider hotPixelsPercentage;
    private JLabel hotPixelLabel;
    private JTable cellsPonderation;
    private JFormattedTextField cellsDivider;
    private JFormattedTextField fixAtenuationFactor;
    private JToggleButton bottonUpTemps;

    public TemperatureConfiguration(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00000");
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setValueClass(Double.class);
        formatter.setMinimum(0.00000);

        this.coolPixelLabel = new JLabel("CoolPixel:");
        this.hotPixelLabel = new JLabel("HotPixel:");
        this.coolPixelsPercentage = new JSlider(0,100);
        this.hotPixelsPercentage = new JSlider(0,100);

        this.cellsDivider = new JFormattedTextField(formatter);
        this.fixAtenuationFactor = new JFormattedTextField(formatter);
        this.bottonUpTemps = new JToggleButton("Arriba/abajo");

        Object[][] data = {
                {1.1, 2.2},
                {3.3, 4.4},
                {5.5, 6.6}
        };
        DefaultTableModel model = new DefaultTableModel(data, 2) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Double.class; // Establecer el tipo de datos de las columnas como Double
            }
        };
        this.cellsPonderation = new JTable(model);


        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        this.add(coolPixelLabel, c);
        c.gridy =1;
        this.add(this.coolPixelsPercentage, c);
        c.gridy =2;
        this.add(hotPixelLabel, c);
        c.gridy =3;
        this.add(this.hotPixelsPercentage, c);
        c.gridy =4;
        this.add(new JLabel("CellsDivider"), c);
        c.gridy =5;
        this.add(this.cellsDivider, c);
        c.gridy =6;
        this.add(new JLabel("AtenuationFactor"),c);
        c.gridy =7;
        this.add(this.fixAtenuationFactor,c);
        c.gridy =8;
        this.add(this.bottonUpTemps,c);
        c.gridy =9;
        this.add(new JLabel("Cells Poderation"),c);
        c.gridy = 10;
        this.add(this.cellsPonderation,c);
    }

    public JSlider getCoolPixelsPercentage() {
        return coolPixelsPercentage;
    }

    public void setCoolPixelsPercentage(JSlider coolPixelsPercentage) {
        this.coolPixelsPercentage = coolPixelsPercentage;
    }

    public JLabel getCoolPixelLabel() {
        return coolPixelLabel;
    }

    public void setCoolPixelLabel(String text) {
        this.coolPixelLabel.setText(text);
    }

    public JSlider getHotPixelsPercentage() {
        return hotPixelsPercentage;
    }

    public void setHotPixelsPercentage(JSlider hotPixelsPercentage) {
        this.hotPixelsPercentage = hotPixelsPercentage;
    }

    public JLabel getHotPixelLabel() {
        return hotPixelLabel;
    }

    public void setHotPixelLabel(String text) {
        this.hotPixelLabel.setText(text);
    }

    public JTable getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(JTable cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public JFormattedTextField getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(JFormattedTextField cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public JFormattedTextField getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }

    public void setFixAtenuationFactor(JFormattedTextField fixAtenuationFactor) {
        this.fixAtenuationFactor = fixAtenuationFactor;
    }

    public JToggleButton getBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(JToggleButton bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
    }
}
