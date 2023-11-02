import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

public class Viewer extends Canvas {
    private DTOGeneralParameters DTOGeneralParameters;
    private BufferedImage backgroundImg;
    private BufferStrategy bs;
    private FireModel foregroundImg;

    public Viewer(DTOGeneralParameters DTOGeneralParameters, FireModel FireModel) {
        Dimension d = new Dimension(500, 500);
        this.setPreferredSize(d);

        this.DTOGeneralParameters = DTOGeneralParameters;
        this.loadBackground();
        this.foregroundImg = FireModel;
        this.bs = null;
    }

    public void paintBackground(){
        this.loadBackground();

        if (this.bs == null){
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        bs.getDrawGraphics().drawImage(this.backgroundImg, 0,0,this.getWidth(),this.getHeight(),null);
        bs.getDrawGraphics().dispose();
    }
    public void showBg(){
        bs.show();
    }
    public void paintForeground(){
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        bs.getDrawGraphics().drawImage(
                this.foregroundImg,
                this.DTOGeneralParameters.getFireXPosition(),
                this.DTOGeneralParameters.getFireYPosition(),
                this.DTOGeneralParameters.getFireWidth(),
                this.DTOGeneralParameters.getFireHeight(),
                null);

        this.foregroundImg.next();

        bs.show();
        bs.getDrawGraphics().dispose();
    }

    private void loadBackground(){
        try{
            this.backgroundImg = ImageIO.read(this.DTOGeneralParameters.getBackgroundImage());
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public BufferedImage getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(BufferedImage backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public DTOGeneralParameters getDTOGeneralParameters() {
        return DTOGeneralParameters;
    }

    public void setDTOGeneralParameters(DTOGeneralParameters DTOGeneralParameters) {
        this.DTOGeneralParameters = DTOGeneralParameters;
    }

    public FireModel getForegroundImg() {
        return foregroundImg;
    }

    public void setForegroundImg(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;
    }
}
