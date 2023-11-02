import java.io.File;

import static java.lang.Thread.sleep;

public class FireController {
    private FireView FireView;
    private FireModel FireModel;
    private DTOGeneralParameters DTOGeneralParameters;
    private DTOTemperatureParameters DTOTemperatureParameters;

    public FireController() {
        DTOGeneralParameters = new DTOGeneralParameters(
                430,
                200,
                420,
                475,
                new File("C:/Users/pfran/Pictures/unnamed.jpg"));

        DTOTemperatureParameters = new DTOTemperatureParameters(
                9,
                3,
                new double[] {1.2D,1.5D,1.2D,0.7D,0.7D,0.7D},
                5.98569D,
                1.8D,
                true);

        this.FireModel = new FireModel(this.DTOTemperatureParameters,this.DTOGeneralParameters.getFireWidth(), this.DTOGeneralParameters.getFireHeight());
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
