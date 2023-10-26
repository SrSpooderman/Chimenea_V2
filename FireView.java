import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        Container panel;
        panel = this.getContentPane();

        GridBagConstraints buttonLabelConstraints = new GridBagConstraints();
        buttonLabelConstraints.anchor = GridBagConstraints.NORTHWEST;
        buttonLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        buttonLabelConstraints.gridx = 0;
        buttonLabelConstraints.gridy = 0;
        buttonLabelConstraints.weightx = 0;
        buttonLabelConstraints.weighty = 0;

        panel.add(createButtonLabelPanel(), buttonLabelConstraints);


        GridBagConstraints viewerConstraints = new GridBagConstraints();
        viewerConstraints.anchor = GridBagConstraints.NORTHWEST;
        viewerConstraints.fill = GridBagConstraints.BOTH;
        viewerConstraints.gridx = 1;
        viewerConstraints.gridy = 0;
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

        this.ControlPanel.getAnimationControls().setPlayPause(new JToggleButton("Play"));
        this.ControlPanel.getAnimationControls().getPlayPause().addActionListener(this);
        panel.add(this.ControlPanel.getAnimationControls().getPlayPause(), c);


        c.gridy = 1;
        this.ControlPanel.getAnimationControls().setStopButton(new JButton("Stop"));
        this.ControlPanel.getAnimationControls().getStopButton().addActionListener(this);
        panel.add(this.ControlPanel.getAnimationControls().getStopButton(), c);

        c.gridy = 2;
        JLabel label = new JLabel("Fire Height:");
        panel.add(label, c);

        c.gridy = 3;
        panel.add(this.ControlPanel.getGeneralConfiguration().getFireHeight(), c);

        c.gridy = 4;
        label = new JLabel("Fire Width:");
        panel.add(label, c);

        c.gridy = 5;
        panel.add(this.ControlPanel.getGeneralConfiguration().getFireWidth(), c);

        c.gridy = 6;
        label = new JLabel("Fire X Position:");
        panel.add(label, c);

        c.gridy = 7;
        panel.add(this.ControlPanel.getGeneralConfiguration().getFireXPosition(), c);

        c.gridy = 8;
        label = new JLabel("Fire Y Position:");
        panel.add(label, c);

        c.gridy = 9;
        panel.add(this.ControlPanel.getGeneralConfiguration().getFireYPosition(), c);

        c.gridy = 10;
        this.ControlPanel.getAnimationControls().setApply(new JButton("Apply"));
        this.ControlPanel.getAnimationControls().getApply().addActionListener(this);
        panel.add(this.ControlPanel.getAnimationControls().getApply(), c);

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
                this.Viewer.getDTOGeneralParameters().setFireHeight((int)this.ControlPanel.getGeneralConfiguration().getFireHeight().getValue());
                this.Viewer.getDTOGeneralParameters().setFireWidth((int)this.ControlPanel.getGeneralConfiguration().getFireWidth().getValue());
                this.Viewer.getDTOGeneralParameters().setFireXPosition((int)this.ControlPanel.getGeneralConfiguration().getFireXPosition().getValue());
                this.Viewer.getDTOGeneralParameters().setFireYPosition((int)this.ControlPanel.getGeneralConfiguration().getFireYPosition().getValue());

                this.Viewer.paintForeground();
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
