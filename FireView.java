import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FireView extends JFrame implements ItemListener, ActionListener, ComponentListener {
    private DTOGeneralParameters DTOGeneralParameters;
    private ControlPanel ControlPanel;
    private Viewer Viewer;


    public FireView(DTOGeneralParameters DTOGeneralParameters, FireModel FireModel) {
        this.DTOGeneralParameters = DTOGeneralParameters;

        this.Viewer = new Viewer(DTOGeneralParameters, FireModel);

        this.ControlPanel = new ControlPanel();
        this.configureJFrame();
        this.pack();
    }

    private void configureJFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
        this.addUIComponents();
    }

    private void addUIComponents(){
        this.ControlPanel.getAnimationControls().getApply().addActionListener(this);
        this.ControlPanel.getAnimationControls().getPlayPause().addActionListener(this);
        this.ControlPanel.getAnimationControls().getStopButton().addActionListener(this);
        this.ControlPanel.getGeneralConfiguration().getBackgroundImage().addActionListener(this);

        Container panel;
        panel = this.getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        panel.add(this.ControlPanel.getAnimationControls(), c);
        c.gridy = 1;
        panel.add(this.ControlPanel.getGeneralConfiguration(), c);
        c.gridy = 2;
        panel.add(this.ControlPanel.getTemperatureConfiguration(),c);
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 3;
        panel.add(this.ControlPanel.getPaletteConfiguration(),c);



        GridBagConstraints viewerConstraints = new GridBagConstraints();
        viewerConstraints.anchor = GridBagConstraints.NORTHWEST;
        viewerConstraints.fill = GridBagConstraints.BOTH;
        viewerConstraints.gridx = 1;
        viewerConstraints.gridy = 0;
        viewerConstraints.gridheight = 3;
        viewerConstraints.weightx = 1;
        viewerConstraints.weighty = 1;

        panel.add(this.Viewer, viewerConstraints);

        //
        this.ControlPanel.getTemperatureConfiguration().getCoolPixelsPercentage().addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        ControlPanel.getTemperatureConfiguration().setCoolPixelLabel("CoolPixel: "+
                                ControlPanel.getTemperatureConfiguration().getCoolPixelsPercentage().getValue());
                    }
                }
        );

        this.ControlPanel.getTemperatureConfiguration().getHotPixelsPercentage().addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        ControlPanel.getTemperatureConfiguration().setHotPixelLabel("HotPixel: "+
                                ControlPanel.getTemperatureConfiguration().getHotPixelsPercentage().getValue());
                    }
                }
        );
    }

    private JPanel createButtonLabelPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;

        panel.add(this.ControlPanel.getAnimationControls(), c);

        c.gridy = 1;
        c.weighty = 1;
        panel.add(this.ControlPanel.getGeneralConfiguration(),c);


        return panel;
    }


    public ControlPanel getControlPanel() {
        return ControlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        ControlPanel = controlPanel;
    }

    public Viewer getViewer() {
        return Viewer;
    }

    public void setViewer(Viewer viewer) {
        Viewer = viewer;
    }

    private void defaultTextValues(){
        this.ControlPanel.getGeneralConfiguration().getFireHeight().setValue(this.DTOGeneralParameters.getFireHeight());
        this.ControlPanel.getGeneralConfiguration().getFireWidth().setValue(this.DTOGeneralParameters.getFireWidth());
        this.ControlPanel.getGeneralConfiguration().getFireXPosition().setValue(this.DTOGeneralParameters.getFireXPosition());
        this.ControlPanel.getGeneralConfiguration().getFireYPosition().setValue(this.DTOGeneralParameters.getFireYPosition());
        this.ControlPanel.getGeneralConfiguration().getBackgroundInfo().setText(this.Viewer.getDTOGeneralParameters().getBackgroundImage().getName()+"\n"+
                                                                                this.Viewer.getDTOGeneralParameters().getBackgroundImage().getParentFile().getName()+"\n"+
                                                                                this.Viewer.getBackgroundImg().getHeight()+
                                                                                "x"+this.Viewer.getBackgroundImg().getWidth());

        this.ControlPanel.getTemperatureConfiguration().getCoolPixelLabel().setText("CoolPixel: "+
                ControlPanel.getTemperatureConfiguration().getCoolPixelsPercentage().getValue());
        this.ControlPanel.getTemperatureConfiguration().getCoolPixelsPercentage().setValue(this.Viewer.getForegroundImg().getTemperatures().getDTOTemperatureParameters().getCoolPixelPercentage());
        this.ControlPanel.getTemperatureConfiguration().getHotPixelLabel().setText("HotPixel: "+
                ControlPanel.getTemperatureConfiguration().getHotPixelsPercentage().getValue());
        this.ControlPanel.getTemperatureConfiguration().getHotPixelsPercentage().setValue(this.Viewer.getForegroundImg().getTemperatures().getDTOTemperatureParameters().getHotPixelPercentage());
        this.ControlPanel.getTemperatureConfiguration().getCellsDivider().setValue(this.Viewer.getForegroundImg().getTemperatures().getDTOTemperatureParameters().getCellsDivider());
        this.ControlPanel.getTemperatureConfiguration().getFixAtenuationFactor().setValue(this.Viewer.getForegroundImg().getTemperatures().getDTOTemperatureParameters().getAtenuationFactor());

        int count = 0;
        for (double number : this.Viewer.getForegroundImg().getTemperatures().getDTOTemperatureParameters().getCellPonderation()){
            int row = count / 3;
            int column = count % 3;
            this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().setValueAt(number, row, column);
            count++;
        }
        count = 0;
        for (ColorTarget colorTarget : this.Viewer.getForegroundImg().getPalette().getDtoPaletteParameters().getColorsTarget()){
            this.ControlPanel.getPaletteConfiguration().getTableColor().getModel().setValueAt(colorTarget.getColor(),count,0);
            this.ControlPanel.getPaletteConfiguration().getTableColor().getModel().setValueAt(colorTarget.getTemperature(),count,1);
            count++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.Viewer.paintBackground();
                this.Viewer.showBg();
                defaultTextValues();
                break;
            case "Stop":
                this.ControlPanel.getAnimationControls().getPlayPause().setSelected(false);
                break;
            case "Apply":
                this.Viewer.getDTOGeneralParameters().setFireHeight((int) this.ControlPanel.getGeneralConfiguration().getFireHeight().getValue());
                this.Viewer.getDTOGeneralParameters().setFireWidth((int) this.ControlPanel.getGeneralConfiguration().getFireWidth().getValue());
                this.Viewer.getDTOGeneralParameters().setFireXPosition((int) this.ControlPanel.getGeneralConfiguration().getFireXPosition().getValue());
                this.Viewer.getDTOGeneralParameters().setFireYPosition((int) this.ControlPanel.getGeneralConfiguration().getFireYPosition().getValue());

                DTOTemperatureParameters DTOTemp = new DTOTemperatureParameters(
                        this.ControlPanel.getTemperatureConfiguration().getCoolPixelsPercentage().getValue(),
                        this.ControlPanel.getTemperatureConfiguration().getHotPixelsPercentage().getValue(),
                        new double[] {(double) this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(0,0),
                                (double)this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(0,1),
                                (double) this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(0,2),
                                (double) this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(1,0),
                                (double) this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(1,1),
                                (double) this.ControlPanel.getTemperatureConfiguration().getCellsPonderation().getModel().getValueAt(1,2)},
                        (double) this.ControlPanel.getTemperatureConfiguration().getCellsDivider().getValue(),
                        (double) this.ControlPanel.getTemperatureConfiguration().getFixAtenuationFactor().getValue(),
                        this.ControlPanel.getTemperatureConfiguration().getBottonUpTemps().isSelected());
                DTOPaletteParameters DTOPalette = new DTOPaletteParameters();

                for (int row = 1; row < 8; row++){
                    DTOPalette.addColorTarget(new ColorTarget(
                            (Integer) this.ControlPanel.getPaletteConfiguration().getTableColor().getModel().getValueAt(row,1),
                            (Color) this.ControlPanel.getPaletteConfiguration().getTableColor().getModel().getValueAt(row,0)
                    ));
                }

                this.Viewer.setForegroundImg(new FireModel(DTOTemp,DTOPalette,
                        (int) this.ControlPanel.getGeneralConfiguration().getFireWidth().getValue(),
                        (int) this.ControlPanel.getGeneralConfiguration().getFireHeight().getValue()));

                defaultTextValues();
                this.Viewer.paintBackground();
                this.Viewer.paintForeground();
                break;
            case "Selecciona Imagen":
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File file) {
                        return file.getName().toLowerCase().endsWith(".jpg")
                                || file.getName().toLowerCase().endsWith(".jpeg")
                                || file.getName().toLowerCase().endsWith(".png")
                                || file.isDirectory();
                    }

                    public String getDescription() {
                        return "Archivos de Imagen (*.jpg, *.jpeg, *.png)";
                    }
                });

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    this.Viewer.getDTOGeneralParameters().setBackgroundImage(selectedFile);
                    defaultTextValues();
                }
                this.Viewer.paintBackground();
                break;
            default:
            System.err.println("Acción NO tratada: " + e);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int estado = e.getStateChange();
        if (estado == ItemEvent.SELECTED) {

        } else {

        }
    }
}
