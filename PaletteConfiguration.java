import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PaletteConfiguration extends JPanel {
    private JTable TableColor;

    public PaletteConfiguration() {
        TableColor = new JTable();
        Object[][] data = {
                {Color.RED, 10},
                {Color.GREEN, 20},
                {Color.BLUE, 30},
                {Color.RED, 10},
                {Color.GREEN, 20},
                {Color.BLUE, 30},
                {Color.RED, 10},
                {Color.GREEN, 20}
        };

        String[] columnNames = {"TargetColor", "Temperature"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Color.class : Integer.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        this.TableColor = new JTable(model);
        TableColumn colorColumn = this.TableColor.getColumnModel().getColumn(0);
        colorColumn.setCellEditor(new ColorChooserEditor());
        colorColumn.setCellRenderer(new ColorChooserRenderer());

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        this.add(new JLabel("Paleta de colores"),c);
        c.gridy = 1;
        this.add(TableColor,c);
    }

    public JTable getTableColor() {
        return TableColor;
    }

    public void setTableColor(JTable tableColor) {
        TableColor = tableColor;
    }
}
