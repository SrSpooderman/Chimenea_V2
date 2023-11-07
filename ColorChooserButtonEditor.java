import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserButtonEditor extends DefaultCellEditor {
    protected JButton button;

    public ColorChooserButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setText("Erase");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        button.setText("Erase");
        return button;
    }
}
