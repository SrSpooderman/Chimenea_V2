import java.io.File;

import static java.lang.Thread.sleep;

public class FireController {
    private FireView FireView;
    private FireModel FireModel;
    private DTOGeneralParameters DTOGeneralParameters;

    public FireController() {
        DTOGeneralParameters = new DTOGeneralParameters(
                430,
                200,
                420,
                475,
                new File("C:/Users/pfran/Pictures/unnamed.jpg"));
        FireModel = new FireModel(DTOGeneralParameters.getFireWidth(), DTOGeneralParameters.getFireHeight());
        initClass();
    }

    private void initClass(){
        this.FireView = new FireView(this.DTOGeneralParameters, FireModel);
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
