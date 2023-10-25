import static java.lang.Thread.sleep;

public class FireController {
    private FireView FireView;
    private DTOGeneralParameters DTOGeneralParameters;

    public FireController() {
        DTOGeneralParameters = new DTOGeneralParameters(
                430,
                200,
                420,
                475);
        DTOGeneralParameters.setFireModel(new FireModel(DTOGeneralParameters.getFireWidth(), DTOGeneralParameters.getFireHeight()));
        initClass();
    }

    private void initClass(){
        this.FireView = new FireView(this.DTOGeneralParameters);
    }

    public void main(){
        FireView.setVisible(true);
        playAnimation();
    }

    public void playAnimation(){
        while (true) {
            if (this.FireView.getControlPanel().getAnimationControls().getPlayPause().isSelected()){
                this.FireView.getViewer().paintBackground();
                this.FireView.getViewer().paintForeground();
            }
            try {
                sleep(20);
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
    }
}
