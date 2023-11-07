import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ColorChooserRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Color) {
            component.setBackground((Color) value);
            component.setForeground(new Color(255,255,255,0));
        }
        return component;
    }
}
