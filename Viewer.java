import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

public class Viewer extends Canvas {
    private BufferedImage backgroundImg;
    private FireModel foregroundImg;
    private BufferStrategy bs;
    private int posx;
    private int posy;

    public Viewer(int pixelW, int pixelH, FireModel foregroundImg) {
        Dimension d = new Dimension(pixelW, pixelH);
        this.setPreferredSize(d);
        this.loadBackground();
        this.posx= 0;
        this.posy = 0;
        this.foregroundImg = foregroundImg;
        this.bs = null;
    }

    public void paintBackground(){
        if (this.bs == null){
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        bs.getDrawGraphics().drawImage(this.backgroundImg, 0,0,this.getWidth(),this.getHeight(),null);
        bs.show();
        bs.getDrawGraphics().dispose();
    }

    public void paintForeground(){
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        bs.getDrawGraphics().drawImage(
                this.foregroundImg,
                (int) (this.getWidth() / 2.3273)+posx,
                (int) (this.getHeight() / 1.6516)-posy,
                (int) (this.getWidth() / 2.44),
                (int) (this.getHeight() / 5.3895),
                null);
        this.foregroundImg.next();

        bs.show();
        bs.getDrawGraphics().dispose();
    }

    private void loadBackground(){
        try{
            this.backgroundImg = ImageIO.read(new File("C:/Users/pfran/Downloads/bg.jpg"));
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

    public FireModel getForegroundImg() {
        return foregroundImg;
    }

    public void setForegroundImg(FireModel foregroundImg) {
        this.foregroundImg = foregroundImg;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}
