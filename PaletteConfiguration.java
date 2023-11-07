import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PaletteConfiguration extends JPanel {
    private JButton buttonAddPalette;
    private JTable TableColor;
    private JScrollPane TableScroll;

    public PaletteConfiguration() {
        buttonAddPalette = new JButton("Añadir Target");
        TableColor = new JTable();
        Object[][] data = {};

        String[] columnNames = {"TargetColor", "Temperature", "Erase"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Color.class : Integer.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                int tempvalue = (int) this.getValueAt(row,1);
                if (tempvalue == 255 | tempvalue == 0){
                    return false;
                } else if (row == getRowCount()) {
                    return false;
                }
                return true;
            }
        };

        this.TableColor = new JTable(model);
        TableColumn colorColumn = this.TableColor.getColumn("TargetColor");
        colorColumn.setCellEditor(new ColorChooserEditor());
        colorColumn.setCellRenderer(new ColorChooserRenderer());

        this.TableColor.getColumn("Erase").setCellRenderer(new ColorChooserButtonRenderer());
        this.TableColor.getColumn("Erase").setCellEditor(new ColorChooserButtonEditor(new JCheckBox(),TableColor));

        this.buttonAddPalette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) TableColor.getModel();
                model.insertRow(1,new Object[]{(Color)Color.WHITE,(Integer)1});
            }
        });

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
        this.TableScroll = new JScrollPane(TableColor);
        this.TableColor.getColumnModel().getColumn(0).setMaxWidth(50);
        this.TableScroll.getViewport().setPreferredSize(new Dimension(TableColor.getPreferredScrollableViewportSize().width,TableColor.getRowHeight()*5));
        this.TableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(TableScroll,c);
        c.gridy =2;
        this.add(this.buttonAddPalette,c);
    }

    public JTable getTableColor() {
        return TableColor;
    }

    public void Clear_Table(){
        for (int i = 0; i < TableColor.getRowCount(); i++) {
            DefaultTableModel model = (DefaultTableModel) this.TableColor.getModel();
            model.removeRow(i);
            i-=1;
        }
    }

    public void setTableColor(JTable tableColor) {
        TableColor = tableColor;
    }
}
