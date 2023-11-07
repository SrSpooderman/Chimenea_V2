import java.awt.*;
import java.io.File;

import static java.lang.Thread.sleep;

public class FireController {
    private FireView FireView;
    private FireModel FireModel;
    private DTOGeneralParameters DTOGeneralParameters;
    private DTOTemperatureParameters DTOTemperatureParameters;
    private DTOPaletteParameters DTOPaletteParameters;

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

        DTOPaletteParameters = new DTOPaletteParameters();
        DTOPaletteParameters.addColorTarget(new ColorTarget(255,new Color(255,255,255,255)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(54,new Color(0, 0, 0,100)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(59,new Color(155, 0, 0,110)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(72,new Color(200, 100, 0,180)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(112,new Color(235,235 , 40,250)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(129,new Color(255, 255, 200,255)));
        DTOPaletteParameters.addColorTarget(new ColorTarget(149,new Color(255, 255, 255,255)));

        this.FireModel = new FireModel(this.DTOTemperatureParameters,this.DTOPaletteParameters,this.DTOGeneralParameters.getFireWidth(), this.DTOGeneralParameters.getFireHeight());
        this.FireView = new FireView(this.DTOGeneralParameters,FireModel);
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
