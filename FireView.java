import javax.swing.*;
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



        GridBagConstraints viewerConstraints = new GridBagConstraints();
        viewerConstraints.anchor = GridBagConstraints.NORTHWEST;
        viewerConstraints.fill = GridBagConstraints.BOTH;
        viewerConstraints.gridx = 1;
        viewerConstraints.gridy = 0;
        viewerConstraints.gridheight = 3;
        viewerConstraints.weightx = 1;
        viewerConstraints.weighty = 1;

        panel.add(this.Viewer, viewerConstraints);
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
                this.Viewer.paintBackground();
                this.Viewer.showBg();
                break;
            case "Apply":
                this.Viewer.getDTOGeneralParameters().setFireHeight((int) this.ControlPanel.getGeneralConfiguration().getFireHeight().getValue());
                this.Viewer.getDTOGeneralParameters().setFireWidth((int) this.ControlPanel.getGeneralConfiguration().getFireWidth().getValue());
                this.Viewer.getDTOGeneralParameters().setFireXPosition((int) this.ControlPanel.getGeneralConfiguration().getFireXPosition().getValue());
                this.Viewer.getDTOGeneralParameters().setFireYPosition((int) this.ControlPanel.getGeneralConfiguration().getFireYPosition().getValue());
                defaultTextValues();
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
                }
                this.Viewer.paintBackground();
                defaultTextValues();
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
