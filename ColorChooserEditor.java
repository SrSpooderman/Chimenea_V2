import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ColorChooserEditor extends AbstractCellEditor implements TableCellEditor {
    private ColorChooserPanel colorChooserPanel;
    private Color selectedColor;

    ColorChooserEditor() {

    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.colorChooserPanel = new ColorChooserPanel();
        this.selectedColor = (Color) value;
        return colorChooserPanel;
    }

    @Override
    public Object getCellEditorValue() {
        return colorChooserPanel.getColor();
    }

}
