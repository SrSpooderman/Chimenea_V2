import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorChooserButtonRenderer extends JButton implements TableCellRenderer {
    public ColorChooserButtonRenderer() {
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText("Erase");
        return this;
    }
}
