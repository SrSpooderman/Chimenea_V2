import static java.lang.Thread.sleep;

public class FireController {
    private FireView FireView;
    private FireModel FireModel;

    public FireController() {
        initClass();
    }

    private void initClass(){
        this.FireModel = new FireModel(200,200);
        this.FireView = new FireView(new Viewer(1000,1000,FireModel));
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
                sleep(100);
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
    }
}
